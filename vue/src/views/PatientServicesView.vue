<template>
    <!-- Service bar -->
    <section>
        <div>
            <h1>Services</h1>
        </div>

        <div>
            <h2><input type="text" placeholder="Search..." v-model="searchTerm" /></h2>
        </div>

        <ul>
            <li v-for = "service in filteredServiceList" v-bind:key ="service">
                <router-link v-bind:to = "{name :'PatientServiceDetailsView', params: { name : service } }"  > 
                    {{ service }}
                </router-link>
            </li>
        </ul>    
    </section>

</template>

<script>

import PatientService from '../services/PatientService.js';


export default {
    data() {
        return{
            searchTerm: '',
            servicesList: [],
        };
    },
    computed: {
        filteredServiceList() {
            if (this.searchTerm.trim() === '') {
                return this.servicesList;
            }

            return this.servicesList.filter(service => service.toLowerCase().includes(this.searchTerm.toLowerCase()));
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

    section {
        margin: 50px;
    }

</style>