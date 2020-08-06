console.log(document.querySelectorAll('h3'));
const arr = Array.from(document.querySelectorAll('h3'));
console.log(arr);
arr.forEach(elem => console.log(elem));

const count = 0;

const counter = document.querySelector('.counter');

const section = document.querySelector('.section');
const div = document.querySelector('.div');
const button = document.querySelector('button');

section.addEventListener('click', () => alert('Bubble: ' + section.tagName));

div.addEventListener('click', () => {
  alert('Bubble: ' + div.tagName);
});

section.addEventListener('click', () => alert('CAPTURE: ' + section.tagName), {
  capture: true
});

div.addEventListener(
  'click',
  () => {
    alert('CAPTURE: ' + div.tagName);
  },
  true
);

button.addEventListener('click', () => {
  alert(button.tagName);
  counter.innerHTML = Number.parseInt(counter.innerHTML) + 1;
});
