console.log('at the beginning of library');

let count = 0;

for (let i = 0; i < 20; i++) {
  console.log(i + ' inside of for loop');
  count += i;
}

module.exports = {
  count: count
};
