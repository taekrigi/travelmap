import React from 'react'
import { Bar } from 'react-chartjs-2'

const options = {
  scales: {
    yAxes: [
      {
        ticks: {
          beginAtZero: true,
        },
      },
    ],
  },
}

const CountChart = ({ countList }) => {
  const viewCount = 5
  const filteredCountList = countList.filter((c, i) => i < viewCount)

  const data = {
    labels: filteredCountList.map((c) => c.country),
    datasets: [
      {
        label: '# of Visited Count',
        data: filteredCountList.map((c) => c.count),
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
        ],
        borderWidth: 1,
      },
    ],
  }

  return (
    <>
      <div className='header'>
        <h3 className='mt-5'>Visited Countries Count</h3>
      </div>
      <Bar data={data} options={options} />
    </>
  )
}

export default CountChart
