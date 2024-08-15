<template>
  <section>
        <h1>My Services</h1>

  <!-- <div class="bigBox"> -->
    <div class="serviceBox" v-for = "serviceObject in services" v-bind:key ="serviceObject.serviceId">
        
      <h2>{{ serviceObject.serviceName }}</h2>
      <h3> ${{ serviceObject.hourlyRate }} / hr </h3>
      <!-- <h4>${{ serviceObject.hourlyRate }} / hr</h4> -->
      <h5>{{ serviceObject.serviceDetails }}</h5>
    
      <button class="editService" @click="goToUpdateService(serviceObject)">Edit Service</button>
    </div>
  <!-- </div> -->
    
      <!-- Price: ${{ serviceInfoObject.service.hourlyRate }} -->
   
        <!-- <a class="serviceLinks" @click.prevent="commitInfo(serviceInfoObject)">
            Make an appointment for {{ serviceInfoObject.service.serviceName }}
        </a> -->
    <button @click="goToUpdateService({})">Add Service</button>

</section>

</template>

<script>

import DoctorService from '../services/DoctorService.js';

export default {
  data() {
    return{
      serviceName: this.$route.params.name,
      services: [],
    }
  },
  methods: {
    goToUpdateService(serviceToEdit) {
      this.$store.commit("SET_SERVICE_UPDATE_OBJECT", serviceToEdit);
      this.$router.push({ name: 'servicesViewUpdate' });
    },
  },
  created() {
    DoctorService.getServicesByDoctor().then(
      (response)=>{
        if(response.status == 200){
          this.services = response.data;
        }
      }
    ).catch(
      (error)=>{
        console.log("Unable to get services for doctor");
      }
    );
  }
}
</script>

<style scoped>

h1 {
  display: flex;
        justify-content: center;
        font-size: 60px;
        border-bottom: 15px solid white;
}
/* .service {
        text-align: center;
        font-size: 20px;
        font-style: oblique;
        color:black;
        display: block;
        padding: 10px 20px;
        text-decoration: none;
} */
.editService {
  display: flex;
  justify-content: flex-start;
  background-color: rgb(79, 143, 143);
  font-weight: bold;
}
.bigBox {
  /* display: flex;
  flex-direction: row;
  align-items: center; */

}
.serviceBox {
  display: flex;
  width: 80%;
  margin-left: 10%;
  justify-content: center;
  border: solid;
  display: block;
  background-color: #c4d6da;
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  margin-bottom: 10px;
  cursor: pointer;
  text-align: center;
  font-style: oblique;
  color:black;
  display: block;
  padding: 10px 20px;
}
</style>