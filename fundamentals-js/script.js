console.log('Hello from node!')

// Java: type varName = value
// JavaScript: varKeyword varName = value
var x // = undefined

console.log(x)

x = 10

console.log(x)

x = 'Hello'

console.log(x)

x = { arr: [true, false, true] }

console.log(x)

for (var i = 0; i < 10; i++) {
  // do stuff
}
console.log(i)

if (true) {
  var x = 20
}

// let
for (let j = 0; j < 20; j++) {
  // do stuff
}
// console.log(j) results in error because j is out of scope

console.log(x)

// const
const y = 10

// y = 20 results in error because constants cannot be reassigned

// functions
function double (x) {
  return x * 2
}

console.log(double(10))
console.log(double(2.5))

console.log(double(10))
console.log(double(2.5))

// function values
let secondDouble = double

let thirdDouble = function (x) {
  return x * 2
}

// arrow functions
let fourthDouble = x => x * 2
