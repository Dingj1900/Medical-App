<template>
    <!-- Service bar -->
    <section>
            <h1> Services </h1>
        
    <body>

        
            <h5><input type="text" placeholder="Search..." v-model="searchTerm" /></h5>
        
        
        
            <div class="service" v-for = "service in filteredServiceList" v-bind:key ="service">
                <router-link v-bind:to = "{name :'PatientServiceDetailsView', params: { name : service } }"  > 
                    {{ service }}
                </router-link>
            </div>
         
        </body>
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

    .service {
        border-bottom: 1px solid #f2f2f2;
    }
    .service a {
        display: block;
        padding: 10px 20px;
    }
    h1 {
        display: flex;
        justify-content: center;
        font-size: 60px;
        border-bottom: 15px solid white;
    }
    h5 {
        border-bottom: 15px solid white;
    }
   

    body {
        justify-content: flex-start;
        align-items: center;
        
    }

</style>