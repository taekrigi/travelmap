import {
  GET_POSTS_REQUEST,
  GET_POSTS_SUCCESS,
  GET_POSTS_ERROR,
} from '../constants/postConstants'

export const postReducer = (
  state = {
    postList: [],
    post: {},
    comments: [],
    loading: false,
    error: false,
  },
  action
) => {
  switch (action.type) {
    case GET_POSTS_REQUEST:
      return { ...state, loading: true, error: null, postList: [] }
    case GET_POSTS_SUCCESS:
      return {
        ...state,
        loading: false,
        error: false,
        postList: action.payload,
      }
    case GET_POSTS_ERROR:
      return { ...state, loading: false, error: action.payload }
    default:
      return state
  }
}
