import { Link } from "react-router-dom"
import { EventModel } from "../../models/responses/EventModel"


type Props = {
  event: EventModel;
}

const EventCard = (props: Props) => {


  return (
    <div>
      <Link to={`/events/${props.event.id}`}>
      <div className='flex flex-col h-24 w-96 bg-rentWhite shadow-2xl transition duration-500'>
        {/* Car Content */}
        <div className='group relative '>
          {/* Image */}
          {/* <div className='flex object-fill justify-center h-[170px] w-full group-hover:scale-105 transition duration-700'>
            <img src={props.product.image} alt="car-image" className='rounded-lg' />
          </div> */}
          {/* Text */}
          <div className='flex justify-between w-full group-hover:bg-cyan-800 group-hover:text-rentWhite transition duration-500'>
            {/* Left Text */}
            <div className='flex flex-col pl-4 pt-3 font-comfortaa '>
              <p className='font-black'><strong className="text-[24px]">{props.event.name}</strong></p>
              <div className='flex flex-row h-[50px] align items-center'>
                <div className='flex flex-col h-[24px] items-center'>
                  <p className='pl-1 pt-1 flex items-center'><i className="fa-solid fa-user text-[16px] flex items-center"><strong className='pl-1 text-[12px]'>{props.event.time}</strong></i></p>
                </div>
                <div className='flex flex-col h-[24px] items-center pl-1'>
                  <p className='pl-1 pt-1 flex items-center'><i className="flex items-center fa-solid fa-suitcase-rolling text-[16px]"><strong className='pl-1 text-[12px]'>{props.event.date}</strong></i></p>
                </div>
              </div>

            </div>
            {/* Right Text */}
            <div className='flex flex-col  font-comfortaa pr-4 pt-3'>
              <div className='flex justify-end'>
                <p><i className="fa-solid fa-dollar-sign text-[10px] pr-1"></i><strong className='text-[18px] font-open'>{props.event.location}</strong></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Link>
  </div>
  )
}

export default EventCard