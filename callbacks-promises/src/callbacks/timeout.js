
console.log('first');
setTimeout(
  () => console.log('second'),
  1
);
setTimeout(
  () => console.log('third'),
  4
);
setTimeout(
  () => console.log('fourth'),
  6
);
console.log('fifth');
