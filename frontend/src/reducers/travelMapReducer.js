import {
  TRAVEL_MAP_LIST_REQUEST,
  TRAVEL_MAP_LIST_SUCCESS,
  TRAVEL_MAP_LIST_FAIL,
  VISITED_COUNTRIES_COUNT_REQUEST,
  VISITED_COUNTRIES_COUNT_SUCCESS,
  VISITED_COUNTRIES_COUNT_FAIL,
  TRAVEL_MAP_CLEAR,
  DELETE_TRAVEL_MAP_REQUEST,
  DELETE_TRAVEL_MAP_SUCCESS,
  DELETE_TRAVEL_MAP_FAIL,
} from '../constants/travelMapConstants'

export const travelMapReducer = (
  state = { travelMapList: [], countList: [] },
  action
) => {
  switch (action.type) {
    case TRAVEL_MAP_LIST_REQUEST:
      return {
        ...state,
        loading: true,
        travelMapList: [],
        loading: false,
        error: null,
      }
    case TRAVEL_MAP_LIST_SUCCESS:
      return {
        ...state,
        loading: false,
        travelMapList: action.payload,
      }
    case TRAVEL_MAP_LIST_FAIL:
      return {
        ...state,
        loading: false,
        travelMapList: [],
        error: action.payload,
      }
    case VISITED_COUNTRIES_COUNT_REQUEST:
      return { ...state, loading: true, countList: [] }
    case VISITED_COUNTRIES_COUNT_SUCCESS:
      return { ...state, loading: false, countList: action.payload }
    case VISITED_COUNTRIES_COUNT_FAIL:
      return { ...state, loading: false, countList: [], error: action.payload }
    case TRAVEL_MAP_CLEAR:
      return { ...state, travelMapList: [], countList: [] }
    case DELETE_TRAVEL_MAP_REQUEST:
      return { ...state, loading: true }
    case DELETE_TRAVEL_MAP_SUCCESS:
      return {
        ...state,
        travelMapList: [
          ...state.travelMapList.filter((t) => t.id !== action.payload),
        ],
        countList: state.countList - 1,
      }
    case DELETE_TRAVEL_MAP_FAIL:
      return {
        ...state,
        loading: false,
        error: action.payload,
      }
    default:
      return state
  }
}
