import React from 'react'
import { useDispatch } from 'react-redux'
import { deleteTravelMap } from '../../actions/travelMapAction'

const TravelMap = ({ item: { id, country, visitedDate }, index }) => {
  const dispatch = useDispatch()

  const onDelete = (id) => (e) => {
    dispatch(deleteTravelMap(id))
  }

  return (
    <tr>
      <td>{index + 1}</td>
      <td>{country}</td>
      <td>{visitedDate}</td>
      <td onClick={onDelete(id)}>❌</td>
    </tr>
  )
}

export default TravelMap
