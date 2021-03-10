import { testReducer } from './testReducer'

export const testDispatch = () => async (dispatch) => {
  dispatch({ type: 'TEST' })
}
