<template>
    <div id="register" class="text-center">
        <div class="container">
            <h1>Provider Register Form</h1>
      <form v-on:submit.prevent="register">
        
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="fields">
        <div class="form-input-group">
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="user.lastName" required autofocus />
         </div>
          <div class="form-input-group">
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="user.firstName" required autofocus />
        </div>
        <div class="form-input-group">
    <label for="gender">Gender</label>
          <b-dropdown id="dropdown-1" text="Dropdown Button" required autofocus /> 
          <select name="gender" id="gender" v-model="user.gender">
            <option disabled selected>Please select one</option>
            <option value="Male" >Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
          </select>
        </div>
       <!-- <div class="form-input-group">
          <label for="officeName">Office Location</label>
          <b-dropdown id="officeName" v-model="user.officeName" required autofocus />
          <select name="officeName" id="officeName" >
          <option disabled selected>Please select one</option>
    <option value="office1">Office Name</option>
    <option value="office2">Office Name</option>
    <option value="office3">Office Name</option>
    <option value="office4">Office Name</option>
    <option value="office5">Office Name</option>
    <option value="office6">Office Name</option>
    <option value="office7">Office Name</option>
    <option value="office8">Office Name</option>
   </select>
        </div>-->
        <div class="form-input-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="text" id="phoneNumber" v-model="user.phoneNumber" required autofocus />
          <!--<input type="radio" id="homePhone" name="homePhone" value="homePhone" required />
          <label for="homePhone">Home</label>
          <input type="radio" id="cellPhone" name="cellPhone" value="cellPhone" required />
          <label for="cellPhone">Cell Phone</label>-->
        </div>
        <div class="form-input-group">
          <label for="emailAddress">Email Address</label>
          <input type="text" id="emailAddress" v-model="user.email" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <div class="form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
        </div>
      </div>
      <div class="availability">
        <h1>Select Availability</h1>
        <p>Please select the days of the week and hours of availability.</p>
        <div>
          <label for="sunday">
          <input type="checkbox" v-bind:checked= "user.openSunday" @click="toggleSunday"/>
          Sunday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="monday">
          <input type="checkbox" v-bind:checked="user.openMonday" @click="toggleMonday"/>
          Monday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="tuesday">
          <input type="checkbox" v-bind:checked="user.openTuesday" @click="toggleTuesday"/>
          Tuesday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="wednesday">
          <input type="checkbox"  v-bind:checked="user.openWednesday" @click="toggleWednesday" />
          Wednesday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="thursday">
          <input type="checkbox" v-bind:checked="user.openThursday" @click="toggleThursday" />
          Thursday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="friday">
          <input type="checkbox" v-bind:checked="user.openFriday" @click="toggleFriday" />
          Friday</label>
          <!--<label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
          <option disabled selected>Hours From</option>
    <option value="12am">12:00am</option>
    <option value="1am">1:00am</option>
    <option value="2am">2:00am</option>
    <option value="3am">3:00am</option>
    <option value="4am">4:00am</option>
    <option value="5am">5:00am</option>
    <option value="6am">6:00am</option>
    <option value="7am">7:00am</option>
    <option value="8am">8:00am</option>
    <option value="9am">9:00am</option>
    <option value="10am">10:00am</option>
    <option value="11am">11:00am</option>
    <option value="12pm">12:00pm</option>
    <option value="1pm">1:00pm</option>
    <option value="2pm">2:00pm</option>
    <option value="3pm">3:00pm</option>
    <option value="4pm">4:00pm</option>
    <option value="5pm">5:00pm</option>
    <option value="6pm">6:00pm</option>
    <option value="7pm">7:00pm</option>
    <option value="8pm">8:00pm</option>
    <option value="9pm">9:00pm</option>
    <option value="10pm">10:00pm</option>
    <option value="11pm">11:00pm</option>
          </select>
          </div>
          <div>-->
          <label for="saturday">
          <input type="checkbox"  v-bind:checked="user.openSaturday" @click="toggleSaturday" />
          Saturday</label>
          </div>


          <div><label for="hoursFrom">Hours From</label>
          <select name="hoursFrom" id="hoursFrom" v-model="user.hoursFrom" required autofocus>
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
          <label for="hoursTo">Hours To</label>
          <select name="hoursTo" id="hoursTo" v-model="user.hoursTo" required autofocus>
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
          </div>
          <div class="officeInformation">
        <h1>Office Information</h1>
        <p>Please register office information.</p>
        <div class="form-input-group">
          <label for="officeName">Office Name</label>
          <input type="text" id="officeName" v-model="user.officeName" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="officeAddress">Office Address</label>
          <input type="text" id="officeAddress" v-model="user.officeAddress" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="officePhone">Phone Number</label>
          <input type="text" id="officePhone" v-model="user.officePhone" required autofocus />
        </div>
        <div>
        </div>
        </div>
      </div>
      <div v-if="showValidationMessage" class="validation-message">
      Please select at least one day and both "Hours From" and "Hours To".
     </div>
      <div class="submitBttn">
        <button id="createAccount" type="submit" @click.prevent="handleSubmit">Create Account</button>
        </div>
        <div class="loginLnk">
        <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    
        </div>
      </form>
      </div>
    </div>
  </template>
  
  <script>
  import authService from '../services/AuthService';
  import DoctorService from '../services/DoctorService.js'
  
  export default {
    props: {
    
    },
    data() {
      return {
        user: {
          username: '',
          password: '',
          confirmPassword: '',
          role: 'provider',
          lastName: '',
          firstName: '',
          gender: '',
          phoneNumber: '',
          email: '',
          openSunday: false,
          openMonday: false,
          openTuesday: false,
          openWednesday: false,
          openThursday: false,
          openFriday: false,
          openSaturday: false,
          hoursTo: '',
          hoursFrom: '',
          officeAddress: '',
          officeName: '',
          officePhone: '',
        },
        showValidationMessage: false,
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
      };
    },

    methods: {
        handleSubmit() {
            
            if (this.checkDays()) {
            this.register();
            } else {
                this.showValidationMessage = true;
            }
        },
          
        
      register() {
        console.log("START_REGISTER");
        if (this.user.password != this.user.confirmPassword) {
          this.registrationErrors = true;
          this.registrationErrorMsg = 'Password & Confirm Password do not match.';
        } else if(this.hoursFrom > this.hoursTo ){
          console.log("reached");
          this.registrationErrors = true;
          this.registrationErrorMsg = 'Hours from must be lower than hours to.';
        }
        else {
          console.log("sending register");
          authService
            .register(this.user)
            .then((response) => {
              if (response.status == 201) {

                this.$router.push({
                  path: '/login',
                  query: { registration: 'success' },
                });
              }
            })
            .catch((error) => {
              console.log(error);

              const response = error.response;
              this.registrationErrors = true;
              if (response.status === 400) {
                this.registrationErrorMsg = 'Bad Request: Validation Errors';
              }
            });
        }
      },
      checkDays() {
      return (this.user.openSaturday || this.user.openSunday || this.user.openMonday ||
              this.user.openTuesday || this.user.openWednesday || this.user.openThursday || this.user.openFriday) &&
             this.user.hoursFrom && this.user.hoursTo;
      },
      clearErrors() {
        this.registrationErrors = false;
        this.registrationErrorMsg = 'There were problems registering this user.';
      },

      toggleSunday(){
        this.user.openSunday = !this.user.openSunday;
      },
      toggleMonday(){
        this.user.openMonday = !this.user.openMonday;
      },
      toggleTuesday(){
        this.user.openTuesday = !this.user.openTuesday;
      },
      toggleWednesday(){
        this.user.openWednesday = !this.user.openWednesday;
      },
      toggleThursday(){
        this.user.openThursday = !this.user.openThursday;
      },
      toggleFriday(){
        this.user.openFriday = !this.user.openFriday;
      },
      toggleSaturday(){
        this.user.openSaturday = !this.user.openSaturday;
      },
    },
  };
  </script>
  
  <style scoped>
  .form-input-group {
    margin-bottom: 1rem;
  }
  label {
    margin-right: 0.5rem;
  }

  #register {
      background: #3ba0d2;
      background: radial-gradient(circle, #7db2cc 50%, rgb(92, 124, 133) 100%);
  }

  *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  }

  body{
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #4070f4;
  }

  .container{
    position: relative;
    max-width: 900px;
    width: 100%;
    border-radius: 6px;
    padding: 30px;
    margin: 0 15px;
    background-color: #fff;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
  }

  #createAccount {
    width:250px;
    margin: 0px auto;
    display: block;
    box-sizing: border-box;
    font-size: 18px;
    padding:10px;
    border-radius: 4px;
    background-color: rgb(131, 210, 255);
    font-weight:300;
    color:#FFFFFF;
    background-color:#5171ff;
    text-align:center;
    text-transform: uppercase;
    text-decoration: none;
}

form #createAccount:hover{
    background-color: #4070f4;
}

form button i{
    margin: 0 6px;
}

.container h1{
    position: relative;
    font-size: 20px;
    font-weight: 600;
    color: #333;
}

.container h1::before{
    content: "";
    position: absolute;
    left: 0;
    bottom: -2px;
    height: 3px;
    width: 850px;
    border-radius: 8px;
    background-color: #192649;
}

.container form{
    position: relative;
    margin-top: 16px;
    min-height: 490px;
    background-color: #fff;
}

.container form .fields{
    display: flex;
    align-items: center;
    justify-content: space-between;
    flex-wrap: wrap;
}

form .fields .form-input-group{
    display: flex;
    width: calc(100% / 3 - 15px);
    flex-direction: column;
    margin: 4px 0;
}
label{
    font-size: 12px;
    font-weight: 500;
    color: #2e2e2e;
}

input{
    outline: none;
    font-size: 14px;
    font-weight: 400;
    color: #333;
    border-radius: 5px;
    border: 1px solid #aaa;
    padding: 15px;
    height: 42px;
    margin: 8px 0;
}

input:is(:focus, :valid){
    box-shadow: 0 3px 6px rgba(0,0,0,0.13);
}

input[type="date"]{
    color: #707070;
}

input[type="date"]:valid{
    color: #333;
}


select{
    outline: none;
    font-size: 14px;
    font-weight: 400;
    color: #333;
    border-radius: 5px;
    border: 1px solid #aaa;
    padding: 15px;
    height: 42px;
    margin: 8px 0;
}

select #gender, #state{
    color: #707070;
}

select #gender, #state:valid{
    color: #333;
}

select:is(:focus, :valid) {
    box-shadow: 0 3px 6px rgba(0,0,0,0.13);
}


select {
    outline: none;
    font-size: 14px;
    font-weight: 400;
    color: #333;
    border-radius: 5px;
    border: 1px solid #aaa;
    padding: 10px 15px; 
    height: auto;
    line-height: 1.5;
    margin: 8px 0;
    background-color: #fff;
    -webkit-appearance: none; 
    -moz-appearance: none; 
    appearance: none; 
    background-image: url('data:image/svg+xml;charset=utf-8,%3Csvg width="10" height="6" xmlns="http://www.w3.org/2000/svg"%3E%3Cpath d="M0 0l5 5 5-5H0z" fill="%23333" /%3E%3C/svg%3E');
    background-repeat: no-repeat;
    background-position: right 10px center;
    background-size: 10px;
}


  </style>
