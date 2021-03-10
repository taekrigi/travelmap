export const testReducer = (state = {}, action) => {
  if (action.type === 'TEST') return { ...state, reducerTest: !!action.payload }
  else {
    return { ...state }
  }
}
