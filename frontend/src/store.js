import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import { travelMapListReducer } from './reducers/travelMapReducer'
import { userReducer } from './reducers/userReducer'
import { postReducer } from './reducers/postReducer'

const reducer = combineReducers({
  travelMapList: travelMapListReducer,
  userInfo: userReducer,
  post: postReducer,
})

const middleware = [thunk]

const initialState = {}

const store = createStore(
  reducer,
  initialState,
  composeWithDevTools(applyMiddleware(...middleware))
)

export default store
