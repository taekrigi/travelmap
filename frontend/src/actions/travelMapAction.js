import axios from 'axios'

import {
  TRAVEL_MAP_LIST_REQUEST,
  TRAVEL_MAP_LIST_SUCCESS,
  TRAVEL_MAP_LIST_FAIL
} from '../constants/travelMapConstants'

export const getTravelMaps = userId => async (disaptch) => {
  try {
    disaptch({ type: TRAVEL_MAP_LIST_REQUEST })

    // TODO: SET REAL DATA
    // const { data } = await axios.get(
    //   `http://localhost:8080/travelmaps/${userId}`
    // )

    disaptch({
      type: TRAVEL_MAP_LIST_SUCCESS,
      payload: { 
        travelMaps: 
          [
            { 
              country: 'kr', 
              value: 1
            },
            {
              country: 'jp',
              value: 2
            },
            {
              country: 'nz',
              value: 3
            },
            {
              country: 'de',
              value: 4
            },
            {
              country: 'at',
              value: 5
            },
            {
              country: 'cz',
              value: 6
            },
            {
              country: 'fr',
              value: 7
            },
            {
              country: 'tw',
              value: 8
            },
            {
              country: 'vn',
              value: 9
            },
            {
              country: 'ch',
              value: 10
            },
          ] 
      },
    })
  } catch (error) {
    disaptch({
      type: TRAVEL_MAP_LIST_FAIL,
      payload: 
        error.response && error.response.data.message 
          ? error.response.data.message
          : error.message
    })
  }
}