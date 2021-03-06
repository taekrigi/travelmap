import axios from 'axios'

import {
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAIL,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAIL,
  LOG_OUT,
  VERIFY_JWT_TOKEN,
  CLEAR_LOGIN,
} from '../constants/userConstants'

import { TRAVEL_MAP_CLEAR } from '../constants/travelMapConstants'

export const login = ({ username, password }) => async (dispatch) => {
  try {
    dispatch({ type: LOGIN_REQUEST })

    const { data } = await axios.post('/login', {
      username,
      password,
    })

    dispatch({
      type: LOGIN_SUCCESS,
      payload: data,
    })

    localStorage.setItem('USER_INFO', JSON.stringify(data))
    window.location.href = '/'
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

export const register = ({ username, password }, history) => async (
  dispatch
) => {
  try {
    dispatch({
      type: REGISTER_REQUEST,
    })

    const { data } = await axios.post('/users/register', {
      username,
      password,
    })

    dispatch({
      type: REGISTER_SUCCESS,
      payload: {
        success: true,
      },
    })

    alert('회원가입이 완료되었습니다.')
    history.push('/login')
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

export const logout = () => async (dispatch) => {
  dispatch({
    type: LOG_OUT,
  })
  dispatch({
    type: TRAVEL_MAP_CLEAR,
  })
  localStorage.removeItem('USER_INFO')
}

export const verifyJwtToken = () => async (dispatch) => {
  const userStringFromStorage = localStorage.getItem('USER_INFO')

  if (!userStringFromStorage || !JSON.parse(userStringFromStorage).token) return

  const { data } = await axios.post('/users/jwt')

  dispatch({
    type: VERIFY_JWT_TOKEN,
    payload: data,
  })
}

export const clearLogin = () => (dispatch) => {
  dispatch({
    type: CLEAR_LOGIN,
  })
}
