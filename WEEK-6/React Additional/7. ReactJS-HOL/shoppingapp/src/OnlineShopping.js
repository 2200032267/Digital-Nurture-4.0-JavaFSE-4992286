
import React from 'react';
import { Cart } from './Cart';

export class OnlineShopping extends React.Component {
  render() {
    const CartInfo = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "TV", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 }
    ];

    return (
      <div className="mydiv">
        <h1>Items Ordered :</h1>
        <Cart item={CartInfo} />
      </div>
    );
  }
}
