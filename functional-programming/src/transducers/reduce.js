const add = (result, elem) => result + elem;
const mul = (result, elem) => result * elem;

// const sum = (array) => {
//   const initialValue = 0;
//   const f = add;
//   let result = initialValue;
//   for (const elem of array) {
//     result = f(result, elem);
//     // result = f(result, elem)
//   }
//   return result;
// };

// const product = (array) => {
//   const initialValue = 1;
//   const f = mul;
//   let result = initialValue;
//   for (const elem of array) {
//     result = f(result, elem);
//   }
//   return result;
// };

const myReduce = (array, initialValue, f) => {
  let result = initialValue;
  for (const elem of array) {
    result = f(result, elem);
  }
  return result;
};

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
const strings = ['Hello', 'world', '!', 'Welcome to class!'];

console.log(myReduce(numbers, 1, (a, b) => a * b));
console.log(myReduce(numbers, 1, (result, elem) => result * elem));
console.log(myReduce(numbers, 1, mul));

console.log(myReduce(numbers, 0, (a, b) => a + b));
console.log(myReduce(strings, '', (a, b) => a + b));
