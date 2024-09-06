import 'bootstrap-icons/font/bootstrap-icons.css';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteTenant, listTenants } from '../services/TenantService';

const ListTenantComponent = () => {

    const [tenants, setTenants] = useState([])

    const navigator = useNavigate();

    useEffect(()=>{
       getAllTenants();
    }, [])

    function getAllTenants(){
        listTenants().then((response)=>{
            setTenants(response.data);
        }).catch(error=>{
            console.error(error);
        })
    }

    function addNewTenant(){
        navigator('/add-tenant')
    }

    function updateTenant(id){
        navigator(`/edit-tenant/${id}`)
    }

    function removeTenant(id){
        console.log(id);

        deleteTenant(id).then((response)=>{
            getAllTenants();
        }).catch(error=>{
            console.errors(error);
        })
    }

  return (
    <div className='container'>
        <div className="d-flex justify-content-between align-items-center mb-4">
            <h2 className='text-center'>List of Tenants</h2>
            <button className='btn btn-success' onClick={addNewTenant}>
                <i className="bi bi-person-plus-fill me-2"></i> Add Tenant
            </button>
        </div>

        <div className="row">
            {
                tenants.map(tenant => 
                    <div className="col-md-4 mb-4" key={tenant.id}>
                        <div className="card shadow bg-light">
                        <img 
  src="/tenant.png" 
  className="card-img-top" 
  alt="Tenant Image" 
  style={{ height: '250px', objectFit: 'cover' }} 
/>
                            <div className="card-body ">
                                <h5 className="card-title">{tenant.firstName} {tenant.lastName}</h5>
                                <p className="card-text">
                                    <strong>Email:</strong> {tenant.email}<br/>
                                    <strong>Phone:</strong> {tenant.phone}<br/>
                                    <strong>Address:</strong> {tenant.address}<br/>
                                    <strong>Move-in Date:</strong> {tenant.moveInDate}<br/>
                                    <strong>Move-out Date:</strong> {tenant.moveOutDate}<br/>
                                    <strong>Status:</strong> <span className={`badge ${tenant.status === 'Active' ? 'bg-success' : 'bg-secondary'}`}>{tenant.status}</span>
                                </p>
                            </div>
                            <div className="card-footer d-flex justify-content-between">
                                <button className="btn btn-primary btn-sm" onClick={() => updateTenant(tenant.id)}>
                                    <i className="bi bi-pencil"></i> Edit
                                </button>
                                <button className="btn btn-danger btn-sm" onClick={() => removeTenant(tenant.id)}>
                                    <i className="bi bi-trash"></i> Delete
                                </button>
                            </div>
                        </div>
                    </div>
                )
            }
        </div>
    </div>
  )
}

export default ListTenantComponent;
