<template>
    <div v-for ="service in serviceInfo" v-bind:key ="service.id">
        {{ service.user.firstName }}
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
</style>