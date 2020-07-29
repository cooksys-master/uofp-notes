const arr = [1, 2, 3, 4, 5, 6];

// let sum = 0;
// for (const n of arr) {
//   sum = sum + n;
// }
const sum = arr.reduce(
  (lastSum, nextElem) => lastSum + nextElem,
  0
);

console.log(sum);

// let product = 1;
// for (const n of arr) {
//   product *= n;
// }
const product = arr.reduce(
  (lastSum, nextElem) => lastSum * nextElem,
  1
);

console.log(product);
