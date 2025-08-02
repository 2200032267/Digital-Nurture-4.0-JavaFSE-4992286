import React from 'react';
import './App.css';
class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null
    };
  }
  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then((res) => res.json())
      .then((data) => {
        this.setState({ user: data.results[0] });
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }
  render() {
    const { user } = this.state;
    return (
      <div className="user-container">
        <h2 className="user-title">User Details</h2>
        {user ? (
          <div className="user-card">
            <div className="user-image-container">
              <img src={user.picture.large} alt="User" className="user-image" />
            </div>
            <div className="user-info">
              <div className="user-detail">
                <span className="detail-label">Title:</span>
                <span className="detail-value">{user.name.title}</span>
              </div>
              <div className="user-detail">
                <span className="detail-label">First Name:</span>
                <span className="detail-value">{user.name.first}</span>
              </div>
              <div className="user-detail">
                <span className="detail-label">Last Name:</span>
                <span className="detail-value">{user.name.last}</span>
              </div>
              <div className="user-detail">
                <span className="detail-label">Email:</span>
                <span className="detail-value">{user.email}</span>
              </div>
              <div className="user-detail">
                <span className="detail-label">Phone:</span>
                <span className="detail-value">{user.phone}</span>
              </div>
              <div className="user-detail">
                <span className="detail-label">Location:</span>
                <span className="detail-value">{user.location.city}, {user.location.country}</span>
              </div>
            </div>
          </div>
        ) : (
          <div className="loading-container">
            <div className="loading-spinner"></div>
            <p className="loading-text">Loading user data...</p>
          </div>
        )}
      </div>
    );
  }
}
export default Getuser;
