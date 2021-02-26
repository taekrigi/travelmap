import axios from 'axios'

import {
  TRAVEL_MAP_LIST_REQUEST,
  TRAVEL_MAP_LIST_SUCCESS,
  TRAVEL_MAP_LIST_FAIL
} from '../constants/travelMapConstants'

export const getTravelMaps = userId => async (disaptch) => {
  try {
    disaptch({ type: TRAVEL_MAP_LIST_REQUEST })

    const { data } = await axios.get(
      `http://localhost:8080/travelmaps/${userId}`
    )

    disaptch({
      type: TRAVEL_MAP_LIST_SUCCESS,
      payload: data,
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