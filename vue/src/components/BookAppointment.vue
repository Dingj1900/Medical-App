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
    <option value="urgent">Urgent Care</option>
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
  <label>What time works best for you?</label>
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
    handleSubmit() {

      const newApptObject = 
      {
        serviceId: this.serviceId,
        officeId: this.officeId,
        doctorId: this.doctorId,
        patientId:this.patientId,
        apptFrom: this.apptFrom,
        apptTo: this.apptTo,
        openMonday: this.openMonday,
        openTuesday: this.openTuesday,
        openWednesday: this.openWednesday,
        openThursday: this.openThursday,
        openFriday: this.openFriday,
        openSaturday: this.openSaturday,
        openSunday: this.openSunday,
        notified: this.notified,
        approved: this.approved,
  
      };

      AppointmentService.createAppointment(newApptObject).then((response) => {console.log(response)}).catch((error) => {console.log(error)});
        this.$router.push({ name: "patientView" });
    }
  }

}
</script>

<style scoped>

</style>