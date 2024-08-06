<template>
  <div class="patient">
    <!-- profile img random -->
    
    <h1> Patient Profile </h1>
    <!-- link to settings -->
    <h2>
      <router-link :to="{ name: 'patientSettings'}">Settings</router-link>
    </h2>
    <!-- link to make an appointment -->
    <h3>
      <router-link :to="{ name: 'bookAppointment'}">Book an Appointment</router-link> 
    </h3>
    <!--display upcoming and past appointments -->
    <AppointmentsListVue v-bind:appointmentsList="appointments"/>


    
  </div>
</template>

<script>

import PatientSettings from '../components/PatientSettings.vue';
import BookAppointment from '../components/BookAppointment.vue';
import AppointmentsListVue from '../components/AppointmentsList.vue';
import AppointmentService from '../services/AppointmentService.js';



export default {
  
  components: {
  //  PatientSettings,
   // BookAppointment,
    AppointmentsListVue
    
  },
  data() {
    return {
    appointments: []
    };
  },
  created() {
    // call the API to get the data!
    AppointmentService.getAppointments().then((response) => {
      // IN THE FUTURE
      this.appointments = response.data;
    });

  }

};
</script>

<style scoped>

</style>