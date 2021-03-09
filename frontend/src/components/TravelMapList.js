import React from 'react'
import { Table } from 'react-bootstrap'

const TravelMapList = ({ travelMaps }) => {
  return (
    <>
      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>Country</th>
            <th>City</th>
          </tr>
        </thead>
        <tbody>
          {travelMaps.length === 0 ? (
            <tr>
              <td colSpan='4'>목록이 없습니다.</td>
            </tr>
          ) : (
            travelMaps.map(({ id, city, country }, index) => (
              <tr key={id}>
                <td>{index + 1}</td>
                <td>{country}</td>
                <td>{city}</td>
              </tr>
            ))
          )}
        </tbody>
      </Table>
    </>
  )
}

export default TravelMapList
