import React, { useState, useEffect, useRef } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Alert } from 'react-bootstrap'
import Loader from '../components/Loader'
import { login, clearLogin } from '../actions/userAction'

const LoginScreen = ({ location, history }) => {
  const usernameElement = useRef('')

  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')

  const dispatch = useDispatch()

  const user = useSelector((state) => state.user)
  const { loading, error } = user

  useEffect(() => {
    usernameElement.current.focus()
    dispatch(clearLogin())
  }, [])

  const onLogin = (e) => {
    e.preventDefault()
    dispatch(login({ username, password }))
  }

  return (
    <>
      {loading ? (
        <Loader />
      ) : (
        <>
          {error && <Alert variant='danger'>{error}</Alert>}
          <form onSubmit={onLogin}>
            <h3>Sign In</h3>
            <div className='form-group'>
              <label>Username</label>
              <input
                type='text'
                className='form-control'
                placeholder='Enter username'
                autoComplete='false'
                ref={usernameElement}
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
        </>
      )}
    </>
  )
}

export default LoginScreen
