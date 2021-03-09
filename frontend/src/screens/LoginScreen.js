import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Loader from '../components/Loader'

import { login } from '../actions/userAction'

const LoginScreen = ({ location, history }) => {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')

  const dispatch = useDispatch()

  const userInfo = useSelector((state) => state.userInfo)
  const { loading, error, name } = userInfo

  useEffect(() => {
    if (name) {
      history.push('/')
    }
  })

  const onLogin = (e) => {
    e.preventDefault()
    dispatch(login({ username, password }))
  }

  return (
    <>
      {loading ? (
        <Loader />
      ) : error ? (
        <h1>Error!</h1>
      ) : (
        <form onSubmit={onLogin}>
          <h3>Sign In</h3>
          <div className='form-group'>
            <label>Username</label>
            <input
              type='text'
              className='form-control'
              placeholder='Enter username'
              autoComplete='false'
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>

          <div className='form-group'>
            <label>Password</label>
            <input
              type='password'
              className='form-control'
              placeholder='Enter password'
              autoComplete='false'
              onChange={(e) => setPassword(e.target.value)}
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
      )}
    </>
  )
}

export default LoginScreen
