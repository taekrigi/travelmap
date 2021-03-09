import React, { useState, useEffect } from 'react'
import TestChildren from './TestChildren'

const TestScreen = () => {
  const [show, setShow] = useState(false)
  const [travelMaps, setTravelMaps] = useState([])

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
