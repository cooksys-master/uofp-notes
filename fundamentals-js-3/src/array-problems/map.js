// inputs: an array of values
// outputs: an array of values

// steps to implement
// 1. iterate over the input array
// ?. transform each element in some way
// n. return the result array of transformed values

function doubleAll (arr) {
  // inputs: an array of numbers
  // outputs: an array of doubled numbers

  // steps to implement
  // 1. create a result array
  const result = [];
  // 2. iterate over the input array
  for (const n of arr) {
    // 3. transform each element by doubling it
    const doubled = n * 2;
    // 4. add the transformed value to the result array
    result.push(doubled);
  }

  // 5. return the result array of transformed values
  return result;
}

function getAllPrices (arr) {
  // inputs: an array of items  ({ price: number })
  // outputs: an array of prices (number)

  // steps to implement
  // 1. create a result array
  const result = [];
  // 2. iterate over the input array
  for (const item of arr) {
    // 3. transform each element in some way
    const { price } = item;
    // 4. add the transformed value to the result array
    result.push(price);
  }

  // 5. return the result array of transformed values
  return result;
}

// equivalent:
const items = [{ price: 10 }];
items.map(item => item.price);
