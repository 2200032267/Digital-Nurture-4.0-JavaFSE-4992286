import React from 'react';
import ComplaintRegister from './ComplaintRegister';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <span className="app-icon">
          <svg width="40" height="40" viewBox="0 0 24 24" fill="none">
            <circle cx="12" cy="12" r="10" stroke="#fff" strokeWidth="2" />
            <path d="M12 6v6l4 2" stroke="#fff" strokeWidth="2" strokeLinecap="round" />
          </svg>
        </span>
        <h1 className="app-title">
          Ticket Raising App
        </h1>
      </header>
      <div className="app-content">
        <ComplaintRegister />
      </div>
    </div>
  );
}

export default App;
