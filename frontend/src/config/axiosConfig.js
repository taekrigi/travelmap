import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8080'
axios.interceptors.request.use((config) => {
  config.headers.Authorization =
    localStorage.getItem('USER_INFO') &&
    JSON.parse(localStorage.getItem('USER_INFO')).token

  return config
})

axios.defaults.headers.common['Authorization'] = axios.defaults.headers.post[
  'Content-Type'
] = 'application/json'
