import React from 'react'
import { HorizontalBar } from 'react-chartjs-2'
import { MDBContainer } from 'mdbreact'

const CountChart = ({ counts }) => {
  return (
    <MDBContainer>
      <h3 className='mt-5'>Visted Country chart by All Users</h3>
      <HorizontalBar
        data={{
          labels: counts.map((c) => c.country),
          datasets: [
            {
              label: 'My First Dataset',
              data: counts.map((c) => c.count),
              fill: false,
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 205, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(201, 203, 207, 0.2)',
              ],
              borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)',
                'rgb(153, 102, 255)',
                'rgb(201, 203, 207)',
              ],
              borderWidth: 1,
            },
          ],
        }}
        options={{ responsive: true }}
      />
    </MDBContainer>
  )
}

export default CountChart