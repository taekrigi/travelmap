import React, { useState, useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import TravelMapList from '../components/travelMap/TravelMapList'
import countryList from 'country-list'
import { Button, Modal, Form } from 'react-bootstrap'
import { getTravelMaps } from '../actions/travelMapAction'
import axios from 'axios'

const TravelMapChangeScreen = () => {
  const dispatch = useDispatch()
  const { user } = useSelector((state) => state.user)
  const { travelMapList } = useSelector((state) => state.travelMap)
  const { username } = user

  const [showModal, setShowModal] = useState(false)
  const [country, setCountry] = useState(null)
  const [date, setDate] = useState(null)
  const [travelMapAdded, setTravelMapAdded] = useState(false)

  const hideModal = () => setShowModal(false)
  const showAddModal = () => {
    setShowModal(true)
    setTravelMapAdded(false)
  }

  const addTravelMap = async () => {
    try {
      const { data } = await axios.post(`/travelmap/user/${username}`, {
        country: country.toLowerCase(),
        city: '',
        latitude: 0,
        longitude: 0,
      })

      setCountry(null)
      setDate(null)
      hideModal()
      setTravelMapAdded(true)
    } catch (error) {
      console.error(
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message
      )
    }
  }

  useEffect(() => {
    dispatch(getTravelMaps(username))
  }, [travelMapAdded])

  return (
    <>
      <Button
        variant='primary'
        style={{ margin: '10px' }}
        onClick={showAddModal}
      >
        추가
      </Button>
      <TravelMapList travelMapList={travelMapList} />
      <Modal
        show={showModal}
        onHide={hideModal}
        size='lg'
        aria-labelledby='contained-modal-title-vcenter'
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id='contained-modal-title-vcenter'>
            여행지 추가
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId='exampleForm.SelectCustomSizeSm'>
              <Form.Label>국가 선택</Form.Label>
              <Form.Control
                as='select'
                size='sm'
                custom
                onChange={(e) => setCountry(e.target.value)}
              >
                {Object.entries(countryList.getNameList()).map(
                  ([key, value]) => (
                    <option key={value} value={value}>
                      {key}
                    </option>
                  )
                )}
              </Form.Control>
            </Form.Group>
            <Form.Group controlId='formBasicEmail'>
              <Form.Label>여행일자</Form.Label>
              <Form.Control
                type='date'
                placeholder='YYYY-MM-DD'
                required
                onChange={(e) => setDate(e.target.value)}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={addTravelMap} variant='primary'>
            추가
          </Button>
          <Button onClick={hideModal} variant='secondary'>
            닫기
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  )
}

export default TravelMapChangeScreen
