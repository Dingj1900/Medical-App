<template>
    <div v-for = "serviceInfoObject in serviceInfo" v-bind:key ="serviceInfoObject.id">
        {{ serviceInfoObject.user.firstName + " " + serviceInfoObject.user.lastName }} : 
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
</style>