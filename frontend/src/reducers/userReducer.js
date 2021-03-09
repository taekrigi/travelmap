import {
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAIL,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAIL,
  LOG_OUT,
} from '../constants/userConstants'

export const userReducer = (state = {}, action) => {
  switch (action.type) {
    case LOGIN_REQUEST:
      return { ...state, loading: true }
    case LOGIN_SUCCESS:
      return { ...state, loading: false, ...action.payload.userInfo }
    case LOGIN_FAIL:
      return { ...state, loading: false, error: action.payload }
    case REGISTER_REQUEST:
      return { ...state, loading: true }
    case REGISTER_SUCCESS:
      return { ...state, loading: false }
    case REGISTER_FAIL:
      return { ...state, loading: false, error: action.payload }
    case LOG_OUT:
      return {}
    default:
      return state
  }
}
