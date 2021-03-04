import {
  TRAVEL_MAP_LIST_REQUEST,
  TRAVEL_MAP_LIST_SUCCESS,
  TRAVEL_MAP_LIST_FAIL,
  VISITED_COUNTRIES_COUNT_REQUEST,
  VISITED_COUNTRIES_COUNT_SUCCESS,
  VISITED_COUNTRIES_COUNT_FAIL,
} from '../constants/travelMapConstants'

export const travelMapListReducer = (
  state = { travelMaps: [], counts: [] },
  action
) => {
  switch (action.type) {
    case TRAVEL_MAP_LIST_REQUEST:
      return { ...state, loading: true, travelMaps: [] }
    case TRAVEL_MAP_LIST_SUCCESS:
      return { ...state, loading: false, travelMaps: action.payload.travelMaps }
    case TRAVEL_MAP_LIST_FAIL:
      return { ...state, loading: false, error: action.payload }
    case VISITED_COUNTRIES_COUNT_REQUEST:
      return { ...state, loading: true, counts: [] }
    case VISITED_COUNTRIES_COUNT_SUCCESS:
      return { ...state, loading: false, counts: action.payload.counts }
    case VISITED_COUNTRIES_COUNT_FAIL:
      return { ...state, loading: false, error: action.payload }
    default:
      return state
  }
}
