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
          <input type="text" id="middleInitial" v-model="user.middleInitials" />
          </div>
          <div class="form-input-group">
          <label for="dateOfBirth">Date of Birth</label>
          <input type="date" id="dateOfBirth" v-model="user.dateOfBirth" required autofocus />
          </div>
          <div class="form-input-group">
          <label for="gender">Gender</label>
            <b-dropdown id="dropdown-1" text="Dropdown Button"  required autofocus /> 
            <select name="gender" id="gender" v-model="user.gender">
            <option disabled selected>Please select one</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
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
          <b-dropdown id="state" required autofocus />
          <select name="state" id="state" v-model="user.stateAbbreviation" >
          <option disabled selected>Please select one</option>
            <option value="AL">AL</option>
            <option value="AK">AK</option>
            <option value="AZ">AZ</option>
            <option value="AR">AR</option>
            <option value="CA">CA</option>
            <option value="CO">CO</option>
            <option value="CT">CT</option>
            <option value="DE">DE</option>
            <option value="FL">FL</option>
            <option value="GA">GA</option>
            <option value="HI">HI</option>
            <option value="ID">ID</option>
            <option value="IL">IL</option>
            <option value="IN">IN</option>
            <option value="IA">IA</option>
            <option value="KS">KS</option>
            <option value="KY">KY</option>
            <option value="LA">LA</option>
            <option value="ME">ME</option>
            <option value="MD">MD</option>
            <option value="MA">MA</option>
            <option value="MI">MI</option>
            <option value="MN">MN</option>
            <option value="MS">MS</option>
            <option value="MO">MO</option>
            <option value="MT">MT</option>
            <option value="NE">NE</option>
            <option value="NV">NV</option>
            <option value="NH">NH</option>
            <option value="NJ">NJ</option>
            <option value="NM">NM</option>
            <option value="NY">NY</option>
            <option value="NC">NC</option>
            <option value="ND">ND</option>
            <option value="OH">OH</option>
            <option value="OK">OK</option>
            <option value="OR">OR</option>
            <option value="PA">PA</option>
            <option value="RI">RI</option>
            <option value="SC">SC</option>
            <option value="SD">SD</option>
            <option value="TN">TN</option>
            <option value="TX">TX</option>
            <option value="UT">UT</option>
            <option value="VT">VT</option>
            <option value="VA">VA</option>
            <option value="WA">WA</option>
            <option value="WV">WV</option>
            <option value="WI">WI</option>
            <option value="WY">WY</option>
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
        <div class="submitBttn">
        <button id="createAccount" type="submit" @click.prevent="register">Create Account</button>
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
          middleInitials: '',
          stateAbbreviation: "",
          dateOfBirth: '',
          gender: '',
          address: '',
          city: '',
          zipcode: '',
          phoneNumber: '',
          email: '',
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
