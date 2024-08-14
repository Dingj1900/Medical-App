<template>
    <div>
    <h2>{{ serviceName }}</h2></div>
    <div v-for = "serviceInfoObject in serviceInfo" v-bind:key ="serviceInfoObject.id" class="service">
        
        Dr. {{ serviceInfoObject.user.firstName + " " + serviceInfoObject.user.lastName }}
        <br>
        Office: {{ serviceInfoObject.office.officeName }} Location: {{ serviceInfoObject.office.officeAddress }}
        <br>
        Price: ${{ serviceInfoObject.service.hourlyRate }}
   
        <a class="serviceLinks" @click.prevent="commitInfo(serviceInfoObject)">
            Make an appointment for {{ serviceInfoObject.service.serviceName }}
        </a>
    </div>
</template>



<script>

import PatientService from '../services/PatientService';


export default{

    data(){
        return{
            serviceName: this.$route.params.name,
            serviceInfo: []
        }
    },
    methods: {
        commitInfo(service) {
            this.$store.commit("SET_APPOINTMENT_INFO", service);
            this.$router.push({name : 'PatientMakeAppointmentView'});
        }
    },
    created(){
        PatientService.getServiceInfo(this.serviceName).then(
            (response)=>{
                if(response.status == 200){
                    console.log(response.data);
                    this.serviceInfo = response.data;
                }
            }
        ).catch(
            (error)=>{
                console.log("Unable to get service info from name");
            }
        );
    }


}
</script>



<style scoped>
    .serviceLinks {
        text-decoration: underline;
        color: blue;
        cursor: pointer;
        margin: 20px;
    }

  .service{
  background: rgb(245, 245, 245);
  border: solid 2px rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  margin-bottom: 10px;
  padding: 10px;
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
  cursor: pointer;
}
</style>