
import { getFiveDayForecast } from './api';

const phoenixP = getFiveDayForecast('phoenix');
const memphisP = getFiveDayForecast('memphis');

Promise.all([phoenixP, memphisP])
  .then(([phoenix, memphis]) => {
    console.log(phoenix);
    console.log(memphis);
  });

Promise.race([phoenixP, memphisP])
  .then((result) => {
    console.log(result);
  });
