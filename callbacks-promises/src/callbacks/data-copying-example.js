import fs from 'fs';
import path from 'path';

const pathToFile = path.resolve(__dirname, 'data.json');
const pathToCopy = path.resolve(__dirname, 'data-copy.json');

// read the JSON data from the file
fs.readFile(pathToFile, (err, data) => {
  if (err) {
    console.error(err);
  } else {
    // turn that JSON data into a JS object
    const obj = JSON.parse(data);
    // double the number values in the internal array
    const objCopy = {
      ...obj,
      numbers: obj.numbers.map(x => x * 2)
    };
    // turn the result back into JSON
    const jsonString = JSON.stringify(objCopy);
    // write the JSON to a copy of the original file
    fs.writeFile(pathToCopy, jsonString, (err) => {
      if (err) {
        console.error(err);
      } else {
        // check to print the newly-written data
        fs.readFile(pathToCopy, (err, data) => {
          if (err) {
            console.error(err);
          } else {
            console.log('written to file: ' + data.toString());
          }
        });
      }
    });
  }
});
