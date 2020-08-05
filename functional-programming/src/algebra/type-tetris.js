// f: number -> number
const f = x => x * 2;
const f1 = x => x + 1;

// identity: a -> a
const identity = x => x;

// summing up some numbers
// 1 + 2 + 3 = 1 + 2 + 3 + 0 = 0 + 1 + 2 + 3
// sum's initial value should be 0

// product of some numbers
// 1 * 2 * 3 * 0 = 0
// 1 * 2 * 3 * 1 = 1 * 2 * 3 * 1 * 1 = 1 * 2 * 3 * 1 * 1 * 1

// ?: (f: b -> c, g: a -> b) -> ((x: a) -> c)
const something = function (f, g) {
  return function (x) {
    const middle = g(x);
    const result = f(middle);
    return result;
  };
};
// something & compose are exactly the same
const compose = (f, g) => x => f(g(x));

// exercise to the reader
// given double = x => x * 2
// prove: compose(double, identity) <=> double <=> compose(identity, double);

// second: (x: a) -> (y: b) -> b
const second = x => y => y;
