import 'bootstrap-icons/font/bootstrap-icons.css';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteTransaction, listTransactions } from '../services/TransactionService';

const ListTransactionComponent = () => {

    const [transactions, setTransactions] = useState([])

    const navigator = useNavigate();

    useEffect(()=>{
       getAllTransactions();
    }, [])

    function getAllTransactions(){
        listTransactions().then((response)=>{
            setTransactions(response.data);
        }).catch(error=>{
            console.error(error);
        })
    }

    function addNewTransaction(){
        navigator('/add-transaction')
    }

    function updateTransaction(id){
        navigator(`/edit-transaction/${id}`)
    }

    function removeTransaction(id){
        console.log(id);

        deleteTransaction(id).then((response)=>{
            getAllTransactions();
        }).catch(error=>{
            console.errors(error);
        })
    }

  return (
    <div className='container'>
        <div className="d-flex justify-content-between align-items-center mb-4">
            <h2 className='text-center'>List Transactions</h2>
            <button className='btn btn-success' onClick={addNewTransaction}>
                <i className="bi bi-person-plus-fill me-2"></i> Add Transaction
            </button>
        </div>

        <div className="row">
            {
                transactions.map(transaction => 
                    <div className="col-md-4 mb-4" key={transaction.id}>
                        <div className="card shadow bg-light">
                        <img 
  src="/tenant.png" 
  className="card-img-top" 
  alt="Transaction Image" 
  style={{ height: '250px', objectFit: 'contain' }} 
/>
                            <div className="card-body ">
                                <h5 className="card-title"></h5>
                                <p className="card-text">
                                    <strong>Tenant Id:</strong> {transaction.tenantId}<br/>
                                    <strong>Amount:</strong> {transaction.amount}<br/>
                                    <strong>Transaction Type:</strong> {transaction.transactionType}<br/>
                                    <strong>Date:</strong> {transaction.transactionDate}<br/>
                                    <strong>Description:</strong> {transaction.description}<br/>
                                </p>
                            </div>
                            <div className="card-footer d-flex justify-content-between">
                                <button className="btn btn-primary btn-sm" onClick={() => updateTransaction(transaction.id)}>
                                    <i className="bi bi-pencil"></i> Edit
                                </button>
                                <button className="btn btn-danger btn-sm" onClick={() => removeTransaction(transaction.id)}>
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

export default ListTransactionComponent;
