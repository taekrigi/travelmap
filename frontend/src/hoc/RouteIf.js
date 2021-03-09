import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'

const RouteIf = ({ role, loggedIn, children }) => {
  const userLogin = useSelector((state) => state.userInfo)
  const { userInfo } = userLogin

  return loggedIn === false && !userInfo ? <></> : { children }
}

export default RouteIf
