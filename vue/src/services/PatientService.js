import axios from 'axios';

export default {

        getAppointments() {
                return axios.get("/patient/appointments");
            },

        createAppointment(appointmentObject) {
                return axios.post("/patient/appointment", appointmentObject); 
            },
        
        getOffices() {
                return axios.get("/patient/offices");
            },

        getDoctorByOfficeId(id) {
                return axios.get(`/patient/office/${id}/provider`)
            },

        getServicesByDoctor(id) {
                return axios.get(`/patient/provider/${id}/services`);
            },


       // updateAppointment(id) {
       //        return axios.put(`patient/appointment/${id}`)
       //  },

}