import { Route, Routes } from 'react-router-dom'
import './App.css'
import Homepage from './pages/Homepage/Homepage'
import EvenList from './pages/EventList/EvenList'
import EventDetail from './pages/EventDetail/EventDetail'
import Register from './pages/Register/Register'
import Login from './pages/Login/Login'
import Navbar from './components/Navbar/Navbar'
import AttendanceRequests from './pages/AttendanceRequests/AttendanceRequests'

function App() {

  return (
    <>
      <Navbar />
      <Routes>
        <Route path='/' element={<Homepage/>}/>
        <Route path='/home' element={<Homepage/>}/>
        <Route path='/events' element={<EvenList/>}/>
        <Route path='/events/:id' element={<EventDetail/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/attendanceRequest' element={<AttendanceRequests/>}/>
      </Routes>
    </>
  )
}

export default App
