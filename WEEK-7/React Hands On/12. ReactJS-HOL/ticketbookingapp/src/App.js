import React, { useState } from 'react';
import './App.css';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const toggleLogin = () => {
    setIsLoggedIn(prev => !prev);
  };
  let pageToDisplay;
  if (isLoggedIn) {
    pageToDisplay = <UserPage />;
  } else {
    pageToDisplay = <GuestPage />;
  }

  return (
    <div className="App">
      <h1>🛫 Ticket Booking App</h1>
      <button onClick={toggleLogin}>
        {isLoggedIn ? 'Logout' : 'Login'}
      </button>
      {pageToDisplay}
    </div>
  );
}
export default App;
