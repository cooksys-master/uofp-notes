// const doubleNumberArray = (array) => {
//   const f = x => x * 2;
//   const result = [];
//   for (const elem of array) {
//     result.push(f(elem));
//   }
//   return result;
// };

// const cubeNumberArray = (array) => {
//   const f = x => x * x * x;
//   const result = [];
//   for (const elem of array) {
//     result.push(f(elem));
//   }
//   return result;
// };

const myMap = (array, f) => {
  const result = [];
  for (const elem of array) {
    result.push(f(elem));
  }
  return result;
};

const array = [0.1, 0.2, 0.3, 0.4, 0.5];
// result[0] = double(array[0])
// result[1] = double(array[1])
// result[2] = double(array[2])
// result[3] = double(array[3])
// result[4] = double(array[4])
console.log('myMap');
console.log(myMap(array, x => x * 2));
console.log(myMap(array, x => x * x * x));

const factorial = x => {
  let factorial = 1;
  for (let n = x; n > 0; n--) {
    factorial *= n;
  }
  return factorial;
};

console.log(myMap(array, factorial));

console.log('.map');
console.log(array.map(x => x * 2));
console.log(array.map(x => x * x * x));
console.log(array.map(factorial));

console.log('transformed1');
const transformed1 =
  array.map(x => x * 2)
    .map(x => x * x * x)
    .map(factorial);
console.log(transformed1);

console.log('transformed2');
const transformed2 =
    array.map(x => x * 100)
      .map(x => x + '%');

console.log(transformed2);
