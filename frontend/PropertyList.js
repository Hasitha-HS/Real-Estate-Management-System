<
import React, { useState, useEffect } from 'react';
import axios from './axiosConfig';

const PropertyList = () => {
    const [properties, setProperties] = useState([]);

    useEffect(() => {
        axios.get('/getAll')
            .then(response => {
                setProperties(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the properties!', error);
            });
    }, []);

    const deleteProperty = (id) => {
        axios.delete(`/${id}`)
            .then(response => {
                alert('Property deleted successfully!');
                setProperties(properties.filter(property => property.pId !== id));
            })
            .catch(error => {
                console.error('There was an error deleting the property!', error);
            });
    };

    return (
        <div>
            <h1>Property List</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {properties.map(property => (
                        <tr key={property.pId}>
                            <td>{property.pId}</td>
                            <td>{property.pName}</td>
                            <td>{property.pDescrip}</td>
                            <td>{property.pQty}</td>
                            <td>{property.pPrice}</td>
                            <td>
                                <button onClick={() => deleteProperty(property.pId)}>Delete</button>
                                <button onClick={() => window.location = `/edit/${property.pId}`}>Edit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default PropertyList;
