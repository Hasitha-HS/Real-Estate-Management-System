import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/transactions';

export const listTransactions = () => axios.get(REST_API_BASE_URL);

export const createTransaction = (transaction) => axios.post(REST_API_BASE_URL, transaction);

export const getTransaction = (transactionId) => axios.get(REST_API_BASE_URL+'/'+transactionId);

export const updateTransaction = (transactionId, transaction) => axios.put(REST_API_BASE_URL + '/'+ transactionId, transaction);

export const deleteTransaction = (transactionId) => axios.delete(REST_API_BASE_URL + '/' + transactionId);