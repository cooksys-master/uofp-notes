const counter1 = {
  count: 0,
  increment () {
    this.count += 1;
  },
  getCount () {
    return this.count;
  }
};

console.log(counter1.getCount());
counter1.increment();
console.log(counter1.getCount());

const getCount = counter1.getCount;
const increment = counter1.increment;

// error! this is undefined
// console.log(getCount());
// console.log(increment());
// console.log(getCount());

const counter2 = {
  count: 2
};

console.log(getCount.call(counter2));
increment.call(counter2);
console.log(getCount.call(counter2));
