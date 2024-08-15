<template>
  <section id = "page">
    <div id = "leftColumn">

      <!--for formatting to seperate display and value-->
      <div></div>
      <div></div>

      <h3> Profile </h3>
        <h5>First name     : {{ doctor.firstName }}</h5>
        <h5>Last name      : {{ doctor.lastName }}</h5>
        <h5>Email          : {{ doctor.email }}</h5>
        <h5>Phone Number   : {{ doctor.phoneNumber }}</h5>
        <h5>Gender         : {{ doctor.gender }}</h5>
        <h5>Hours from     : {{ doctor.hoursFrom }}</h5>
        <h5>Hours to       : {{ doctor.hoursTo }}</h5>
 
        <h5>Open Sunday    : {{ doctor.openSunday }}</h5>
        <h5>Open Monday    : {{ doctor.openMonday }}</h5>
        <h5>Open Tuesday   : {{ doctor.openTuesday }}</h5>
        <h5>Open Wednesday : {{ doctor.openWednesday }}</h5>
        <h5>Open Thursday  : {{ doctor.openThursday }}</h5>
        <h5>Open Friday    : {{ doctor.openFriday }}</h5>
        <h5>Open Saturday  : {{ doctor.openSaturday }}</h5>


        <h5>Office name    : {{ doctorOffice.officeName }}</h5>
        <h5>Office address : {{ doctorOffice.officeAddress }}</h5>
        <h5>Office phone   : {{ doctorOffice.phoneNumber }}</h5>
    </div>
    
    <div id = "middleColumn">
      <h3>Update</h3>
        <h5>First name     : <input type="text" v-model = "newDoctor.firstName"> </h5> 
        <h5>Last name      : <input type="text" v-model = "newDoctor.lastName"></h5>
        <h5>Email          : <input type="text" v-model = "newDoctor.email"></h5>
        <h5>Phone Number   : <input type="text" v-model = "newDoctor.phoneNumber"></h5>
        <h5>Gender         : <input type="text" v-model = "newDoctor.gender"></h5>

        <h5>Hours from     : 
          <select name="hoursFrom" id="hoursFrom" v-model="newDoctor.hoursFrom" required autofocus>
            <option disabled selected>Hours From</option>
            <option value="00:00:00">12:00am</option>
            <option value="01:00:00">1:00am</option>
            <option value="02:00:00">2:00am</option>
            <option value="03:00:00">3:00am</option>
            <option value="04:00:00">4:00am</option>
            <option value="05:00:00">5:00am</option>
            <option value="06:00:00">6:00am</option>
            <option value="07:00:00">7:00am</option>
            <option value="08:00:00">8:00am</option>
            <option value="09:00:00">9:00am</option>
            <option value="10:00:00">10:00am</option>
            <option value="11:00:00">11:00am</option>
            <option value="12:00:00">12:00pm</option>
            <option value="13:00:00">1:00pm</option>
            <option value="14:00:00">2:00pm</option>
            <option value="15:00:00">3:00pm</option>
            <option value="16:00:00">4:00pm</option>
            <option value="17:00:00">5:00pm</option>
            <option value="18:00:00">6:00pm</option>
            <option value="19:00:00">7:00pm</option>
            <option value="20:00:00">8:00pm</option>
            <option value="21:00:00">9:00pm</option>
            <option value="22:00:00">10:00pm</option>
            <option value="23:00:00">11:00pm</option>
          </select>
        </h5>

        <h5>Hours to       : 
          <select name="hoursTo" id="hoursTo" v-model="newDoctor.hoursTo" required autofocus>
            <option disabled selected>Hours From</option>
            <option value="00:00:00">12:00am</option>
            <option value="01:00:00">1:00am</option>
            <option value="02:00:00">2:00am</option>
            <option value="03:00:00">3:00am</option>
            <option value="04:00:00">4:00am</option>
            <option value="05:00:00">5:00am</option>
            <option value="06:00:00">6:00am</option>
            <option value="07:00:00">7:00am</option>
            <option value="08:00:00">8:00am</option>
            <option value="09:00:00">9:00am</option>
            <option value="10:00:00">10:00am</option>
            <option value="11:00:00">11:00am</option>
            <option value="12:00:00">12:00pm</option>
            <option value="13:00:00">1:00pm</option>
            <option value="14:00:00">2:00pm</option>
            <option value="15:00:00">3:00pm</option>
            <option value="16:00:00">4:00pm</option>
            <option value="17:00:00">5:00pm</option>
            <option value="18:00:00">6:00pm</option>
            <option value="19:00:00">7:00pm</option>
            <option value="20:00:00">8:00pm</option>
            <option value="21:00:00">9:00pm</option>
            <option value="22:00:00">10:00pm</option>
            <option value="23:00:00">11:00pm</option>
          </select>
        </h5>
 
        <h5>Open Sunday    : 
          <select v-model="newDoctor.openSunday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>
        
        <h5>Open Monday    : 
          <select v-model="newDoctor.openMonday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>

        <h5>Open Tuesday   : 
          <select v-model="newDoctor.openTuesday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>

        <h5>Open Wednesday : 
          <select  v-model="newDoctor.openWednesday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>

        <h5>Open Thursday  : 
          <select  v-model="newDoctor.openThursday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>

        <h5>Open Friday    : 
          <select  v-model="newDoctor.openFriday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select>
        </h5>

        <h5>Open Saturday  : 
          <select  v-model="newDoctor.openSaturday">
            <option disabled selected>Please select one</option>
            <option value="True">True</option>
            <option value="False">False</option>
          </select></h5>


        <h5>Office name    : <input type="text" v-model="newOffice.officeName"></h5>
        <h5>Office address : <input type="text" v-model="newOffice.officeAddress"></h5>
        <h5>Office phone   : <input type="text" v-model="newOffice.phoneNumber"></h5>

        
        <input id ="enter" type="submit" @click.prevent = "updateProfile" value ="Update Profile" />

    </div>
    
    <div id = "rightColumn">


    </div>


  </section>
</template>

<script>

import DoctorService from '../services/DoctorService';

export default {
  data() {
    return {

      doctor : this.$store.state.user,

      newDoctor : {},

      doctorOffice: {},

      newOffice: {}
    };
  },
  methods:{
    updateProfile(){

      if( Object.keys(this.newDoctor).length === 0 && Object.keys(this.newOffice).length === 0){
        alert("No values were updated");
        return;
      }
      
      if(Object.keys(this.newDoctor).length != 0){

        if(this.newDoctor.hasOwnProperty('firstName')){
          if(!this.newDoctor.firstName){
            this.newDoctor.firstName = this.doctor.firstName;
          }
        }else{
          this.newDoctor.firstName = this.doctor.firstName;
        }

        if(this.newDoctor.hasOwnProperty('lastName')){
          if(!this.newDoctor.lastName){
            this.newDoctor.lastName = this.doctor.lastName;
          }
        }else{
          this.newDoctor.lastName = this.doctor.lastName;
        }

        if(this.newDoctor.hasOwnProperty('email')){
          if(!this.newDoctor.email){
            this.newDoctor.email = this.doctor.email;
          }
        }else{
          this.newDoctor.email = this.doctor.email;
        }
        
        if(this.newDoctor.hasOwnProperty('phoneNumber')){
          if(!this.newDoctor.phoneNumber){
            this.newDoctor.phoneNumber = this.doctor.phoneNumber;
          }
        }else{
          this.newDoctor.phoneNumber = this.doctor.phoneNumber;
        }

        if(this.newDoctor.hasOwnProperty('gender')){
          if(!this.newDoctor.gender){
            this.newDoctor.gender = this.doctor.gender;
          }
        }else{
          this.newDoctor.gender = this.doctor.gender;
        }

        if(this.newDoctor.hasOwnProperty('hoursFrom')){
          if(!this.newDoctor.hoursFrom){
            this.newDoctor.hoursFrom = this.doctor.hoursFrom;
          }
        }else{
          this.newDoctor.hoursFrom = this.doctor.hoursFrom;
        }
        
        if(this.newDoctor.hasOwnProperty('hoursTo')){
          if(!this.newDoctor.hoursTo){
            this.newDoctor.hoursTo = this.doctor.hoursTo;
          }
        }else{
          this.newDoctor.hoursTo = this.doctor.hoursTo;
        }

        if(this.newDoctor.hoursFrom > this.newDoctor.hoursTo){
          alert("hours from cannot be higher than hours to");
          return;
        }
        
        if(this.newDoctor.hasOwnProperty('openMonday')){
          if(!this.newDoctor.openMonday){
            this.newDoctor.openMonday = this.doctor.openMonday;
          }
        }else{
          this.newDoctor.openMonday = this.doctor.openMonday;
        }

        if(this.newDoctor.hasOwnProperty('openTuesday')){
          if(!this.newDoctor.openTuesday){
            this.newDoctor.openTuesday = this.doctor.openTuesday;
          }
        }else{
          this.newDoctor.openTuesday = this.doctor.openTuesday;
        }
        if(this.newDoctor.hasOwnProperty('openWednesday')){
          if(!this.newDoctor.openWednesday){
            this.newDoctor.openWednesday = this.doctor.openWednesday;
          }
        }else{
          this.newDoctor.openWednesday = this.doctor.openWednesday;
        }

        if(this.newDoctor.hasOwnProperty('openThursday')){
          if(!this.newDoctor.openThursday){
            this.newDoctor.openThursday = this.doctor.openThursday;
          }
        }else{
          this.newDoctor.openThursday = this.doctor.openThursday;
        }

        if(this.newDoctor.hasOwnProperty('openFriday')){
          if(!this.newDoctor.openFriday){
            this.newDoctor.openFriday = this.doctor.openFriday;
          }
        }else{
          this.newDoctor.openFriday = this.doctor.openFriday;
        }

        if(this.newDoctor.hasOwnProperty('openSaturday')){
          if(!this.newDoctor.openSaturday){
            this.newDoctor.openSaturday = this.doctor.openSaturday;
          }
        }else{
          this.newDoctor.openSaturday = this.doctor.openSaturday;
        }
        
        if(this.newDoctor.hasOwnProperty('openSunday')){
          if(!this.newDoctor.openSunday){
            this.newDoctor.openSunday = this.doctor.openSunday;
          }
        }else{
          this.newDoctor.openSunday = this.doctor.openSunday;
        }

        DoctorService.updateDoctor(this.newDoctor).then(
          (response)=>{
            if(response.status == 200){
              this.$store.commit('SET_USER', response.data.user);
              this.newDoctor = {};
            }
          }
        ).catch(
          (error)=>{
            console.log("Unable to update user");
          }

        );
      }

      if(Object.keys(this.newOffice).length != 0){

        if(this.newOffice.hasOwnProperty('officeName')){
          if(!this.newOffice.officeName){
            this.newOffice.officeName = this.doctorOffice.officeName;
          }
        }else{
          this.newOffice.officeName = this.doctorOffice.officeName;
        }

        if(this.newOffice.hasOwnProperty('officeAddress')){
          if(!this.newOffice.officeAddress){
            this.newOffice.officeAddress = this.doctorOffice.officeAddress;
          }
        }else{
          this.newOffice.officeAddress = this.doctorOffice.officeAddress;
        }

        if(this.newOffice.hasOwnProperty('phoneNumber')){
          if(!this.newOffice.phoneNumber){
            this.newOffice.phoneNumber = this.doctorOffice.phoneNumber;
          }
        }else{
          this.newOffice.phoneNumber = this.doctorOffice.phoneNumber;
        }

        DoctorService.updateOffice(this.newOffice).then(
          (response)=>{
            if(response.status == 200){
              this.doctorOffice = response.data;
              this.newOffice = {};
            }
          }
        ).catch(
          (error)=>{
            console.log("Unable to update office");
          }
        );
      }
        
      
    }
  },

  created() {
    DoctorService.getOfficeByDoctor().then(
      (response) => {
        if (response.status == 200) {
          this.doctorOffice = response.data;
        }
      }
    ).catch(
      (error) => {
        console.log("Unable to get doctor office");
      }
    );
  },
}
</script>

<style scoped>
  #page{
    display: flex;
  }
  #leftColumn{
    width: 40%;
    margin-left: 5%;
    margin: 2%;

  }
  #leftColumn h5{
    margin: 4%;
  }
  #middleColumn{
    width: 55%;
    margin: 2%;
  }
  
  #rightColumn{
    width: 5%;
    margin: 2%;
  }
  h5{
    margin: 2%;
  }
  


</style>