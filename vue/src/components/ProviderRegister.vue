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
          <input type="text" id="lastName" v-model="doctor.lastName" required autofocus />
         </div>
          <div class="form-input-group">
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
          <!--<input type="radio" id="homePhone" name="homePhone" value="homePhone" required />
          <label for="homePhone">Home</label>
          <input type="radio" id="cellPhone" name="cellPhone" value="cellPhone" required />
          <label for="cellPhone">Cell Phone</label>-->
        </div>
        <div class="form-input-group">
          <label for="emailAddress">Email Address</label>
          <input type="text" id="emailAddress" v-model="doctor.emailAddress" required autofocus />
        </div>
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
    width: 27px;
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

  </style>
  