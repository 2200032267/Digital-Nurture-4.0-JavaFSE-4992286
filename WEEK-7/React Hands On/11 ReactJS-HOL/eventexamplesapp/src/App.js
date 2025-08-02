import React, { useState } from "react";
import "./App.css";
import CurrencyConvertor from "./components/CurrencyConvertor";
function App() {
  const [count, setCount] = useState(0);
  const sayHello = () => {
    alert("Hello! Welcome to the React Events Demo.");
  };
  const increment = () => {
    setCount((prev) => prev + 1);
  };
  const handleIncrease = () => {
    sayHello();
    increment();
  };
  const handleDecrease = () => {
    setCount((prev) => prev - 1);
  };
  const sayWelcome = (msg) => {
    alert(`Message: ${msg}`);
  };
  const onPress = (e) => {
    alert("I was clicked");
    console.log("Synthetic event:", e);
  };
  return (
    <div className="App">
      <h1>🧪 React Event Examples</h1>
      <h2>Counter: {count}</h2>
      <button onClick={handleIncrease}>Increase</button>
      <button onClick={handleDecrease}>Decrease</button>
      <button onClick={() => sayWelcome("Welcome to React")}>
        Say Welcome
      </button>
      <button onClick={onPress}>Synthetic Event (onPress)</button>
      <CurrencyConvertor />
    </div>
  );
}
export default App;
