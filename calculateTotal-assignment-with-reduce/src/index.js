// /**
//  * calculateTotal : (items: [{}], tax: number) -> number
//  * @param {*} items - [{ price: number, taxable: boolean }]
//  * @param {*} tax - number
//  * return - the sum of all items as well as the tax value from taxable items
//  *        - number
//  */
// export function calculateTotal (items, tax) {
//   // 1. iterate through the the items array
//   // 2. sum the price of all items
//   // 3. add the tax value of all taxable items
//   // 4. return the total
//   // f = (result, currItem) => {
//   //   result += item.price;
//   //   if (item.taxable) {
//   //     result += item.price * Math.abs(tax);
//   //   }
//   //   return result;
//   // }
//   let total = 0
//   for (let item of items) {
//     // item : { price: number, taxable: boolean }
//     total += item.price
//     if (item.taxable) {
//       total += item.price * Math.abs(tax)
//     }
//   }
//   return total
// }

const items = [
  { price: 50, taxable: false },
  { price: 25, taxable: true },
  { price: 38, taxable: true },
  { price: 190, taxable: false },
  { price: 200, taxable: true }
]

const tax = 0.0975

// item : { price: number, taxable: boolean }
// items : [{ price: number, taxable: boolean }]
// tax : number
// const calculateTotal = (items, tax) => {
//   const f = (accumulator, currItem) => {
//     accumulator += currItem.price
//     if (currItem.taxable) {
//       accumulator += currItem.price * Math.abs(tax)
//     }
//     return accumulator
//   }
//   return items.reduce(f, 0)
// }

export const calculateTotal = (items, tax) =>
  items.reduce(
    (accumulator, { price, taxable }) =>
      taxable
        ? accumulator + price + price * Math.abs(tax)
        : accumulator + price,
    0
  )

// console.log(calculateTotal(items, tax))
