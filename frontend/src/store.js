import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import { travelMapListReducer } from './reducers/travelMapReducer'
import { userReducer } from './reducers/userReducer'

const reducer = combineReducers({
  travelMapList: travelMapListReducer,
  userInfo: userReducer,
})

const middleware = [thunk]

const initialState = {
  userInfo: JSON.parse(localStorage.getItem('USER_INFO')) || {},
  travelMapList: {
    travelMaps: [],
    counts: [],
  },
}

const store = createStore(
  reducer,
  initialState,
  composeWithDevTools(applyMiddleware(...middleware))
)

export default store
