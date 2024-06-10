import { AttendancePostModel } from './../models/requests/AttendancePostModel';
import { AxiosResponse } from "axios";
import axiosInstance from "../utils/interceptors/axiosInterceptors";

class ProductService{

    getAllEvents(): Promise<AxiosResponse<any, any>>{
        return axiosInstance.get("events/allEvents");
    }
    getEventById(id:number){
        return axiosInstance.get("events/" + id)
    }
    getAllNotificationByRecipientId(id:number){
        return axiosInstance.get("notifications/allNotifications/recipient/" + id);
    }
    getAllAttendanceRequestByEventId(id:number){
        return axiosInstance.get("attendanceRequest/allAttendance/event/" + id);
    }
    getAllAttendanceRequestByRecipientId(id:number){
        return axiosInstance.get("attendanceRequest/allAttendance/recipient/" + id);
    }
    getAttendanceRequestById(id:number){
        return axiosInstance.get("attendanceRequest/" +id);
    }
    postAttendanceRequest(model: AttendancePostModel){
        return axiosInstance.post("attendanceRequests/add",model);
    }
}
export default new ProductService();