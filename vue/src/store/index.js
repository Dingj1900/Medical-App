import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      appointmentInfo: {},
<<<<<<< HEAD
      confirmedAppointments: [],
    },
    mutations: {
      ADD_APPOINTMENT(state, newAppointment) {
        state.confirmedAppointments.push(newAppointment);
=======
      serviceUpdateObject: {}
    },
    mutations: {
      SET_SERVICE_UPDATE_OBJECT(state, serviceUpdateObject) {
        state.serviceUpdateObject = serviceUpdateObject;
>>>>>>> 174c5ca513e0955f2af12031a1c6b382bd9bb958
      },
      SET_APPOINTMENT_INFO(state, serviceObject) {
        state.appointmentInfo = serviceObject;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_PATIENT(){}
    },
  });
  return store;
}
