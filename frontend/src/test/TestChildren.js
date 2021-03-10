import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { testDispatch } from './testAction'

const TestChildren = ({ show, travelMaps }) => {
  console.log('children element..!')

  const [test, setTest] = useState(true)

  const dispatch = useDispatch()
  const reduxTest = useSelector((state) => state.test)

  useEffect(() => {
    console.log('children useEffect..!')
  }, [travelMaps])

  return (
    <h1>
      <button onClick={(e) => dispatch(testDispatch())}>
        Click me to rerender testChildren!
      </button>
    </h1>
  )
}

export default TestChildren
