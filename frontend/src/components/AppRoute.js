import React from 'react'
import { Route, Switch } from 'react-router-dom'
import TravelMapScreen from '../screens/TravelMapScreen'
import LoginScreen from '../screens/LoginScreen'
import RegisterScreen from '../screens/RegisterScreen'
import LogoutScreen from '../screens/LogoutScreen'
import TravelMapChangeScreen from '../screens/TravelMapChangeScreen'
import PostScreen from '../screens/PostScreen'
import PostAddScreen from '../screens/PostAddScreen'

const AppRoute = ({
  user: {
    loggedIn,
    user: { authorities },
  },
}) => {
  return (
    <Switch>
      <Route path='/' component={TravelMapScreen} exact />

      {!loggedIn ? (
        <>
          <Route path='/login' component={LoginScreen} exact />
          <Route path='/register' component={RegisterScreen} exact />
        </>
      ) : authorities.includes('ROLE_ADMIN') ? (
        <>
          <Route path='/logout' component={LogoutScreen} exact />
          <Route
            path='/travelmap/change'
            component={TravelMapChangeScreen}
            exact
          />
          <Route path='/post' component={PostScreen} exact />
          <Route path='/post/add' component={PostAddScreen} exact />
        </>
      ) : authorities.includes('ROLE_USER') ? (
        <>
          <Route path='/logout' component={LogoutScreen} exact />
          <Route
            path='/travelmap/change'
            component={TravelMapChangeScreen}
            exact
          />
          <Route path='/post' component={PostScreen} exact />
          <Route path='/post/add' component={PostAddScreen} exact />
        </>
      ) : (
        <></>
      )}
    </Switch>
  )
}

export default AppRoute
