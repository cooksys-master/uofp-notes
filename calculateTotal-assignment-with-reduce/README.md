# JS Assignment Primer

---

In this assignment, students are tasked with implementing a `calculateTotal` method. This method should receive two parameters (`items` and `tax`) and returns a `number` representing the total cost of all the `items` including the tax on all items which are taxable. 

The `items` parameter is an `array` which contains `item` objects. Each `item` object has two keys: `price` and `taxable`. The first key, `price`, contains a `number` which represents the price of the item. The second key, `taxable`, contains a `boolean` denoting whether the item is a taxable or non-taxable item respectively.

The `tax` parameter is a `number` which represents the tax percentage which should be applied to each `taxable` item. The value of `tax` must be a positive `number` between zero and one. If a negative value is passed in as the `tax` parameter then the absolute value of that number should be used instead.

Students are given a simple skeleton with a method signature for calculateTotal and are expected to implement the method. All code should be written within the scope of the provided function. After cloning the assignment students need to run the `npm install` command to install all packages needed to run the included tests. In order to run the included tests students should use the `npm test` command.

### Examples
---

```JavaScript
// Example items array
const items = [
  {
    price: 100,
    taxable: false
  },
  {
    price: 50,
    taxable: false
  },
  {
    price: 250,
    taxable: true
  }
]

// Example call to calculateTotal
calculateTotal(items, .0975) // 100 + 50 + 250 + (250 * .0975) = 424.375
```


