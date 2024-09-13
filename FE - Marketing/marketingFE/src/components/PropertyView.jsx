// src/components/PropertyView.jsx
import React, { useState, useEffect } from 'react';
import { api } from '../api';
import './PropertyView.css'; // Import the styling for this component

const PropertyView = ({ propertyId, onNext, onDelete }) => {
  const [property, setProperty] = useState(null);

  useEffect(() => {
    if (propertyId) {
      api.get(`/getProperty?propertyId=1`).then(response => {
        setProperty(response.data || {});
      });
    }
  }, [propertyId]);

  const handleDelete = () => {
    api.delete(`/deleteProperty/${propertyId}`).then(() => {
      onDelete();
    });
  };

  if (!property) return <div>Loading...</div>;

  return (
    <div className="property-view">
      <div className="property-image">
        <img src={property.propertyImage || '/path/to/default-image.jpg'} alt={property.propertyName} /> {/* Default image */}
      </div>
      <h2>{property.propertyName}</h2>
      <p>Location: {property.propertyLocation}</p>
      <p>Owner: {property.propertyOwner}</p>
      <button onClick={onNext}>Next</button>
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
};

export default PropertyView;
