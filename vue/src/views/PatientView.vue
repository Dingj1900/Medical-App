<template>
  <div class="patient">
   
    <head>
<title>Patient View</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="w3-theme-l5">
</body>
       
    <!-- link to settings -->
  
    <!-- link to make an appointment -->
    <!-- <h3>
      <router-link :to="{ name: 'bookAppointment'}">Book an Appointment</router-link> 
    </h3> -->
    <!--display upcoming and past appointments -->
    <!-- <AppointmentsListVue v-bind:appointmentsList="appointments"/> -->

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">Patient Profile</h4>
         <p class="w3-center">{{ this.$store.state.user.firstName }} {{this.$store.state.user.lastName}}</p>
         <hr>

         <!-- display info under profile picture, want to make this editable -->
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.phoneNumber }}</p>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.email }}</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.address }}, {{ this.$store.state.user.city }}, {{ this.$store.state.user.stateAbbreviation }} {{ this.$store.state.user.zipcode }}</p>
         <p><i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.dateOfBirth }}</p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">
          <div id="Demo1" class="w3-hide w3-container">
            <p>Some text..</p>
          </div>
          <button onclick="myFunction('Demo2')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Events</button>
          <div id="Demo2" class="w3-hide w3-container">
            <p>Some other text..</p>
          </div>
              <!-- link to settings -->
          <button class="w3-button w3-block w3-theme-l1 w3-left-align"> 
          <router-link :to="{ name: 'patientSettings'}">Settings</router-link>  </button>        
 
          <div id="Demo3" class="w3-hide w3-container">
         <div class="w3-row-padding">
         <br>
           <div class="w3-half">
             <img src="/w3images/lights.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/w3images/nature.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/w3images/mountains.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/w3images/forest.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/w3images/nature.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/w3images/snow.jpg" style="width:100%" class="w3-margin-bottom">
           </div>
         </div>
          </div>
        </div>      
      </div>
      <br>
      
      <!-- Interests --> 
      
      <br>
      
      <!-- Alert Box -->
      <div class="w3-container w3-display-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small">
        <span onclick="this.parentElement.style.display='none'" class="w3-button w3-theme-l3 w3-display-topright">
          <i class="fa fa-remove"></i>
        </span>
        <p><strong>Hey!</strong></p>
        <p>People are looking at your profile. Find out who.</p>
      </div>
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7">
    
      <!-- will be our filter for appointment eventually -->
      <div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <h6 class="w3-opacity">Social Media template by w3.css</h6>
              <p contenteditable="true" class="w3-border w3-padding">Status: Feeling Blue</p>
              <button type="button" class="w3-button w3-theme"><i class="fa fa-pencil"></i> Post</button> 
            </div>
          </div>
        </div>
      </div>
      
      <!-- For loop for appointment-->
      <PatientAppointment v-for = " appointment in appointments" v-bind:key = "appointment.appointmentId" :appointmentDetails = "appointment"/>
    <!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
    <div class="w3-col m2">
      <div class="w3-card w3-round w3-white w3-center">
        <div class="w3-container">
          <p><strong>View services to make an appointment:</strong></p>

          <p><button class="w3-button w3-block w3-theme-l4" @click="makeAppointment">Make Appointment</button></p>
        </div>
      </div>
      <br>
      
      <br>
      
      <div class="w3-card w3-round w3-white w3-padding-16 w3-center">
        <p>ADS</p>
      </div>
      <br>
      
      <div class="w3-card w3-round w3-white w3-padding-32 w3-center">
        <p><i class="fa fa-bug w3-xxlarge"></i></p>
      </div>
      
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <h5>Footer</h5>
</footer>

<footer class="w3-container w3-theme-d5">
</footer>
  </div>
</template>



<script>


import PatientService from '../services/PatientService.js';
import PatientAppointment from '../components/PatientAppointment.vue';




export default {
  
  components: {

    PatientAppointment
  },
  data() {
    return {
    appointments: []
    };
  },
  methods:{
    makeAppointment(){
      this.$router.push("/patient/services");
    }

  },
  created() {
    PatientService.getAppointments().then(
        (response)=>{
          if(response.status == 200){
            //will need the name of the object returned
            this.appointments = response.data;
          }
        }
      )
      .catch(
        (error)=>{
          console.log("Cannot find appointments for patient");
        }
      );
  }

};
</script>

<style scoped>

</style>