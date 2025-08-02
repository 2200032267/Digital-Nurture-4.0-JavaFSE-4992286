import React from "react";
function IndianPlayers() {
  const T20Players = ["Virat", "Rohit", "Hardik"];
  const RanjiPlayers = ["Pujara", "Rahane", "Karun"];
  const AllPlayers = [...T20Players, ...RanjiPlayers];
  const [odd1, even1, odd2, even2, odd3, even3] = AllPlayers;
  const oddTeam = [odd1, odd2, odd3];
  const evenTeam = [even1, even2, even3];
  return (
    <div>
      <h2>Merged Players</h2>
      <p>{AllPlayers.join(", ")}</p>
      <h3>Odd Team Players</h3>
      <ul>
        {oddTeam.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
      <h3>Even Team Players</h3>
      <ul>
        {evenTeam.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
}
export default IndianPlayers;
