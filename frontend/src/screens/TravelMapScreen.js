import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { WorldMap } from 'react-svg-worldmap'
import Loader from '../components/Loader'
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
          {username && (
            <h3 className='mt-5'>
              {travelMapList.length} Countries you've been to
            </h3>
          )}
          <WorldMap
            color='green'
            size='xxl'
            data={travelMapList.map((e) => ({ ...e, value: e.visitedDate }))}
          />
          <CountChart countList={countList} />
        </>
      )}
    </>
  )
}

export default TravelMapScreen
