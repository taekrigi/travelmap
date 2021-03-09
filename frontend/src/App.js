import './App.css'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import Header from './components/Header'
import Footer from './components/Footer'
import TravelMapScreen from './screens/TravelMapScreen'
import LoginScreen from './screens/LoginScreen'
import RegisterScreen from './screens/RegisterScreen'
import LogoutScreen from './screens/LogoutScreen'
import TravelMapChangeScreen from './screens/TravelMapChangeScreen'
import TestScreen from './test/TestScreen'

const App = () => {
  return (
    <Router>
      <main className='py-3'>
        <Header />
        <Container>
          <Route path='/' component={TravelMapScreen} exact />
          <Route path='/login' component={LoginScreen} exact />
          <Route path='/register' component={RegisterScreen} exact />
          <Route path='/logout' component={LogoutScreen} exact />
          <Route
            path='/travelmap/change'
            component={TravelMapChangeScreen}
            exact
          />
          <Route path='/test' component={TestScreen} exact />
        </Container>
        <Footer />
      </main>
    </Router>
  )
}

export default App
