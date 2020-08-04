// const logEachElement = (array) => {
//   const f = (elem) => console.log(elem);
//   for (const elem of array) {
//     f(elem);
//   }
// };

// const logFirstCharacter = (array) => {
//   const f = (elem) => console.log(elem.charAt(0));
//   for (const elem of array) {
//     f(elem);
//   }
// };

const myForEach = (array, f) => {
  // const f = (elem) => console.log(elem.charAt(0));
  for (const elem of array) {
    f(elem);
  }
};

myForEach([1, 2, 3], console.log);
myForEach(['Hello', 'World'], elem => console.log(elem.charAt(0)));

[1, 2, 3].forEach(elem => console.log(elem));
['Hello', 'World'].forEach(elem => console.log(elem.charAt(0)));
