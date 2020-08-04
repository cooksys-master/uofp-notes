// const onlyDivisibleBy3 = (array) => {
//   const f = elem => elem % 3 === 0;
//   const result = [];
//   for (const elem of array) {
//     if (f(elem)) {
//       result.push(elem);
//     }
//   }
//   return result;
// };

// const onlyDivisibleBy5 = (array) => {
//   const f = elem => elem % 5 === 0;
//   const result = [];
//   for (const elem of array) {
//     if (f(elem)) {
//       result.push(elem);
//     }
//   }
//   return result;
// };

// const lengthLessThan10 = (array) => {
//   const f = elem => elem.length < 10;
//   const result = [];
//   for (const elem of array) {
//     if (f(elem)) {
//       result.push(elem);
//     }
//   }
//   return result;
// };

const myFilter = (array, f) => {
  const result = [];
  for (const elem of array) {
    if (f(elem)) {
      result.push(elem);
    }
  }
  return result;
};

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
const strings = ['Hello', 'world', '!', 'Welcome to class!'];

console.log('myFilter');
console.log(myFilter(numbers, x => x % 3 === 0));
console.log(myFilter(numbers, x => x % 5 === 0));
console.log(myFilter(numbers, x => x % 2 === 0));
console.log(myFilter(numbers, x => x % 2 !== 0));
console.log(myFilter(strings, x => x.length < 10));
console.log(myFilter(strings, x => x.length > 10));
console.log(myFilter(strings, x => x.includes('o')));

numbers
  .filter(x => x % 3 === 0)
  .map(x => `${x}: Fizz`)
  .forEach(x => console.log(x));

const arr = [...'Hello world!'];
const res = arr.slice(3, 8);
//  output: ['l', 'o', ' ', 'w', 'o']
console.log(res);

// const filter = (array, f) => {
//   const result = [];
//   for (let i = 0; i < array.length; i++) {
//     const elem = array[i];
//     if (f(elem, i)) {
//       result.push(elem);
//     }
//   }
//   return result;
// };

console.log(arr.filter((elem, i) => i >= 3 && i < 8));

console.log(numbers.filter(() => Math.random() > 0.5));
