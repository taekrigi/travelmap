import React, { setState, useEffect } from 'react'

const TestChildren = ({ show, travelMaps }) => {
  console.log('children element..!')
  useEffect(() => {
    console.log('children useEffect..!')
  }, [travelMaps])

  return <h1>zz</h1>
}

export default TestChildren
