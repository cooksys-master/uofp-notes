// import for side effects
import './modern-library'

import { x, double, doesntExist } from './modern-library'
console.log(x)
console.log(double(x))
console.log(doesntExist)

import * as someName from './modern-library'
console.log(someName.x)
console.log(someName.double(someName.x))

// name can be anything (valid js identifier)
import name from './modern-library'
console.log(name(30))

// example of side effecting imports in react
// importing related css to link it to a component
// file
// inside AppComponent.js
// import './AppComponent.css'
