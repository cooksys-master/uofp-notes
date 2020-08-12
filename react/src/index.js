import React from 'react';
import ReactDOM from 'react-dom';

ReactDOM.render(
  React.createElement('h1', { class: 'header' }, 'Hello World'),
  // <h1 class="header">Hello World</h1>,
  document.getElementById('root')
);
