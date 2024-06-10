import { Link, useParams } from 'react-router-dom'
import { EventModel } from '../../models/responses/EventModel'
import { useEffect, useState } from 'react'
import productService from '../../services/productService'
import toastr, { error } from "toastr";
import { UserModel } from '../../models/responses/UserModel';
import userService from '../../services/userService';
import { AttendancePostModel } from '../../models/requests/AttendancePostModel';


type Props = {}

const EventDetail = (props: Props) => {

  const params = useParams<{ id: string }>()
  const [event, setEvent] = useState<EventModel>()
  const [owner, setOwner] = useState<UserModel>();
  let ownerId;
  
  // User must be here!
  const user = localStorage.getItem("currentUser");

  const attendanceData: AttendancePostModel = {
    userId: parseInt(user!),
    //recipientId: parseInt(owner?.id),
    eventId: parseInt(params.id!)
  }

  useEffect(() => {
    if (params.id) {
      productService.getEventById(parseInt(params.id)).then(response => {
        setEvent(response.data);
      });
    }
    fetchUser();
  }, [params.id]);

  const handleClick = () =>{
    console.log(user);
    
    if(user != null){
      productService.postAttendanceRequest(attendanceData);
      toastr.success("Join request sent successfully");
    }else{
      toastr.error("Please Login First");
    }
  }
  const fetchUser = () =>{
    productService.getEventById(parseInt(params.id!)).then(response => {
      ownerId = response.data.ownerId;
      console.log(ownerId);
      
    })
    userService.getUserById(ownerId!).then(response => {
      setOwner(response.data);
      console.log(response);
      console.log(response.data);
      
      
    })
  }

  return (
    <div className='flex justify-center'>
      <div className='w-[750px] flex'>{/* Car Detail */}
        <div className='container flex flex-col shadow-xl my-12 pt-10 items-center pl-10'>
          {/* Content */}
          <div className='flex flex-row justify-between '>
            {/* Left Content */}
            <div className='flex flex-col h-48 w-1 justify-center'>
              {/* Image */}
              {/* <div className='flex object-fill pl-16'>
                <img src={product?.image} alt="car-image" className='rounded-lg' />
              </div> */}
            </div>
            {/* Right Content */}
            <div className='flex flex-col'>
              {/* Car Info */}
              <div className='flex flex-row gap-10 tracking-wide'>
                {/* Car Properties */}
                <div className='w-56 border-r-2'>
                  <div className='text-2xl tracking-wide pb-4'>
                    <p>{event?.name}</p>
                  </div>
                  <div className='text-md font-comfortaa text-gray-600 flex flex-col gap-[14px]'>
                    <div><span className='font-black text-md pr-2'></span> {event?.location}</div>
                    <div><span className='font-black text-md pr-[6px]'></span> {event?.date}</div>
                    <div><span className='font-black text-md pr-1'></span> {event?.time}</div>
                  </div>
                </div>
                {/* Requirements */}
                <div className='w-52'>
                  <div className='text-2xl tracking-wide pb-4'>
                    <p>Owner</p>
                  </div>
                  <div className='text-md font-comfortaa text-gray-600 flex flex-col gap-[14px]'>
                    <div><span className='font-black text-md pr-[10px]'></span>{owner?.name}</div>
                    <div><span className='font-black text-md pr-2'></span>{owner?.surname}</div>
                    <div><span className='font-black text-md pr-2'></span> {owner?.email}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          {/* Sub Info */}
          <div className='flex flex-row w-50 h-24 justify-between items-center '>
            {/* Right Content */}
            <div className='bg-white flex flex-col justify-items-center items-center'>
              {/* Price */}
              <div className='flex flex-row items-center gap-5'>
              {/* Hire Button */}
              <button onClick={handleClick} className='w-34 h-12 bg-gray-300 text-[16px] font-open text-white hover:bg-green-500 transition duration-400 rounded-full px-4'>Katılmak istiyorum </button>
              <div className=''>
              <Link to={"/events"}> <button className='w-34 h-12 bg-gray-300 text-[16px] font-open text-white hover:bg-slate-500 transition duration-400 rounded-full px-4'>Geri Dön! </button></Link>
              </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default EventDetail