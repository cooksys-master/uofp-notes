const { startsWith } = require('ramda');

const arr = ['Hello!', 'Goodbye!', 'Hey.'];

for (const elem of arr) {
  console.log(elem);
}

// forEach is chainable!
arr
  .map(str => str.toUpperCase())
  .filter(str => str.startsWith('H'))
  .forEach(elem => {
    console.log(elem);
  });
