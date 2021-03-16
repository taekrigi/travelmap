import axios from 'axios'

import {
  TRAVEL_MAP_LIST_REQUEST,
  TRAVEL_MAP_LIST_SUCCESS,
  TRAVEL_MAP_LIST_FAIL,
  VISITED_COUNTRIES_COUNT_REQUEST,
  VISITED_COUNTRIES_COUNT_SUCCESS,
  VISITED_COUNTRIES_COUNT_FAIL,
  DELETE_TRAVEL_MAP_REQUEST,
  DELETE_TRAVEL_MAP_SUCCESS,
  DELETE_TRAVEL_MAP_FAIL,
} from '../constants/travelMapConstants'

export const getTravelMaps = (userId) => async (dispatch) => {
  try {
    dispatch({ type: TRAVEL_MAP_LIST_REQUEST })

    const { data } = await axios.get(`/travelmap/user/${userId}`)

    dispatch({
      type: TRAVEL_MAP_LIST_SUCCESS,
      payload: data.map(({ id, country, visitedDate }) => ({
        id,
        country,
        visitedDate,
      })),
    })
  } catch (error) {
    dispatch({
      type: TRAVEL_MAP_LIST_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}

export const getVisitedCountriesCount = () => async (dispatch) => {
  try {
    dispatch({
      type: VISITED_COUNTRIES_COUNT_REQUEST,
    })

    const { data } = await axios.get(`/travelmap/count/countries`)

    dispatch({
      type: VISITED_COUNTRIES_COUNT_SUCCESS,
      payload: data,
    })
  } catch (error) {
    dispatch({
      type: VISITED_COUNTRIES_COUNT_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}

export const deleteTravelMap = (id) => async (dispatch) => {
  try {
    dispatch({ type: TRAVEL_MAP_LIST_REQUEST })

    await axios.delete(`/travelmap/${id}`)

    dispatch({
      type: TRAVEL_MAP_LIST_SUCCESS,
      payload: id,
    })
  } catch (error) {
    dispatch({
      type: TRAVEL_MAP_LIST_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}
