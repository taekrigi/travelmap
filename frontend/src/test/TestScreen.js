import React, { useState, useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import TestChildren from './TestChildren'

const TestScreen = () => {
  const [show, setShow] = useState(false)
  const [travelMaps, setTravelMaps] = useState([])

  const dispatch = useDispatch()
  const reduxTest = useSelector((state) => state.test)

  const onClick = () => setTravelMaps([...travelMaps])

  console.log('parent state chanaged!')

  useEffect(() => {
    console.log('parent useEffect changed!')
  }, [])

  return (
    <div>
      <button onClick={onClick}>click!</button>
      <TestChildren show={show} travelMaps={travelMaps} />
    </div>
  )
}

export default TestScreen
