import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { createTenant, getTenant, updateTenant } from '../services/TenantService'

const TenantComponent = () => {

  const [tenantID, setTenantID] = useState('')
  const [amount, setAmount] = useState('')
  const [transactionType, setTransactionType] = useState('')
  const [date, setDate] = useState('')
  const [description, setDescription] = useState('')

    
    const {id} = useParams();

    const[errors, setErrors] = useState ({
      tenantID: '',
      amount: '',
      transactionType: '',
      date: '',
      description: '',
    })

    const navigator = useNavigate();

    useEffect(() => {
      if(id){
          getTransaction(id).then((response)=>{
            setTenantID(response.data.tenantID);
            setAmount(response.data.amount);
            setTransactionType(response.data.transactionType);
            setDate(response.data.date);
              setDescription(response.data.description);
          }).catch(error =>{
              console.error(error);
          })
      }
  }, [id])

    function saveOrUpdateTenant(e){
        e.preventDefault();

        if(validateForm()){

          const transaction = {tenantID, amount, transactionType, date, description}
        
            if(id){
                updateTenant(id, transaction).then((response)=>{
                    console.log(response.data);
                    navigator('/transactions');
                }).catch(error=>{
                    console.errors(error);
                })
            }else{
            createTenant(transaction).then((response) => {
                console.log(response.data);
                navigator('/transactions')
            }).catch(error=>{
                console.errors(error);
            })
            }
        }
        
    }

    function validateForm(){
      let valid = true;
      const errorsCopy = {...errors}

      if(tenantID.trim()){
          errorsCopy.tenantID = ''
      }
      else{
          errorsCopy.tenantID = 'Teanant ID is required';
          valid = false;
      }

      if(!amount.trim()){
          errorsCopy.amount = 'Amount is required';
          valid = false;
      }
      if(!transactionType.trim()){
          errorsCopy.transactionType = 'Transaction type is required';
          valid = false;
      }
      // if(!date.trim()){
      //     errorsCopy.date = 'Date is required';
      //     valid = false;
      // }
   
      if(!description.trim()){
          errorsCopy.description = 'Description is required';
          valid = false;
      }
      setErrors(errorsCopy);
      return valid;
  }
  
    
    function pageTitle(){
        if(id){
            return <div className="card-header text-center"><h2>Update Transaction</h2></div> 
        }
        else{
            return <div className="card-header text-center"><h2>Add Transaction</h2></div>
        }
    }

  return (
    <div className='container my-3'>
       <div className="card">
  {
    pageTitle()
  }
  <div className="card-body">
    <div className='row'>
    <div className="col-md-6 p-3 d-flex align-items-center justify-content-center">
        <img src="/property-keys.jpg" alt="Tenant" className="img-fluid rounded" /> 
      </div>
      <div className="col-md-6">
  <form>
  <div className="mb-1">
    <label  className="form-label">Tenant Id</label>
    <input type="text" placeholder='Enter Tenant Id' className={`form-control ${errors.tenantID? 'is-invalid': ''}`} name='tenantID' value={tenantID} onChange={(e)=> setTenantID(e.target.value)} />

    {errors.tenantID && <div className='invalid-feedback'>{errors.tenantID}</div> }
  </div>
  <div className="mb-1">
    <label  className="form-label">Amount</label>
    <input type="text" placeholder='Enter amount' className={`form-control ${errors.amount? 'is-invalid': ''}`} name='amount' value={amount} onChange={(e) => setAmount(e.target.value)} />
    
    {errors.amount && <div className='invalid-feedback'>{errors.amount}</div> }
  </div>
  <div className="mb-1">
    <label className="form-label">Transaction Type</label>
    <input type="text" placeholder='Enter Transaction Type' className={`form-control ${errors.transactionType? 'is-invalid': ''}`} name='transactionType' value={transactionType} onChange={(e) => setTransactionType(e.target.value)} />
    
    {errors.transactionType && <div className='invalid-feedback'>{errors.transactionType}</div> }
  </div>
  <div className="mb-1">
  <label className="form-label">Date</label>
  <input type="date" className={`form-control ${errors.date ? 'is-invalid' : ''}`} name='date' value={date} onChange={(e) => setDate(e.target.value)} />
  {errors.date && <div className='invalid-feedback'>{errors.date}</div>}
</div>

  <div className="mb-1">
    <label className="form-label">Description</label>
    <input type="text" placeholder='Enter description' className={`form-control ${errors.description? 'is-invalid': ''}`} name='description' value={description} onChange={(e) => setDescription(e.target.value)} />
  </div>
<div className='text-center'>
  <button onClick={saveOrUpdateTenant} className="btn btn-success">Submit</button>
  </div>
</form>
</div>
</div>

    
  </div>
</div>
    </div>
  )
}

export default TenantComponent