import React, { useReducer } from 'react'
import { useDispatch } from 'react-redux'
import { register } from '../actions/userAction'

const CHANGE_NAME = 'CHANGE_NAME'
const CHANGE_PASSWORD = 'CHANGE_PASSWORD'
const CHANGE_PASSWORD2 = 'CHANGE_PASSWORD2'

const reducer = (state, action) => {
  switch (action.type) {
    case CHANGE_NAME:
      return { ...state, username: action.payload }
    case CHANGE_PASSWORD:
      return { ...state, password: action.payload }
    case CHANGE_PASSWORD2:
      return { ...state, password2: action.payload }
    default:
      return state
  }
}

const RegisterScreen = ({ history }) => {
  const [state, localDisaptch] = useReducer(reducer, {
    username: '',
    password: '',
    password2: '',
  })

  const dispatch = useDispatch()

  const changeInput = (type) => (e) => {
    localDisaptch({ type, payload: e.target.value })
  }

  const onRegister = (e) => {
    e.preventDefault()

    if (state.password !== state.password2) {
      alert('비밀번호가 일치하지 않습니다.')
      return
    }

    dispatch(register(state, history))
  }

  return (
    <form onSubmit={onRegister}>
      <h3>Register</h3>

      <div className='form-group'>
        <label>Username</label>
        <input
          type='type'
          className='form-control'
          placeholder='Enter username'
          onChange={changeInput(CHANGE_NAME)}
        />
      </div>

      <div className='form-group'>
        <label>Password</label>
        <input
          type='password'
          className='form-control'
          placeholder='Enter password'
          onChange={changeInput(CHANGE_PASSWORD)}
        />
      </div>

      <div className='form-group'>
        <label>Password2</label>
        <input
          type='password'
          className='form-control'
          placeholder='Enter password'
          onChange={changeInput(CHANGE_PASSWORD2)}
        />
      </div>

      <div className='form-group'>
        <div className='custom-control custom-checkbox'>
          <input
            type='checkbox'
            className='custom-control-input'
            id='customCheck1'
          />
          <label className='custom-control-label' htmlFor='customCheck1'>
            Remember me
          </label>
        </div>
      </div>

      <button type='submit' className='btn btn-primary btn-block'>
        Submit
      </button>
      <p className='forgot-password text-right'>
        Forgot <a href='#'>password?</a>
      </p>
    </form>
  )
}

export default RegisterScreen
