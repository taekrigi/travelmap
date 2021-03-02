import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import Header from './components/Header'
import Footer from './components/Footer'
import TravelMapScreen from './screens/TravelMapScreen';
import LoginScreen from './screens/LoginScreen';
import RegisterScreen from './screens/RegisterScreen';

const App = () => {
  return (
    <Router>
    <main className='py-3'>
      <Container>
        <Route path='/' component={TravelMapScreen} exact />
        <Route path='/login' component={LoginScreen} />
        <Route path='/register' component={RegisterScreen} />
      </Container>
    </main>
  </Router>
  );
}

export default App;
