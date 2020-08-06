import fs, { writeFile } from 'fs';
import path from 'path';

const obj = JSON.parse(`
{
  "hello": "world",
  "numbers": [
    1,
    2,
    3
  ]
}
`);

console.log(obj);
console.log(obj.hello);
console.log(obj.numbers);

console.log(JSON.stringify(obj));

const pathToFile = path.resolve(__dirname, 'data.json');
const callback = (err, data) => {
  console.log('inside of callback');
  if (err) {
    // handle the error
    console.error(err);
  } else {
    const object = JSON.parse(data);
    console.log(object);
  }
};

fs.readFile(pathToFile, callback);
console.log('Immediately after readFile');

let jsonData;
fs.readFile(pathToFile, (err, data) => {
  if (err) {
    // handle your errors!
  } else {
    jsonData = JSON.parse(data);
  }
});

console.log('jsonData: ' + jsonData);
// writeFile(pathToFile, jsonData, () => {})
