import axios from 'axios'

import {
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAIL,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAIL,
} from '../constants/userConstants'

export const login = ({ username, password }) => async (dispatch) => {
  try {
    dispatch({ type: LOGIN_REQUEST })

    const { data } = await axios.post('/login', {
      username,
      password,
    })

    dispatch({
      type: LOGIN_SUCCESS,
      payload: {
        user: data,
      },
    })

    localStorage.setItem('user', JSON.stringify(data))
  } catch (error) {
    dispatch({
      type: LOGIN_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}

export const register = ({ username, password }) => async (dispatch) => {
  try {
    dispatch({
      type: REGISTER_REQUEST,
    })

    const { data } = await axios.post('/register', {
      username,
      password,
    })

    dispatch({
      REGISTER_SUCCESS,
      payload: {
        user: data,
      },
    })
  } catch (error) {
    dispatch({
      type: REGISTER_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}
