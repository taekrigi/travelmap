import axios from 'axios'
import {
  GET_POSTS_REQUEST,
  GET_POSTS_SUCCESS,
  GET_POSTS_ERROR,
} from '../constants/postConstants'

export const getPosts = () => async (dispatch) => {
  try {
    dispatch({ type: GET_POSTS_REQUEST })

    const { data } = await axios.get(`/post`)

    dispatch({
      type: GET_POSTS_SUCCESS,
      payload: data,
    })
  } catch (error) {
    dispatch({
      type: GET_POSTS_ERROR,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    })
  }
}
