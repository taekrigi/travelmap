import React from 'react'
import AppLink from './AppLink'

const Menu = ({
  user: {
    loggedIn,
    user: { authorities },
  },
}) => {
  return (
    <ul className='navbar-nav mr-auto'>
      <AppLink to='/' className='nav-link' href='#'>
        Home <span className='sr-only'>(current)</span>
      </AppLink>

      {!loggedIn ? (
        <>
          <AppLink to='/login' className='nav-link' href='#'>
            Login
          </AppLink>

          <AppLink to='/register' className='nav-link' href='#'>
            Register
          </AppLink>
        </>
      ) : authorities.includes('ROLE_ADMIN') ? (
        <>
          <AppLink to='/admin' className='nav-link' href='#'>
            Admin
          </AppLink>

          <AppLink to='/logout' className='nav-link' href='#'>
            Logout
          </AppLink>
        </>
      ) : authorities.includes('ROLE_USER') ? (
        <>
          <AppLink to='/logout' className='nav-link' href='#'>
            Logout
          </AppLink>

          <AppLink to='/travelmap/change' className='nav-link' href='#'>
            TravelMaps
          </AppLink>
        </>
      ) : (
        <></>
      )}
    </ul>
  )
}

export default Menu
