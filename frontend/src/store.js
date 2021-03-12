import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import { travelMapReducer } from './reducers/travelMapReducer'
import { userReducer } from './reducers/userReducer'
import { postReducer } from './reducers/postReducer'

const reducer = combineReducers({
  travelMap: travelMapReducer,
  user: userReducer,
  post: postReducer,
})

const middleware = [thunk]

const initialState = {
  user: {
    user: {},
    loggedIn: false,
  },
  travelMap: {
    travelMapList: [],
    countList: [],
  },
  post: {
    postList: [],
    post: {},
  },
}

const store = createStore(
  reducer,
  initialState,
  composeWithDevTools(applyMiddleware(...middleware))
)

export default store
