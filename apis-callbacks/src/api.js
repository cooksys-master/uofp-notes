import { promisify } from 'util';
import { readFile } from 'fs';
import { get } from 'https';
import certifi from 'certifi';
import cToF from 'celsius-to-fahrenheit';

const readFileP = promisify(readFile);
const certPromise = readFileP(certifi); // Promise<Buffer>

const getP = (url) =>
  certPromise // Promise<Buffer>
    .then(cert => new Promise((resolve, reject) => { // Promise<HTTP Response Body>
      const httpRequest = get(url,
        { cert },
        (httpResponse) => {
          // console.log('statusCode:', httpResponse.statusCode);
          // console.log('headers:', httpResponse.headers);
          let fullString = '';
          httpResponse.on('data', (d) => {
            // console.log(d.toString());
            // WE HAVE DATA HERE
            fullString += d.toString();
          });
          httpResponse.on('close', () => {
            resolve(fullString);
          });
        });

      httpRequest.on('error', (e) => {
        reject(e);
      });
      httpRequest.end();
    }));

export const queryLocations = (location) => getP('https://www.metaweather.com/api/location/search/?query=' + location);

export const getConsolidatedForecast = ({ woeid }) => getP(`https://www.metaweather.com/api/location/${woeid}/`);

export const getFiveDayForecast = location =>
  // query the given location
  queryLocations(location) // Promise<Http Response>
    // extract the woeid from the JSON data
    .then(data => {
      const [{ woeid }] = JSON.parse(data);
      return woeid;
    }) // Promise<number>
    // get the consolidated forecast for that woeid
    .then(woeid => getConsolidatedForecast({ woeid })) // Promise<Http Response>
    // process result
    .then(data => {
      const { title, consolidated_weather } = JSON.parse(data);
      const result = Object.fromEntries(consolidated_weather.map(forecast => {
        const { the_temp, applicable_date } = forecast;
        return [applicable_date, cToF(the_temp)];
      }));
      result.title = title;
      return result;
    }); // Promise<{ date: temp, title: string }>
