import axios from 'axios';


export default {
 
//previously gwtAppointments
getAppointmentsByDoctor() {
    return axios.get('/provider/appointments');
},

// previously get
getOfficeByDoctor() {
  return axios.get('/provider/office');
},
//previously add
createDoctorOffice(officeObject) {
  return axios.post('/provider/office', officeObject);
},
//previously edit
updateOffice(officeObject) {
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
  },
updateDoctor(doctor){
  return axios.put('/user/update', doctor)
},

deleteAppointments(apptId){
  return axios.delete('/provider/appointment/' + apptId)
}




}