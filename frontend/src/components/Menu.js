import React from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'

const Menu = () => {
  const userInfo = useSelector((state) => state.userInfo)
  const { name, authorities } = userInfo

  return (
    <ul className='navbar-nav mr-auto'>
      <li className='nav-item active'>
        <Link to='/' className='nav-link' href='#'>
          Home <span className='sr-only'>(current)</span>
        </Link>
      </li>

      {(() => {
        if (!name) {
          return (
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
          )
        }

        if (authorities && authorities.includes('ROLE_ADMIN')) {
          return (
            <>
              <Link to='/admin' className='nav-link' href='#'>
                Admin
              </Link>
              <Link to='/logout' className='nav-link' href='#'>
                Logout
              </Link>
            </>
          )
        }

        if (authorities && authorities.includes('ROLE_USER')) {
          return (
            <>
              <Link to='/logout' className='nav-link' href='#'>
                Logout
              </Link>
              <Link to='/travelmap/change' className='nav-link' href='#'>
                TravelMaps
              </Link>
            </>
          )
        }
      })()}
    </ul>
  )
}

export default Menu
