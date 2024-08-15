<template>
    <!-- Service bar -->


    <section>
        <nav>
            <router-link active-class="back" v-bind:to = "{ name: 'patientView' }">Back to Profile</router-link>
        </nav>
            
        <h1>Services</h1>
        
        <body>

        
            <h5><input type="text" placeholder="Search..." v-model="searchTerm" /></h5>
        
        
        
            <div class="service" v-for = "serviceName in filteredServiceList" v-bind:key ="serviceName.id">
                <router-link v-bind:to = "{name :'PatientServiceDetailsView', params: { name : serviceName } }"  > 
                    {{ serviceName }}
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
        cursor: pointer;
        /* margin: 20px; */
    }
    .service a {
        font-size: 20px;
        font-style: oblique;
        color:black;
        display: block;
        padding: 10px 20px;
        text-decoration: none;

    }
    .service a:hover {
        background-color: #f2f2f2;
        cursor: pointer;
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
    .back {
        display: flex;
        justify-content: flex-start;
        font-size: 50px;
        text-decoration: none;
        color:black;

    }

</style>