import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.headers.common['Authorization'] =
  localStorage.getItem('AUTH_TOKEN') ||
  'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV0sImlhdCI6MTYxNDc4MTc1NSwiZXhwIjoxNjE0ODcwMDAwfQ.CfKMMq48t9old_T4MPunZwfUmaRZ4HjZEqy_6_F8o6qpsnrD3E-aRsiK6iZn4rfX5VRenrJtZ2qcBFCs3I09uQ'
axios.defaults.headers.post['Content-Type'] = 'application/json'
