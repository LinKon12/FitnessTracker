// components/Dashboard.js
import React, { useState } from 'react';
import axios from 'axios';

function Dashboard() {
  const [message, setMessage] = useState('');
  const [points, setPoints] = useState(0);
  const [streak, setStreak] = useState(0);

  const handleCheckin = async () => {
    try {
      const token = localStorage.getItem('token');
      const res = await axios.post(
        'http://localhost:8080/session/checkin',
        {},
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      setMessage('Check-in successful!');
      setPoints(res.data.points);
      setStreak(res.data.streak);
    } catch (err) {
      setMessage('Check-in failed!');
      console.error(err);
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Dashboard</h2>
      <button onClick={handleCheckin} style={{ padding: '10px 15px' }}>
        Check In
      </button>
      <p>{message}</p>
      <p>Points: {points}</p>
      <p>Streak: {streak}</p>
    </div>
  );
}

export default Dashboard;
