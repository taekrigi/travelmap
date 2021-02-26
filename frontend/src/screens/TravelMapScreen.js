import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { WorldMap } from 'react-svg-worldmap'
import { Modal, Button } from "react-bootstrap"
import Loader from '../components/Loader'
import Message from '../components/Message'
import {
  getTravelMaps,
} from '../actions/travelMapAction'

const TravelMapScreen = () => {
  const [showAddTravelMapModal, setShowAddTravelMapModal] = useState(false)

  const dispatch = useDispatch()

  const travelMapList = useSelector(state => state.travelMapList)
  const { loading, error, travelMaps } = travelMapList;

  useEffect(() => {
    dispatch(getTravelMaps("aaaaa"));
  }, [dispatch])

  return (
    <>
      { 
        loading ? <Loader /> : 
        error ? (
          <>
           <Modal show={showAddTravelMapModal} >
            <Modal.Header closeButton>
              <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" >
                Close
              </Button>
              <Button variant="primary">
                Save Changes
              </Button>
            </Modal.Footer>
          </Modal>
          </>
        ) : 
       (
        <>
         <WorldMap color="red" title="Top 10 Populous Countries" value-suffix="people" size="xl" data={[{country: 'us', value: '1'}]} />
         <Modal />
        </>
       )
   
      }
    </>
  )
}
      

export default TravelMapScreen
