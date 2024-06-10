import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { Link, useNavigate } from 'react-router-dom'
import { useAuth } from '../../pages/Login/AuthContext'

type Props = {}

const Navbar = (props: Props) => {

    const [user, setUser] = useState(localStorage.getItem("currentUser"));
    const navigate = useNavigate();
  

  const onClick = () => {
    localStorage.removeItem("jwtToken")
    localStorage.removeItem("currentUser")
    console.log("currentUser - onClick" + localStorage.getItem("currentUser"))

    setTimeout(() => {
        navigate('/');
      }, 500);
  }
  console.log("currentUser - navbar" + localStorage.getItem("currentUser"))


  return (
    <>
      {/* Header Section */}
      <header className="bg-cyan-900 py-3 lg:py-4 text-white font-comfortaa uppercase">
        {/* Header Container */}
        <div className='container flex items-center justify-between space-x-8 lg:space-x-10'>
          {/* Logo */}
          <Link to={"/"} className='text-sm lg:text-6xl font-bold text-transparent bg-gradient-to-tr bg-clip-text from-teal-400 from-10%  to-white to-70%'>Home</Link>
            {/* Mobile Menu */}
            <div className='block md:hidden'>
              <button className=''><i className="fa-solid fa-bars"></i></button>
            </div>
          {/* Navigation */}
          <nav className='hidden md:flex justify-between flex-1'>
            {/* Menu */}
            <div className="flex items-center lg:text-lg space-x-4 lg:space-x-6">
              <Link to={"/events"} className='hover:text-yellow-400 transition duration-500 whitespace-nowrap'>Events</Link>
              <Link to={"/notifications"} className='hover:text-yellow-400 transition duration-500 whitespace-nowrap'>Notifications</Link>
              <Link to={"/attendanceRequests"} className='hover:text-yellow-400 transition duration-500'>Attendance Request</Link>
            </div>
            {/* Login Area */}
            <div className="flex items-center space-x-4 lg:space-x-8">
              {/* Search Area */}
              <form >
                <div className='group border-r px-4 mx-4 py-1 border-rentYellow'>
                  <input type="text" className='opacity-0 group-hover:opacity-100 bg-transparent border-b border-rentWhite focus:outline-none w-24 lg:w-40 transition duration-500' />
                  <button className='-ml-4 group-hover:ml-0 transition duration-1000'><i className='fas fa-search group-hover:text-rentYellow transition duration-500'></i></button>
                </div>
              </form>
              {/* Sign in Area */}
              <div className="flex items-center space-x-2 lg:space-x-6 lg:text-lg">


                {/* Logout  */}
              
                
                
                 {/* {user != null ? <div><Link to={"/login"} className='hover:text-rentYellow cursor-pointer transition duration-500' onClick={onClick}>Logout</Link></div> : <div className='space-x-6'><Link to={"/login"} className='hover:text-rentYellow cursor-pointer transition duration-500 '>Login</Link>
                <Link to={"/register"} className='bg-rentYellow px-1 lg:px-3 py-1 hover:bg-yellow-500 hover:text-rentWhite rounded-sm cursor-pointer transition duration-500 whitespace-nowrap'>Sign in</Link></div> }  */}

                <Link to={"/login"} className='hover:text-yellow-400 cursor-pointer transition duration-500 '>Login</Link>
                <Link to={"/register"} className='bg-yellow-400 px-1 lg:px-3 py-1 hover:bg-yellow-500 hover:text-white rounded-sm cursor-pointer transition duration-500 whitespace-nowrap'>Sign in</Link>
                
              </div>
            </div>
          </nav>
        </div>
      </header>

    </>
  )
}

export default Navbar