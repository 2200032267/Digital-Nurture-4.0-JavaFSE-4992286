import React from "react";

class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0,
    };

    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }

  updateEntry() {
    this.setState((prevState) => {
      return { entrycount: prevState.entrycount + 1 };
    });
  }

  updateExit() {
    this.setState((prevState) => {
      return { exitcount: prevState.exitcount + 1 };
    });
  }

  render() {
    return (
      <div className="counter-container">
        <button className="login-button" onClick={this.updateEntry}>
          Login
        </button>

        <span className="count-display">
          {this.state.entrycount} People Entered!!!
        </span>

        <div style={{ width: "50px", display: "inline-block" }}></div>

        <button className="exit-button" onClick={this.updateExit}>
          Exit
        </button>

        <span className="count-display">
          {this.state.exitcount} People Left!!!
        </span>
      </div>
    );
  }
}

export default CountPeople;
