import React from 'react'
import { Link } from 'react-router-dom'

type Props = {}

const Homepage = (props: Props) => {
  return (
    <div><div>
      {/* Highlights Content */}
      <div className="container flex flex-row justify-center space-x-8 lg:space-x-16 py-12 lg:py-24 bg-white text-slate-700">
        {/* Left Content */}
        <Link to={"/events"}><div className='group h-40 w-48 lg:h-80 lg:w-96 flex flex-col justify-center align items-center shadow-2xl hover:bg-cyan-400 hover:text-rentWhite transition duration-500 '>
          {/* Icon */}
          <div className='flex justify-center'>
            <i className="fa-solid fa-headset text-cyan-500 group-hover:text-rentWhite  text-4xl lg:text-8xl pb-8 group-hover:scale-110 transition duration-500">
            </i>
          </div>
          {/* Header */}
          <div className='flex justify-center'>
            <h3 className='font-comfortaa font-bold text-sm lg:text-5xl pb-2'>Events</h3>
          </div>
        </div>
        </Link>
        {/* Mid Content */}
        <Link to={"/register"}><div className='group h-40 w-48 lg:h-80 lg:w-96 flex flex-col justify-center align items-center shadow-2xl hover:bg-cyan-400 hover:text-rentWhite transition duration-500 '>
          {/* Icon */}
          <div className='flex justify-center'>
            <i className="fa-brands fa-bitcoin text-cyan-500 group-hover:text-rentWhite text-4xl lg:text-8xl pb-8 group-hover:scale-110 transition duration-500">
            </i>
          </div>
          {/* Header */}
          <div className='flex justify-center'>
            <h3 className='font-comfortaa font-bold text-sm lg:text-5xl pb-2'>Register</h3>
          </div>
        </div>
        </Link>
        {/* Right Content */}
        <Link to={"/login"}><div className='group h-40 w-48 lg:h-80 lg:w-96 flex flex-col justify-center align items-center shadow-2xl hover:bg-cyan-400 hover:text-rentWhite transition duration-500 '>
          {/* Icon */}
          <div className='flex justify-center'>
            <i className="fa-solid fa-tag text-cyan-500 group-hover:text-rentWhite text-4xl lg:text-8xl pb-8 group-hover:scale-110 transition duration-500">
            </i>
          </div>
          {/* Header */}
          <div className='flex justify-center'>
            <h3 className='font-comfortaa font-bold text-sm lg:text-5xl pb-2'>Login</h3>
          </div>
        </div>
        </Link>
      </div>
    </div>
    </div>
  )
}

export default Homepage