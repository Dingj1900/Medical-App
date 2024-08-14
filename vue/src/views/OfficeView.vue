<template>
    <div>
        <!--<office />-->
        <provider-settings />
    </div>
</template>

<script>

    import ProviderSettings from '../components/ProviderSettings.vue';
    import DoctorService from '../services/DoctorService';

    export default {
        components: {
            ProviderSettings
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