<template>
  <div>
    <div>
        <h2>Patient Information</h2>
    </div>
    <div>
      <p> Name: {{ this.$store.state.user.firstName }} {{ this.$store.state.user.middleInitials }} {{ this.$store.state.user.lastName }} </p>
      <p>{{ this.$store.state.user.phoneNumber }}</p>
      <p>{{ this.$store.state.user.email }}</p>
      <p>{{ this.$store.state.user.dateOfBirth }}</p>
      <p>{{ this.$store.state.user.address }} {{ this.$store.state.user.city }} {{ this.$store.state.user.stateAbbreviation }} {{ this.$store.state.user.zipcode }}</p>
      <p>{{ this.$store.state.user.gender }}</p>
      <p>{{ this.$store.state.user.gender }}</p>
    </div>
    <div>
      
    </div>
  </div>
</template>


<script>
export default {
  data(){
    return{
      user : this.$store.state.user,
    }
  },
  methods:{
    updateProfile(){

    }
  }

}
</script>


<style scoped>

</style>