import React from 'react';
function ListofPlayers() {
  const players = [
    { name: 'Virat', score: 95 },
    { name: 'Rohit', score: 45 },
    { name: 'Dhoni', score: 82 },
    { name: 'Raina', score: 66 },
    { name: 'Bumrah', score: 71 },
    { name: 'Jadeja', score: 59 },
    { name: 'Gill', score: 102 },
    { name: 'Iyer', score: 40 },
    { name: 'Pant', score: 77 },
    { name: 'Siraj', score: 53 },
    { name: 'KL Rahul', score: 89 }
  ];
  const lowScorers = players.filter(player => player.score < 70);
  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, idx) => (
          <li key={idx}>{p.name} - {p.score}</li>
        ))}
      </ul>
      <h2>Players with Score &lt; 70</h2>
      <ul>
        {lowScorers.map((p, idx) => (
          <li key={idx}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}
export default ListofPlayers;
