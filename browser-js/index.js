console.log(document.querySelectorAll('h3'));
const arr = Array.from(document.querySelectorAll('h3'));
console.log(arr);
arr.forEach(elem => console.log(elem));

const count = 0;

const counter = document.querySelector('.counter');

const button = document.querySelector('button');

button.addEventListener(
  'click',
  () => (counter.innerHTML = Number.parseInt(counter.innerHTML) + 1)
);
