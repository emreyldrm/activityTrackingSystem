import axiosInstance from "../utils/interceptors/axiosInterceptors";

class UserService{

    
    getUserById(id:number){
        return axiosInstance.get("users/" + id)
    }
    
}
export default new UserService();