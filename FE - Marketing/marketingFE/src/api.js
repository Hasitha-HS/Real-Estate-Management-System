// src/api.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/property'; // Adjust according to your server URL

export const api = axios.create({
  baseURL: API_URL,
});
