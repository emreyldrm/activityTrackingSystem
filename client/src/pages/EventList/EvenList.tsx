import { useEffect, useState } from "react";
import { EventModel } from "../../models/responses/EventModel";
import productService from "../../services/productService";
import EventCard from "../../components/EventCard/EventCard";

type Props = {}

const EvenList = (props: Props) => {

  const [events, setEvents] = useState<EventModel[]>([]);

  useEffect(() => {
    fetchEvents();
  },[])

  const fetchEvents = () => {
    productService.getAllEvents().then((response:any) =>{
      console.log(response.data);
      setEvents(response.data);
    })
  }

  return (
    <>
      <section className=' flex justify-center '>
        <div className='container flex flex-row flex-wrap  gap-x-8 gap-y-[30px] py-12 w-[900px]'>
        {
          events.map(events => (
            <div key={events.id}>
              <EventCard event={events} />
            </div>
          ))
        }
        </div>
      </section>
    </>
  )
}

export default EvenList