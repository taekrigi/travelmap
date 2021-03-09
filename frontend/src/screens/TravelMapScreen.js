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
  const userInfo = useSelector((state) => state.userInfo)
  const { loading, error, travelMaps, counts } = travelMapList
  const { name } = userInfo

  useEffect(() => {
    if (!name) return
    dispatch(getTravelMaps(name))
    dispatch(getVisitedCountriesCount(name))
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
