import axios from 'axios';

// axios.defaults.baseURL=



export default {

    createAppointment(bookAppointment) {
        return axios.post("/appointments", bookAppointment); 
    },

    getAppointments() {
        return axios.get("/appointments");
    }

}