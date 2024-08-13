<template>
    <!-- Service bar -->
    <div>
        <div>
            <h1>Services</h1>
        </div>

        <div>
            <h2>Search<input /></h2>
        </div>
    </div>

    <div v-for = "service in servicesList" v-bind:key ="service.id">
        <router-link v-bind:to = "{name :'PatientServiceDetailsView', params:{name : service} }"  > 
            Service: {{ service }}
        </router-link>
    </div>
</template>

<script>

import PatientService from '../services/PatientService.js';


export default {
    components: {
        PatientService
    },
    data(){
        return{
            servicesList: []
        }
    },
    created(){
        PatientService.getServices().then(
            (response)=>{
                if(response.status == 200){
                    console.log(response.data);
                    this.servicesList = response.data;
                }
            }
        ).catch(
            (error)=>{
                console.log("Cannot get services");
            }
        );
    }
}

</script>

<style scoped>


</style>