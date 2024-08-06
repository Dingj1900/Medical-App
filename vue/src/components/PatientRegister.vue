<template>
    <div id="register" class="text-center">
      <form v-on:submit.prevent="register">
        <h1>Create Account</h1>
        <div role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="form-input-group">
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="patient.lastName" required autofocus />
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="patient.firstName" required autofocus />
          <label for="middleInitial">Middle Initial</label>
          <input type="text" id="middleInitial" v-model="patient.middleInitial" />
        </div>
        <div class="form-input-group">
          <label for="dateOfBirth">Date of Birth</label>
          <input type="date" id="dateOfBirth" v-model="patient.dateOfBirth" required autofocus />
          <label for="gender">Gender</label>
            <b-dropdown id="dropdown-1" text="Dropdown Button" v-model="patient.gender" required autofocus /> 
            <select name="gender" id="gender" >
      <option disabled selected>Please select one</option>
      <option value="male">Male</option>
      <option value="female">Female</option>
      <option value="other">Other</option>
            </select>
        </div>
        <div class="form-input-group">
          <label for="address">Address</label>
          <input type="text" id="address" v-model="patient.address" required autofocus />
          <label for="city">City</label>
          <input type="text" id="city" v-model="patient.city" required autofocus />
          <label for="state">State</label>
          <b-dropdown id="state" v-model="patient.state" required autofocus />
          <select name="state" id="state" >
          <option disabled selected>Please select one</option>
    <option value="al">AL</option>
    <option value="ak">AK</option>
    <option value="az">AZ</option>
    <option value="ar">AR</option>
    <option value="ca">CA</option>
    <option value="co">CO</option>
    <option value="ct">CT</option>
    <option value="de">DE</option>
    <option value="fl">FL</option>
    <option value="ga">GA</option>
    <option value="hi">HI</option>
    <option value="id">ID</option>
    <option value="il">IL</option>
    <option value="in">IN</option>
    <option value="ia">IA</option>
    <option value="ks">KS</option>
    <option value="ky">KY</option>
    <option value="la">LA</option>
    <option value="me">ME</option>
    <option value="md">MD</option>
    <option value="ma">MA</option>
    <option value="mi">MI</option>
    <option value="mn">MN</option>
    <option value="ms">MS</option>
    <option value="mo">MO</option>
    <option value="mt">MT</option>
    <option value="ne">NE</option>
    <option value="nv">NV</option>
    <option value="nh">NH</option>
    <option value="nj">NJ</option>
    <option value="nm">NM</option>
    <option value="ny">NY</option>
    <option value="nc">NC</option>
    <option value="nd">ND</option>
    <option value="oh">OH</option>
    <option value="ok">OK</option>
    <option value="or">OR</option>
    <option value="pa">PA</option>
    <option value="ri">RI</option>
    <option value="sc">SC</option>
    <option value="sd">SD</option>
    <option value="tn">TN</option>
    <option value="tx">TX</option>
    <option value="ut">UT</option>
    <option value="vt">VT</option>
    <option value="va">VA</option>
    <option value="wa">WA</option>
    <option value="wv">WV</option>
    <option value="wi">WI</option>
    <option value="wy">WY</option>
   </select>
    <label for="zipcode">Zipcode</label>
          <input type="text" id="zipcode" v-model="patient.zipcode" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="text" id="phoneNumber" v-model="patient.phoneNumber" required autofocus />
          <input type="radio" id="homePhone" name="homePhone" value="homePhone" required />
          <label for="homePhone">Home</label>
          <input type="radio" id="cellPhone" name="cellPhone" value="cellPhone" required />
          <label for="cellPhone">Cell Phone</label>
        </div>
        <div class="form-input-group">
          <label for="emailAddress">Email Address</label>
          <input type="text" id="emailAddress" v-model="patient.emailAddress" required autofocus />
          <label for="username">Username</label>
          <input type="text" id="username" v-model="patient.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="patient.password" required />
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" v-model="patient.confirmPassword" required />
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
          role: 'patient',
        },
        patient:{
            lastName: '',
            firstName: '',
            middleInitial: '',
            dateOfBirth: '',
            gender: '',
            address: '',
            city: '',
            state: '',
            zipcode: '',
            phoneNumber: '',
            emailAddress: '',
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

  #register {
      background: #8ab0c3;
      background: radial-gradient(circle, #8ab0c3 50%, rgba(92,133,120,1) 100%);
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