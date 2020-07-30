function characterOccurence (string) {
  // input: string of characters
  // output: object where each unique
  // character in the string is a key,
  // and the number of times that character occurs in the string as a value

  // create an empty result object
  const result = {};
  // iterate over the characters in the string
  for (const char of string) {
    // for each character:
    //  - lookup if it is already in the object as a key
    if (result[char] !== undefined) {
      //  - if it is, increment the value associated with that key
      result[char] = result[char] + 1;
    } else {
      //  - if not, add the to the object as a key, with the value 1
      result[char] = 1;
    }
  }

  // return the result object
  return result;
}

const occurance = characterOccurence('Hello, world!');

console.log(occurance);
console.log(Object.keys(occurance));
console.log(Object.values(occurance));
console.log(Object.entries(occurance));
console.log(Object.fromEntries([['key', 'value']]));
