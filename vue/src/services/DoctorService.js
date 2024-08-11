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
updateOffice(officeObject) {
  return axios.put('/provider/office', officeObject);
}


}