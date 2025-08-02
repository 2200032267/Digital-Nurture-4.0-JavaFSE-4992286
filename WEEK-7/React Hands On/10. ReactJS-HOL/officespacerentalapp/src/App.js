import React from "react";
import "./App.css";
const office = {
  name: "Tech Park - Alpha Tower",
  rent: 65000,
  address: "MG Road, Bangalore",
  image:
    "https://cdn.pixabay.com/photo/2017/03/28/12/11/chairs-2181960_1280.jpg",
};
const officeList = [
  {
    name: "WeWork Koramangala",
    rent: 55000,
    address: "Koramangala 5th Block, Bangalore",
    image:
      "https://cdn.pixabay.com/photo/2017/03/28/12/17/chairs-2181994_1280.jpg",
  },
  {
    name: "Innov8 Residency",
    rent: 75000,
    address: "HSR Layout, Bangalore",
    image:
      "https://cdn.pixabay.com/photo/2014/05/05/20/29/conference-room-338563_1280.jpg",
  },
  {
    name: "BHIVE Workspace",
    rent: 60000,
    address: "Indiranagar, Bangalore",
    image:
      "https://cdn.pixabay.com/photo/2017/03/28/12/16/chairs-2181980_1280.jpg",
  },
];
const getRentStyle = (rent) => {
  return {
    color: rent < 60000 ? "red" : "green",
    fontWeight: "bold",
  };
};
function App() {
  return (
    <div className="App">
      <h1>Office Space Rental App</h1>
      <div
        style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}
      >
        <h2>{office.name}</h2>
        <img src={office.image} alt="Office" width="300" />
        <p style={getRentStyle(office.rent)}>Rent: ₹{office.rent}</p>
        <p>Address: {office.address}</p>
      </div>
      <h2>All Office Listings</h2>
      {officeList.map((off, index) => (
        <div
          key={index}
          style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}
        >
          <h3>{off.name}</h3>
          <img src={off.image} alt="Office" width="300" />
          <p style={getRentStyle(off.rent)}>Rent: ₹{off.rent}</p>
          <p>Address: {off.address}</p>
        </div>
      ))}
    </div>
  );
}
export default App;
