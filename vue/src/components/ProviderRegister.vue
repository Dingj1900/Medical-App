<template>
    <div id="register" class="text-center">
      <form v-on:submit.prevent="register">
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="form-input-group">
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="doctor.lastName" required autofocus />
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="doctor.firstName" required autofocus />
        </div>
        <div class="form-input-group">
    <label for="gender">Gender</label>
          <b-dropdown id="dropdown-1" text="Dropdown Button" v-model="doctor.gender" required autofocus /> 
          <select name="gender" id="gender" >
    <option disabled selected>Please select one</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>
          </select>
        </div>
        <div class="form-input-group">
          <label for="officeName">Office Location</label>
          <b-dropdown id="officeName" v-model="doctor.officeName" required autofocus />
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
        </div>
        <div class="form-input-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="text" id="phoneNumber" v-model="doctor.phoneNumber" required autofocus />
          <input type="radio" id="homePhone" name="homePhone" value="homePhone" required />
          <label for="homePhone">Home</label>
          <input type="radio" id="cellPhone" name="cellPhone" value="cellPhone" required />
          <label for="cellPhone">Cell Phone</label>
        </div>
        <div class="form-input-group">
          <label for="emailAddress">Email Address</label>
          <input type="text" id="emailAddress" v-model="doctor.emailAddress" required autofocus /></div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="doctor.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="doctor.password" required />
        </div>
        <div class="form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" v-model="doctor.confirmPassword" required />
        </div>
        <button id="createAccount" type="submit">Create Account</button>
        <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
      </form>
    </div>
  </template>
  
  <script>
  import authService from '../services/AuthService';
  
  export default {
    props: {
    
    },
    data() {
      return {
        user: {
          username: '',
          password: '',
          confirmPassword: '',
          role: 'doctor',
        },
        doctor:{
            lastName: '',
            firstName: '',
            gender: '',
            officeName: '',
            phoneNumber: '',
            emailAddress: '',
            username: '',
            password: '',
        },
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
      };
    },
    methods: {
      register() {
        if (this.user.password != this.user.confirmPassword) {
          this.registrationErrors = true;
          this.registrationErrorMsg = 'Password & Confirm Password do not match.';
        } else {
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
              const response = error.response;
              this.registrationErrors = true;
              if (response.status === 400) {
                this.registrationErrorMsg = 'Bad Request: Validation Errors';
              }
            });
        }
      },
      clearErrors() {
        this.registrationErrors = false;
        this.registrationErrorMsg = 'There were problems registering this user.';
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
  </style>
  