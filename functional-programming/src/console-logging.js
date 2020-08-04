const logDouble = (number) => {
  const f = x => x + x;

  const fName = 'double';
  const fResult = f(number);
  console.log(`The ${fName} of ${number} is ${fResult}`);
};

const logFactorial = (number) => {
  const f = x => {
    let factorial = 1;
    for (let n = x; n > 0; n--) {
      factorial *= n;
    }
    return factorial;
  };

  const fName = 'factorial';
  const fResult = f(number);
  console.log(`The ${fName} of ${number} is ${fResult}`);
};

const logResult = (number, f, fName) => {
  // const f = x => {
  //   let factorial = 1;
  //   for (let n = x; n > 0; n--) {
  //     factorial *= n;
  //   }
  //   return factorial;
  // };

  // const fName = 'factorial';
  const fResult = f(number);
  console.log(`The ${fName} of ${number} is ${fResult}`);
};

logDouble(10);
logFactorial(10);

logResult(10, x => x + x, 'double');

const factorial = x => {
  let factorial = 1;
  for (let n = x; n > 0; n--) {
    factorial *= n;
  }
  return factorial;
};

logResult(10, factorial, 'factorial');

logResult(10, x => x * x * x, 'cube');
