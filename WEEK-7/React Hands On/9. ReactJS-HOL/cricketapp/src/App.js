import React, { useState } from "react";
import "./App.css";
import ListofPlayers from "./components/ListofPlayers";
import IndianPlayers from "./components/IndianPlayers";
function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App">
      <h1>🏏 Cricket App</h1>
      <button onClick={() => setFlag(!flag)}>Click Here</button>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
