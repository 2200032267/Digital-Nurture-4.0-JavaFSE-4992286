import React, { useState } from "react";
function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");
  const handleSubmit = (e) => {
    e.preventDefault();
    if (!employeeName || !complaint) {
      alert("Please fill in all fields.");
      return;
    }
    const referenceNumber = Math.floor(100000 + Math.random() * 900000);
    alert(`Complaint registered!\nReference Number: ${referenceNumber}`);
    setEmployeeName("");
    setComplaint("");
  };
  return (
    <div style={{ margin: "50px" }}>
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name: </label>
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            placeholder="Enter your name"
            required
          />
        </div>
        <br />
        <div>
          <label>Complaint: </label>
          <br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Enter your complaint"
            rows="5"
            cols="50"
            required
          />
        </div>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
export default ComplaintRegister;
