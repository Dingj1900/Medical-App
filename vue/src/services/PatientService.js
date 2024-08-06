import axios from 'axios';

export default {
        createPatient(patientObject) {
            return axios.post("/patient/register", patientObject)
        }
}