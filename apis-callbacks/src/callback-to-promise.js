// import './callback-based';

import { readFile } from 'fs';

// readFile :: (string, (err, data) -> undefined) -> undefined
// readFileP :: (string) -> Promise<data>

const readFileP = path => new Promise((resolve, reject) => {
  readFile(path, (err, data) => {
    if (err) {
      reject(err);
    } else {
      resolve(data);
    }
  });
});
