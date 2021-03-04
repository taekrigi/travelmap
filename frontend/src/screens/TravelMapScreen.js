import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { WorldMap } from 'react-svg-worldmap'
import { Modal, Button } from 'react-bootstrap'
import Loader from '../components/Loader'
import Message from '../components/Message'
import CountChart from '../components/CountChart'
import {
  getTravelMaps,
  getVisitedCountriesCount,
} from '../actions/travelMapAction'

const TravelMapScreen = () => {
  const [showAddTravelMapModal, setShowAddTravelMapModal] = useState(false)

  const dispatch = useDispatch()

  const travelMapList = useSelector((state) => state.travelMapList)
  const { loading, error, travelMaps, counts } = travelMapList

  // TODO: SET REAL DATA
  useEffect(() => {
    dispatch(getTravelMaps('user1'))
    dispatch(getVisitedCountriesCount('user1'))
  }, [])

  return (
    <>
      {loading ? (
        <Loader />
      ) : error ? (
        <>
          <Modal show={showAddTravelMapModal}>
            <Modal.Header closeButton>
              <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              Woohoo, you're reading this text in a modal!
            </Modal.Body>
            <Modal.Footer>
              <Button variant='secondary'>Close</Button>
              <Button variant='primary'>Save Changes</Button>
            </Modal.Footer>
          </Modal>
        </>
      ) : (
        <>
          <h3 className='mt-5'>{travelMaps.length} Countries you've been to</h3>
          <WorldMap color='green' size='xl' data={travelMaps} />
          <CountChart counts={counts} />
          <Modal />
        </>
      )}
    </>
  )
}

export default TravelMapScreen
