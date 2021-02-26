import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import { travelMapListReducer } from './reducers/travelMapReducer'

const reducer = combineReducers({
  travelMapList: travelMapListReducer
})

const middleware = [thunk]

const initialState = {}

const store = createStore(
  reducer,
  initialState,
  composeWithDevTools(applyMiddleware(...middleware))
)

export default store