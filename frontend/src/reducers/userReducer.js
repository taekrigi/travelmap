import {
  LOGIN_REQUEST,
  LOGIN_SUCCESS,
  LOGIN_FAIL,
  REGISTER_REQUEST,
  REGISTER_SUCCESS,
  REGISTER_FAIL,
} from '../constants/userConstants'

export const userReducer = (state = {}, action) => {
  switch (action.type) {
    case LOGIN_REQUEST:
      return { ...state, loading: true, user: {} }
    case LOGIN_SUCCESS:
      return { ...state, loading: false, user: action.payload.user }
    case LOGIN_FAIL:
      return { ...state, loading: false, error: action.payload }
    case REGISTER_REQUEST:
      return { ...state, loading: true, user: {} }
    case REGISTER_SUCCESS:
      return { ...state, loading: false, user: {} }
    case REGISTER_FAIL:
      return { ...state, loading: false, error: action.payload }
    default:
      return state
  }
}
