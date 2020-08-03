import { readFileSync } from 'fs';
import { get } from 'https';
import certifi from 'certifi';
import cToF from 'celsius-to-fahrenheit';

const cert = readFileSync(certifi);

const queryLocations = (queryString, callback) => {
  const httpRequest = get('https://www.metaweather.com/api/location/search/?query=' + queryString,
    { cert },
    (httpResponse) => {
      // console.log('statusCode:', httpResponse.statusCode);
      // console.log('headers:', httpResponse.headers);
      httpResponse.on('data', (d) => {
        // console.log(d.toString());
        // WE HAVE DATA HERE
        callback(null, d);
      });
    });

  httpRequest.on('error', (e) => {
    callback(e);
  });
  httpRequest.end();
};

const getCurrentYYYMMDD = () => {
  const today = new Date();
  const dd = String(today.getDate()).padStart(2, '0');
  const mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
  const yyyy = today.getFullYear();
  return `${yyyy}/${mm}/${dd}`;
};

const getConsolidatedForecast = ({ woeid }, callback) => {
  const url = `https://www.metaweather.com/api/location/${woeid}/`;
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
        callback(null, fullString);
      });
    });

  httpRequest.on('error', (e) => {
    callback(e);
  });
  httpRequest.end();
};

const getGetForecastHistory = ({ woeid, date = getCurrentYYYMMDD() }, callback) => {
  const url = `https://www.metaweather.com/api/location/${woeid}/${date}`;
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
        callback(null, fullString);
      });
    });

  httpRequest.on('error', (e) => {
    callback(e);
  });
  httpRequest.end();
};

const getFiveDayTemps = (location, callback) => {
  // query the given location
  queryLocations(location, (err, data) => {
    if (err) {
      callback(err);
    } else {
      // extract the woeid from the JSON data
      const [{ woeid }] = JSON.parse(data);
      // get the consolidated forecast for that woeid
      getConsolidatedForecast({ woeid }, (err, data) => {
        if (err) {
          callback(err);
        } else {
          // process result
          const { title, consolidated_weather } = JSON.parse(data);
          const result = Object.fromEntries(consolidated_weather.map(forecast => {
            const { the_temp, applicable_date } = forecast;
            return [applicable_date, cToF(the_temp)];
          }));
          result.title = title;
          // "return" the result
          callback(null, result);
        }
      });
    }
  });
};

getFiveDayTemps('phoenix', (err, data) => {
  if (err) {
    console.log(err);
  } else {
    console.log(data);
  }
});
getFiveDayTemps('memphis', (err, data) => {
  if (err) {
    console.log(err);
  } else {
    console.log(data);
  }
});
