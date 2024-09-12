// src/App.jsx
import React, { useState } from 'react';
import PropertyForm from './components/PropertyForm';
import PropertyView from './components/PropertyView';
import './index.css';

function App() {
  const [currentId, setCurrentId] = useState(null);
  const [viewMode, setViewMode] = useState('view');

  const handleSave = () => {
    setViewMode('view');
  };

  const handleNext = () => {
    // Logic to get the next property ID (e.g., fetch from API or use a state variable)
    setCurrentId(prevId => (prevId ? prevId + 1 : 1)); // Example increment
  };

  const handleDelete = () => {
    setCurrentId(null);
    setViewMode('add');
  };

  return (
    <div className="app">
      {viewMode === 'add' ? (
        <PropertyForm onSave={handleSave} />
      ) : (
        <PropertyView propertyId={currentId} onNext={handleNext} onDelete={handleDelete} />
      )}
      <button onClick={() => setViewMode('add')}>Add Property</button>
    </div>
  );
}

export default App;
