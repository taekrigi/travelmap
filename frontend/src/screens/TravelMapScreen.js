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
  const dispatch = useDispatch()

  const travelMap = useSelector((state) => state.travelMap)
  const { user } = useSelector((state) => state.user)
  const { loading, error, travelMapList, countList } = travelMap
  const { username } = user

  useEffect(() => {
    if (!username) return
    dispatch(getTravelMaps(username))
    dispatch(getVisitedCountriesCount(username))
  }, [username])

  return (
    <>
      {loading ? (
        <Loader />
      ) : error ? (
        <>에러</>
      ) : (
        <>
          <h3 className='mt-5'>
            {travelMapList.length} Countries you've been to
          </h3>
          <WorldMap color='green' size='xl' data={travelMapList} />
          <CountChart countList={countList} />
          <Modal />
        </>
      )}
    </>
  )
}

export default TravelMapScreen
