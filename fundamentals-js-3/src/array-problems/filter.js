function evensOnly (arr) {
  // const result = [];
  // for (const n of arr) {
  //   if (n % 2 === 0) {
  //     result.push(n);
  //   }
  // }
  // return result;
  return arr.filter(n => n % 2 === 0);
}

function oddsOnly (arr) {
  // const result = [];
  // for (const n of arr) {
  //   if (n % 2 !== 0) {
  //     result.push(n);
  //   }
  // }
  // return result;
  return arr.filter(n => n % 2 !== 0);
}
