const buttons = [...document.querySelectorAll('.button')];

buttons.forEach(btn =>
  btn.addEventListener('click', () => {
    let [, h3] = [...btn.parentElement.children];
    if (btn.classList.contains('increment-button')) {
      h3.innerHTML -= -1;
    } else {
      h3.innerHTML -= 1;
    }
  })
);

const divs = buttons
  .map(btn => btn.parentElement)
  .filter((div, idx, array) => div !== array[idx + 1]);

console.log(divs);
