<template>

 <div>
  
  <h2>Patient Information</h2>

 <div class="card">
  <div class="container">
    <h4><b>Patient Settings for {{ this.$store.state.user.firstName }} {{this.$store.state.user.lastName}}</b></h4>
   <label>Phone number:</label> <input v-model="user.phoneNumber"/>
    <label>E-mail address:</label> <input v-model="user.email"/>
    <label>Address:</label> <input v-model="user.address"> <input v-model="user.city"> <input v-model="user.stateAbbreviation"> <input v-model="user.zipcode">
    <label>DOB:</label> <input v-model="user.dateOfBirth"> 
    <input type="text" name="" id="">
  </div>
</div>


</div>


<!-- 
          <router-link :to="{ name: 'patientSettings'}">Settings</router-link>    
  -->



      <!-- <p> Name: {{ this.$store.state.user.firstName }} {{ this.$store.state.user.middleInitials }} {{ this.$store.state.user.lastName }} </p>
      <p>{{ this.$store.state.user.phoneNumber }}</p>
      <p>{{ this.$store.state.user.email }}</p>
      <p>{{ this.$store.state.user.dateOfBirth }}</p>
      <p>{{ this.$store.state.user.address }} {{ this.$store.state.user.city }} {{ this.$store.state.user.stateAbbreviation }} {{ this.$store.state.user.zipcode }}</p>
      <p>{{ this.$store.state.user.gender }}</p>
      <p>{{ this.$store.state.user.gender }}</p>
    </div> -->

  
</template>



<script>
import PatientService from '../services/PatientService.js';

export default {
  components:{
    PatientService

  },
  data(){
    return{
      user : this.$store.state.user,
    }
  },
  methods:{
    updateProfile(){
      PatientService.updatePatient(this.user).then(
        (response)=>{
          if(response.status == 200){
            this.$store.commit('SET_USER', response.data);
            this.user = response.data;
          }
        }
      ).catch(
        (error)=>{
          console.log("Unable to update Patient");
        }
      );

    }
  }

}
</script>


<style scoped>
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 40%;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
  padding: 2px 16px;
  align-content: center;
}

</style>