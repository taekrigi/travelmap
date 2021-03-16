import './App.css'
import { useEffect } from 'react'
import { BrowserRouter as Router } from 'react-router-dom'
import { useSelector, useDispatch } from 'react-redux'
import { Container } from 'react-bootstrap'
import Header from './components/Header'
import Footer from './components/Footer'
import AppRoute from './components/AppRoute'

import { verifyJwtToken } from './actions/userAction'

const App = () => {
  const dispatch = useDispatch()
  const user = useSelector((state) => state.user)

  useEffect(() => {
    if (!user.loggedIn) {
      dispatch(verifyJwtToken())
    }
  }, [])

  return (
    <Router>
      <main className='py-3'>
        <Header user={user} />
        <Container>
          <AppRoute user={user} />
        </Container>
        <Footer />
      </main>
    </Router>
  )
}

export default App
