import React from 'react'
import { Link } from 'react-router-dom'

const AppLink = ({ to, children }) => {
  return (
    <li
      className={
        window.location.pathname === to ? 'nav-link active' : 'nav-link'
      }
    >
      <Link to={to} className='nav-link' href='#'>
        {children} <span className='sr-only'>(current)</span>
      </Link>
    </li>
  )
}

export default AppLink
