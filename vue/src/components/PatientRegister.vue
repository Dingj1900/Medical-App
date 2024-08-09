<template>
    <div id="register" class="text-center">
        <div class="container">
      <h1>Patient Register Form</h1>
      <form v-on:submit.prevent="register">
       
        <div role="alert" v-if="registrationErrors" >
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
          <label for="middleInitial">Middle Initial</label>
          <input type="text" id="middleInitial" v-model="user.middleInitial" />
          </div>
          <div class="form-input-group">
          <label for="dateOfBirth">Date of Birth</label>
          <input type="date" id="dateOfBirth" v-model="user.dateOfBirth" required autofocus />
          </div>
          <div class="form-input-group">
          <label for="gender">Gender</label>
            <b-dropdown id="dropdown-1" text="Dropdown Button" v-model="user.gender" required autofocus /> 
            <select name="gender" id="gender" >
            <option disabled selected>Please select one</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
            </select>
          </div>
          <div class="form-input-group">
          <label for="address">Address</label>
          <input type="text" id="address" v-model="user.address" required autofocus />
          </div>
          <div class="form-input-group">
          <label for="city">City</label>
          <input type="text" id="city" v-model="user.city" required autofocus />
          </div>
          <div class="form-input-group">
          <label for="state">State</label>
          <b-dropdown id="state" v-model="user.state" required autofocus />
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
   </div>
   <div class="form-input-group">
    <label for="zipcode">Zipcode</label>
          <input type="text" id="zipcode" v-model="user.zipcode" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="text" id="phoneNumber" v-model="user.phoneNumber" required autofocus />
         <!--<div class="form-input-group">
          <input type="radio" id="homePhone" name="homePhone" value="homePhone" required />
          <label for="homePhone">Home</label>
          </div>
          <div class="form-input-group">
          <input type="radio" id="cellPhone" name="cellPhone" value="cellPhone" required />
          <label for="cellPhone">Cell Phone</label>
          </div>-->
          </div>
        <div class="form-input-group">
          <label for="emailAddress">Email Address</label>
          <input type="text" id="emailAddress" v-model="user.emailAddress" required autofocus />
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
          role: 'patient',
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
        },
        // newPatient : {
        //         firstName: this.firstName,
        //         lastName: this.lastName,
        //         middleInitials: this.middleInitials,
        //         gender: this.gender,
        //         phoneNumber: this.phoneNumber,
        //         email: this.email,
        //         dateOfBirth: this.dateOfBirth,
        //         address: this.address,
        //         city: this.city,
        //         stateAbbreviation: this.stateAbbreviation,
        //         zipcode: this.zipcode
        // },
  
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
      };
    },
    methods: {
        handleSubmit() {
            
            this.register();
          
        },
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
    transition: all 0.3s linear;
    cursor: pointer;
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
