<template>
  <div class="doctor">
    <head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="w3-theme-l5">
</body>

<!-- Navbar -->
<!-- <div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Logo</a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-user"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-envelope"></i></a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications"><i class="fa fa-bell"></i><span class="w3-badge w3-right w3-small w3-green">3</span></button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
      <a href="#" class="w3-bar-item w3-button">One new friend request</a>
      <a href="#" class="w3-bar-item w3-button">John Doe posted on your wall</a>
      <a href="#" class="w3-bar-item w3-button">Jane likes your post</a>
    </div>
  </div>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
    <img src="/w3images/avatar2.png" class="w3-circle" style="height:23px;width:23px" alt="Avatar">
  </a>
 </div>
</div> -->

<!-- Navbar on small screens -->
<!-- <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
</div> -->

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">My Profile</h4>
         <!--img src="/w3images/avatar3.png" class="w3-circle" style="height:106px;width:106px" -->
         <p class="w3-center">Dr. {{ this.$store.state.user.firstName }} {{this.$store.state.user.lastName}}</p>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.phoneNumber }}</p>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> {{ this.$store.state.user.email }}</p>
         
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> Office: {{ office.officeName }}</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> {{ office.officeAddress }}</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> {{ office.phoneNumber }} </p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card w3-round">
        <div class="w3-white">


          <div id="Demo1" class="w3-hide w3-container">
            <p>Some text..</p>
          </div>
          <router-link :to="{name: 'calendarView'}"><button class="w3-button w3-block w3-theme-l1 w3-left-align">
            <i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Calendar</button></router-link>
          <div id="Demo2" class="w3-hide w3-container">
            <p>Some other text..</p>
          </div>

          <div id="Demo1" class="w3-hide w3-container">
            <p>Some text..</p>
          </div>
          <router-link :to="{name: 'servicesView'}"><button class="w3-button w3-block w3-theme-l1 w3-left-align">
            <i class="fa fa-user-md fa-fw w3-margin-right"></i>My Services</button></router-link>
          <div id="Demo2" class="w3-hide w3-container">
            <p>Some other text..</p>
          </div>

          <div id="Demo1" class="w3-hide w3-container">
          </div>
          <router-link :to="{ name: 'providerOfficeView', params: {officeId: 2}}"> <button class="w3-button w3-block w3-theme-l1 w3-left-align">
            <i class="fa fa-hospital-o fa-fw w3-margin-right"></i>My Office</button></router-link>

          
          <!-- <button class="w3-button w3-block w3-theme-l1 w3-left-align"> 
          <router-link :to="{ name: 'providerOfficeView', params: {officeId: 2}}">My Office</router-link>  </button>         -->
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
     <!-- <div class="w3-container w3-display-container w3-round w3-theme-l4 w3-border w3-theme-border w3-margin-bottom w3-hide-small">
        <span onclick="this.parentElement.style.display='none'" class="w3-button w3-theme-l3 w3-display-topright">
          <i class="fa fa-remove"></i>
        </span>
        <p><strong>Hey!</strong></p>
        <p>Someone Just Booked a New Appointment</p>
      </div>-->
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7">
    
      <!--<div class="w3-row-padding">
        <div class="w3-col m12">
          <div class="w3-card w3-round w3-white">
            <div class="w3-container w3-padding">
              <h6 class="w3-opacity">placeholder</h6>
              <button type="button" class="w3-button w3-theme"><i class="fa fa-pencil"></i> placeholder button</button> 
            </div>
          </div>
        </div>
      </div>-->

      <ProviderAppointment v-for = "appointment in appointments" :key ="appointment.appointmentId" :appointmentDetails="appointment"/>
        
    </div>

    <!-- End Middle Column -->
    
    
    <!-- Right Column -->
    <div class="w3-col m2">
      <div class="w3-card w3-round w3-white w3-center">
        <div class="w3-container">
          <p>Upcoming Appointments:</p>
          <!-- <img src="/w3images/forest.jpg" alt="Forest" style="width:100%;"> -->
          <p><strong>Name</strong></p>
          <p>Friday 15:00</p>
          <p><button class="w3-button w3-block w3-theme-l4">Info</button></p>
        </div>
      </div>
      <br>
      
      <br>
      
      <!--<div class="w3-card w3-round w3-white w3-padding-16 w3-center">
        <p>ADS because we're broke</p>
      </div>
      <br>
      
      <div class="w3-card w3-round w3-white w3-padding-32 w3-center">
        <p>Reviews</p>
      </div>-->
      
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
</footer>

<footer class="w3-container w3-theme-d5">
</footer>
  </div>
</template>

<script>
import DoctorService from '../services/DoctorService.js';
import ProviderAppointment from '../components/ProviderAppointment.vue';

export default {
    components: {
      ProviderAppointment
    },
    data() {
      return {
        appointments: [],
        office: {}
      };
      
    },
    methods:{

      getAppointments(){
        DoctorService.getAppointmentsByDoctor().then((response) => {
        if(response.status == 200){
          this.appointments = response.data;
      }
      }).catch((error)=>{
        console.log("Cannot find appointments for doctor");
      });
      },
      getOffice(){
        DoctorService.getOfficeByDoctor().then((response)=>{
        if(response.status == 200){
          this.office = response.data;
        }
      }).catch((error)=>{
        console.log("Cannot find office for doctor");
      });
      }

    },
    created() {
      
      this.getAppointments();
      this.getOffice();
     

    }

};
</script>

<style scoped>

html, body, h1, h2, h3, h4, h5 {
  font-family: "Open Sans", sans-serif;
}
</style>