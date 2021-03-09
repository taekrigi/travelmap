import React from 'react'
import { Link } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'

const Header = () => {
  const userInfo = useSelector((state) => state.userInfo)

  const { name } = userInfo

  return (
    <nav className='navbar navbar-expand-md navbar-dark bg-dark mb-4'>
      <a className='navbar-brand' href='#'>
        My😘TravelMap
      </a>
      <button
        className='navbar-toggler'
        type='button'
        data-toggle='collapse'
        data-target='#navbarCollapse'
        aria-controls='navbarCollapse'
        aria-expanded='false'
        aria-label='Toggle navigation'
      >
        <span className='navbar-toggler-icon'></span>
      </button>
      <div className='collapse navbar-collapse' id='navbarCollapse'>
        <ul className='navbar-nav mr-auto'>
          <li className='nav-item active'>
            <Link to='/' className='nav-link' href='#'>
              Home <span className='sr-only'>(current)</span>
            </Link>
          </li>

          {!name ? (
            <>
              <li className='nav-item'>
                <Link to='/login' className='nav-link' href='#'>
                  Login
                </Link>
              </li>
              <li className='nav-item'>
                <Link to='/register' className='nav-link' href='#'>
                  Register
                </Link>
              </li>
            </>
          ) : (
            <Link to='/logout' className='nav-link' href='#'>
              Logout
            </Link>
          )}
        </ul>
      </div>
    </nav>
  )
}

export default Header
