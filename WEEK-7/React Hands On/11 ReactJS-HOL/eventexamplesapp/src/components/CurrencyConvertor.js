import React, { useState } from "react";
function CurrencyConvertor() {
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");
  const convertToEuro = () => {
    const result = parseFloat(rupees) / 90;
    setEuros(result.toFixed(2));
  };
  const convertToRupee = () => {
    const result = parseFloat(euros) * 90;
    setRupees(result.toFixed(2));
  };
  return (
    <div style={{ marginTop: "30px" }}>
      <h2>💱 Currency Convertor</h2>
      <div>
        <label>Rupees: </label>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
        />
        <button onClick={convertToEuro}>Convert to Euro</button>
      </div>
      <div style={{ marginTop: "10px" }}>
        <label>Euros: </label>
        <input
          type="number"
          value={euros}
          onChange={(e) => setEuros(e.target.value)}
        />
        <button onClick={convertToRupee}>Convert to Rupees</button>
      </div>
    </div>
  );
}
export default CurrencyConvertor;
