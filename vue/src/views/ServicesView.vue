<template>
  <section>
        <h1>This is where the services will be</h1>

  <div>

     <!-- <h2>{{ serviceName }}</h2> -->
    </div>
    <div v-for = "serviceObject in services" v-bind:key ="serviceObject.serviceId" class="service">
        
      <h2>{{ serviceObject.serviceName }}</h2>
      <h4>${{ serviceObject.hourlyRate }} / hr</h4>
      <p>{{ serviceObject.serviceDetails }}</p>
      <button @click="goToUpdateService(serviceObject)">Edit This Service</button>
    </div>
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
</style>