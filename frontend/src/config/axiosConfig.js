import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.headers.common['Authorization'] =
  localStorage.getItem('AUTH_TOKEN') || ''
axios.defaults.headers.post['Content-Type'] = 'application/json'
