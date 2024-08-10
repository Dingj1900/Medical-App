<template>
  <div>Book an appointment with the provider of your choice!</div>
  <form>

<div class="inputForm">
  <label for="firstName">What is your first name? </label>
  <input id="firstName" type="text" v-model="firstName" />
</div>

<div class="inputForm">
  <label for="lastName">What is your last name? </label>
  <input id="lastName" type="text" v-model="lastName" />
</div>

<div class="inputForm">
  <label>What is the reason for your appointment? </label>
  <select v-model="reason">
    <option value="checkUp">Check Up</option>
    <option value="physical">Physical</option>
    <option value="urgent">Urgent</option>
    <option value="coldFlu">Cold/Flu</option>
    <option value="other">Other</option>
  </select>
</div>

<div class="inputForm">
  <label for="appointmentDate">Which day would you like? </label>
  <input id="appointmentDate" type="date" v-model="appointmentDate" />
</div>


<!-- add actual doctor times instead of this -->
<div class="inputForm">
  <label>What time would work best for you? </label>
  <select v-model="appointmentTime">
    <option value="am">Morning</option>
    <option value="pm">Evening</option>
    <option value="afternoon">Afternoon</option>
  </select>
</div>

<div class="inputForm">
  <label for="doctorId">What is your doctor's Id? </label>
  <input id="doctorId" type="text" v-model="doctorId" />
</div>


<input type="submit" value="Book it!" @click.prevent="handleSubmit" />

</form>
</template>

<script>

import AppointmentService from '../services/AppointmentService.js';

export default {
  data() {
    return {
      appointment: {
     
      firstName: '',
      lastName: '',
      reason: '',
      appointmentDate: '',
      appointmentTime: '',
      doctorId: '',
      appointmentId: '',
      }
      
    };
  },

  methods: {
    appointmentForm() {

      const newApptObject = 
      {
        first: this.firstName,
        last: this.lastName,
        reason: this.reason,
        apptDate: this.appointmentDate,
        apptTime: this.appointmentTime,
        doctor: this.doctorId,
        apptId: this.appointmentId
      };

      AppointmentService.createAppointment(newApptObject).then((r) => { 
        console.log(r);
        this.$router.push({ name: "patientView" });
      }).catch((e) => { console.error(e)});


    }
  }

}
</script>

<style scoped>

</style>