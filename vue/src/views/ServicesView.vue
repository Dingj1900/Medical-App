<template>
  <section>
        <h1>This is where the services will be</h1>
  </section>

  <div>

  </div>

  <div>
    <div>

    </div>

  </div>
</template>

<script>

import DoctorService from '../services/DoctorService.js';

export default {
  data(){
    return{
      services : []

    }
  },
  created(){
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