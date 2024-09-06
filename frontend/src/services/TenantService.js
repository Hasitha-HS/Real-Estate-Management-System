import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/tenants';

export const listTenants = ()=>axios.get(REST_API_BASE_URL);

export const createTenant = (tenant) => axios.post(REST_API_BASE_URL, tenant);

export const getTenant = (tenantId) => axios.get(REST_API_BASE_URL+'/'+tenantId);

export const updateTenant = (tenantId, tenant) => axios.put(REST_API_BASE_URL + '/'+ tenantId, tenant);

export const deleteTenant = (tenantId) => axios.delete(REST_API_BASE_URL + '/' + tenantId);