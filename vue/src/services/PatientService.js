import axios from 'axios';

export default {

        getAppointments() {
                return axios.get("patient/appointments");
            },

        createAppointment(bookAppointment) {
                return axios.post("patient/appointment", bookAppointment); 
            },

        updateAppointment(id) {
                return axios.put(`patient/appointment/${id}`)
           },
        
        getOffice() {
                return axios.get("patient/office");
            },

        getServices() {
                return axios.get("patient/office/services");
            },

        

}