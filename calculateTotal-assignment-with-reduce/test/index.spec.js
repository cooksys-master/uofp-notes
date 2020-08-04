import mocha from 'mocha'
import jsc from 'jsverify'
import _ from 'lodash'

import { calculateTotal } from '../src/'

describe('calculateTotal', () => {
  jsc.property(
    'Properly calculates total with correct arguments',
    '[{ price: nat; taxable: bool }]',
    'nat',
    (arr, n) => {
      const tax = n / Number.MAX_VALUE
      return _.isEqual(
        calculateTotal(arr, tax),
        arr.reduce(
          (acc, { price, taxable }) =>
            taxable ? acc + price * tax + price : acc + price,
          0
        )
      )
    }
  )

  jsc.property(
    'Does not mutate the passed in array',
    '[{ price: nat; taxable: bool }]',
    arr => {
      const originalArr = [...arr]
      calculateTotal(arr, 0.09)
      return _.isEqual(arr, originalArr)
    }
  )

  jsc.property(
    'Should not calculate negative tax values',
    '[{ price: nat; taxable: bool }]',
    'number(1)',
    (arr, tax) =>
      _.isEqual(
        calculateTotal(arr, tax),
        arr.reduce(
          (acc, { price, taxable }) =>
            taxable ? acc + price * Math.abs(tax) + price : acc + price,
          0
        )
      )
  )
})
