import axios from 'axios';

export default {
 
//previously gwtAppointments
getAppointmentsByDoctor() {
    return axios.get('/provider/appointments');
},

// previously get
getOfficeByDoctor(id) {
  return axios.get('/provider/office');
},
//previously add
createDoctorOffice(officeObject) {
  return axios.post('/provider/office', officeObject);
},
//previously edit
updateOfficeById(officeObject) {
  return axios.put('/provider/office', officeObject);
},

getServicesByDoctor() {
    return axios.get('/provider/services');
  },
updateServiceById(servicesObject) {
    return axios.put('/provider/services', servicesObject)
  },
createService(servicesObject){
    return axios.post('/provider/services', servicesObject)
  }




}