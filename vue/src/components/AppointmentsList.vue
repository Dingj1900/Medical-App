<template>
    <!-- <div v-for="appointment in appointmentsList" v-bind:key="appointment.appointmentId">
    </div> -->
  <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
        <img src="/w3images/avatar2.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
        <span class="w3-right w3-opacity">time placeholder</span>
        <h4>patient name</h4><br>
        <hr class="w3-clear">
        <p>appointment information</p>
          <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-half">
            </div>
            <div class="w3-half">
          </div>
        </div>
        <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-address-book"></i> Appointment Details</button> 
        <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> Comments</button> 
      </div>
</template>

<script>
export default {
    props: ['appointmentsList']

}
</script>

<style scoped>

</style>