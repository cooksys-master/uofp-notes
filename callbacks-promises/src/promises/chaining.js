const timeout = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve(10);
  }, 5000);
});

const p2 = timeout.then((x) => console.log('got ' + x + ' after 5 seconds!'));

const p3 = timeout.then((x) => console.log('got ' + x + ' after 5 seconds, too!'));
