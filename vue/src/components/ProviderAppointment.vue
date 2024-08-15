<template>
  <div class="w3-container w3-card w3-white w3-round w3-margin"><br>

      <span class="w3-right w3-opacity">
          <p>Time: {{ appointmentDetails.apptDate }} </p>
      </span>

      <h4>Patient: {{ appointmentDetails.doctorFirstName }} {{ appointmentDetails.doctorLastName }}</h4><br>
      <hr class="w3-clear">

          <p>Gender: {{ appointmentDetails.gender }}</p>
          <p>Email: {{ appointmentDetails.email }}</p>
          <p>Phone: {{ appointmentDetails.phone_number }}</p>
          <p>Birth: {{ appointmentDetails.dateOfBirth }}</p>
          
          <p>Service: {{ appointmentDetails.serviceDescription }}</p>
      
      <div class="w3-row-padding" style="margin:0 -16px">
          <div class="w3-half">
              <!--<img src="/w3images/lights.jpg" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">-->
            <p>{{ appointmentDetails.apptFrom }}</p>
          </div>

          <div class="w3-half">
              <!--<img src="/w3images/nature.jpg" style="width:100%" alt="Nature" class="w3-margin-bottom">-->
              <p>{{ appointmentDetails.apptTo }}</p>
          </div>
      </div>
      
      <!-- <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  Update</button>  -->
      <!-- <button @click="deleteAppt" type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-ban"></i> Delete</button>  -->
      
  </div>
    
</template>
<script>
import DoctorService from '../services/DoctorService.js';
export default{
  props:{
      appointmentDetails:{
          type: Object,
          required: true
      }
  },
  methods: {
        deleteAppt(){
           DoctorService.deleteAppointments(this.appointmentDetails.appointmentId).then(

           ).catch(

           );
        }
  },
  data(){
      return{


      };
  }
}
</script>
<style scoped>
</style>