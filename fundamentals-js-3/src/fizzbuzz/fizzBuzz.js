// if n divisible by 3 = message 'Fizz'
// if m divisible by 5 = message 'Buzz'
// if both = message 'FizzBuzz'
// if neither = no message

function fizzBuzz (start, end) {
  function getRange (start, end) {
    // inputs: the start and end numbers of a range of numbers
    // output: the range of numbers

    // steps to solve
    // 1. create a result array
    const result = [];
    // 2. iterate from start until end
    for (let n = start; n < end; n++) {
      // 3. add the each number to the result
      result.push(n);
    }
    // 4. return the result array
    return result;
  }

  function getMessage (number) {
    function divisibleBy (number, divisor) {
      // inputs: a number whose divisibility we want to check agains the divisor
      // outputs: true if number is divisible by divisor, false otherwise
      // 1. get the remainder of number divided by divisor
      const r = number % divisor;
      // 2. return true if that remainder equals zero
      return r === 0;
    }
    // inputs: a number to create a message for
    // outputs: an appropriate string message for the number

    // steps for our solution
    // 1. Create a result variable
    let result;

    // 2. Check cases for number
    if (divisibleBy(number, 3)) {
      //  if n divisible by 3 = message 'Fizz'
      result = 'Fizz';
    }

    if (divisibleBy(number, 5)) {
      //  if m divisible by 5 = message 'Buzz'
      result = 'Buzz';
    }

    if (divisibleBy(number, 3) && divisibleBy(number, 5)) {
      //  if both = message 'FizzBuzz'
      result = 'FizzBuzz';
    }

    //  if neither = no message - implied

    // 3. return the result message
    return result;
  }
  // inputs: the start and end numbers of a range of numbers to iterate
  // outputs: print to the console an appropriate message for each number

  // Steps to solve the problem
  // 1. get an array of numbers to iterate over
  const numbers = getRange(start, end);

  // 2. iterate over those numbers
  for (const number of numbers) {
    // 3. generate a message for each number
    const message = getMessage(number);

    // 4. print that message if it exists
    if (message !== undefined) {
      console.log(number + ': ' + message);
    }
  }
}

fizzBuzz(1, 115);
