// function double () {}

const lessThan = function (a, b) {
  const result = a < b;
  return result;
};

const lessThanArrow = (a, b) => {
  const result = a < b;
  return result;
};

const lessThanArrowNoCurlies = (a, b) => a < b;

const doubleArrow = a => a * 2;

const oneOrZero = (b) => {
  if (b) {
    return 1;
  } else {
    return 0;
  }
};
