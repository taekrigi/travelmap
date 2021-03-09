import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { logout } from '../actions/userAction'

const LogoutScreen = ({ history }) => {
  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(logout())
    alert('로그아웃 되었습니다.')
    history.push('/')
  })

  return <></>
}

export default LogoutScreen
