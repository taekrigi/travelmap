import React from 'react'
import { Table } from 'react-bootstrap'
import TravelMapItem from './TravelMapItem'

const TravelMapList = ({ travelMapList }) => {
  return (
    <>
      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>Country</th>
            <th>Visited Date</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {travelMapList.length === 0 ? (
            <tr>
              <td colSpan='4'>목록이 없습니다.</td>
            </tr>
          ) : (
            travelMapList.map((item, index) => (
              <TravelMapItem key={item.id} item={item} index={index} />
            ))
          )}
        </tbody>
      </Table>
    </>
  )
}

export default TravelMapList
