import axios, { AxiosInstance } from 'axios';

const baseURL = import.meta.env.VITE_API_BASE_URL;

const instance: AxiosInstance = axios.create({
    baseURL,
});

export default instance;
