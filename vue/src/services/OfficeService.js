import axios from 'axios';

export default {

    get(id) {
        return axios.get(`/provider/office/${id}`);
      },

    add(officeObject) {
        return axios.post('/provider/office', officeObject);
      },

    edit(officeObject) {
        return axios.put(`/provider/office/${officeObject.id}`, officeObject);
      },
    
    
}