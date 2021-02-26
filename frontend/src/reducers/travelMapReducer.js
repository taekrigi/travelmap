import { 
  TRAVEL_MAP_LIST_REQUEST, 
  TRAVEL_MAP_LIST_SUCCESS, 
  TRAVEL_MAP_LIST_FAIL 
} from '../constants/travelMapConstants'

export const travelMapListReducer = (state = { travelMaps: [] }, action) => {
  switch(action.type) {
    case TRAVEL_MAP_LIST_REQUEST:
      return { loading: true, travelMaps: [] }
    case TRAVEL_MAP_LIST_SUCCESS:
      return { loading: false, travelMaps: action.payload.travelMaps }
    case TRAVEL_MAP_LIST_FAIL:
      return { loading: false, error: action.payload }
    default:
      return state
  }
}