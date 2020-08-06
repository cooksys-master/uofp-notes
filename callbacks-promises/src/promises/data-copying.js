import fs from 'fs';
import path, { parse } from 'path';
import util from 'util';

const pathToFile = path.resolve(__dirname, 'data1.json');
const pathToCopy = path.resolve(__dirname, 'data-copy.json');

const trace = tag => x => {
  console.log(tag + ': ' + util.inspect(x));
  return x;
};
const readFileP = util.promisify(fs.readFile);
const writeFileP = util.promisify(fs.writeFile);

// read the JSON data from the file
readFileP(pathToFile) // Promise<Buffer>
  .then(trace('after file read'))
// turn that JSON data into a JS object
  .then((data) => JSON.parse(data)) // Promise<JS Object>
  .then(trace('after json parse'))
// double the number values in the internal array
  .then(obj => {
    return { ...obj, numbers: obj.numbers.map(x => x * 2) };
  }) // Promise<JS Object>
  .then(trace('after number doubling'))
// turn the result back into JSON
  .then(obj => JSON.stringify(obj)) // Promise<String>
  .then(trace('after stringify'))
// write the JSON to a copy of the original file
  .then(string => writeFileP(pathToCopy, string)) // Promise<undefined>
  .then(trace('after write file'))
// check to print the newly-written data
  .then(() => readFileP(pathToCopy)) // Promise<Buffer>
  .then('after read copy')
  .then(data => console.log(JSON.parse(data)))
  .catch(err => {
    console.log(err);
  });
