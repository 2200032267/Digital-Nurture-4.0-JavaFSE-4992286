
import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from '../TrainersMock'; 

const TrainerDetail = () => {
  const { id } = useParams(); 

  const trainer = trainersMock.find(t => t.trainerId === id);

  if (!trainer) {
    return <div>Trainer not found!</div>;
  }

  return (
    <div>
      <h2>Trainer Details</h2>
      <p><strong>Name:</strong> {trainer.name}</p>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong></p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetail;