// src/components/PropertyForm.jsx
import React, { useState, useEffect } from 'react';
import { api } from '../api';
import './PropertyForm.css'; // Import the styling for this component

const PropertyForm = ({ propertyId, onSave }) => {
  const [property, setProperty] = useState({
    propertyID: '',
    propertyName: '',
    propertyLocation: '',
    propertyOwner: '',
    propertyImage: '' // Added for image URL
  });

  useEffect(() => {
    if (propertyId) {
      api.get(`/getProperty?propertyId=${propertyId}`).then(response => {
        setProperty(response.data || {});
      });
    }
  }, [propertyId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProperty(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (propertyId) {
      api.put(`/updateProperty/${propertyId}`, property).then(onSave);
    } else {
      api.post('/save', property).then(onSave);
    }
  };

  return (
    <div className="property-form">
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="propertyName"
          value={property.propertyName}
          onChange={handleChange}
          placeholder="Property Name"
          required
        />
        <input
          type="text"
          name="propertyLocation"
          value={property.propertyLocation}
          onChange={handleChange}
          placeholder="Property Location"
          required
        />
        <input
          type="text"
          name="propertyOwner"
          value={property.propertyOwner}
          onChange={handleChange}
          placeholder="Property Owner"
          required
        />
        <input
          type="text"
          name="propertyImage"
          value={property.propertyImage}
          onChange={handleChange}
          placeholder="Property Image URL" // Optional field for image URL
        />
        <button type="submit">Save</button>
      </form>
    </div>
  );
};

export default PropertyForm;
