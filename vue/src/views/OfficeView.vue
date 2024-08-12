<template>
    <div>
        <!--<office />-->
        <office />
    </div>
</template>

<script>
   // import office from '../components/Office.vue'; 
    import Office from '../components/Office.vue';
    import DoctorService from '../services/DoctorService';

    export default {
        components: {
            Office
        },

    data(){
        return{
            office: {}
        };
    },
    created() {
           const id =this.$store.state.user.id;
    
      DoctorService.getOfficeByDoctor(id).then((response) => {
      
      this.office = response.data.office;
    });
    }

    };
</script>

<style scoped>
</style>