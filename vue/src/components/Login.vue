<template>
  <div id="app" >
   <div class="container">
    <div class="backbox">
      <div class="loginMsg" >
        <!--:class="{ visibility: isSignup } -->
        <div class="textcontent" :class="{ visibility: isSignup }" >
          <p class="title">Don't have an account?</p>
          <p>Sign up to register an account.</p>
          <button id="switch1">SIGN UP</button>
        </div>
      </div>
      <div class="signupMsg" :class="{ visibility: !isSignup }" >
        <div class="textcontent">
          <p class="title">Have an account?</p>
          <p>Log in to view your account.</p>
          <button id="switch2">LOG IN</button>
        </div>
      </div>
    </div>

    <div class="frontbox" :class="{ moving: isMoving }">
      <!-- Login Form -->
      <div class="login" v-if="!isSignup">
        <h2>LOG IN</h2>
        <form v-on:submit.prevent="login">
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div role="alert" v-if="$route.query.registration">
            Thank you for registering, please sign in.
          </div>
          <div class="inputbox">
            <input type="text" id="username" placeholder="USERNAME" v-model="user.username" required autofocus />
            <input type="password" name="password" placeholder="PASSWORD" v-model="user.password" required />
          </div>
          <button type="submit">LOG IN</button>
        </form>
      </div>

      <!-- Signup Form -->
      <div class="signup" v-if="isSignup">
        <h2>SIGN UP</h2>
        <p>Sign up to access affordable healthcare in your area today!</p>
        <div>
          <p>Registering as a Patient or Medical Provider?</p>
          <label for="yes">
          <input type="checkbox" id="yes" @click="toggleYes" :checked="isYes"/>
          Patient</label>
          <label for="no">
          <input type="checkbox" id="no" @click="toggleNo" :checked="isNo" />
          Provider</label>
        </div>
        <div role="alert" v-if="formErrors">
      {{ formErrorMsg }}
       </div>
          <button @click="handleSubmit">SIGN UP</button>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import $ from 'jquery';
import authService from "../services/AuthService";
import PatientService from "../services/PatientService.js";

export default {
  props: {
  
  },
  data() {
    return {
      isSignup: true, 
      formErrors: false,
      formErrorMsg: 'You need to select an option before signing up.',
      isYes: false,
      isNo: false,
      isMoving: false,
      loginForm: {
        username: "",
        password: ""
      },
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    toggleYes() {
        if (this.isYes === true) {
        this.isYes = false;
        this.isNo = false;
      } else  {
        this.formErrors = false;
        this.isYes = true;
        this.isNo = false;
      }
    },
    toggleNo() {
        if (this.isNo === true) {
        this.isYes = false;
        this.isNo = false;
      } else  {
        this.formErrors = false;
        this.isYes = false;
        this.isNo = true;
      }
    },
    
    login() {
      authService.login(this.user)
        .then(response => {
          if (response.status === 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
           if (this.$store.state.user.authorities[0].name === 'ROLE_PROVIDER') {
            this.$router.push("/provider");
           }
           else {
            this.$router.push("/patient");
           }
          }
        })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    handleSubmit() {

        if(this.isYes){
            this.$router.push("/register");
        }
        if(this.isNo){
            this.$router.push("/register/provider");
        }

        this.formErrors = true;
    }
  },
  mounted() {
    this.$nextTick(() => {
      $('#switch1').on('click', () => {
        this.isSignup = true;
        this.isMoving = true; 
      });

      $('#switch2').on('click', () => {
        this.isSignup = false;
        this.isMoving = false; 
      });

      //for moving the boxes at the start

      setTimeout(() => {
        $('#switch1').click();
      }, 1000);

      setTimeout(() => {
        $('#switch2').click();
      }, 3000);
    });
  }
};
</script>

<style scoped>
body {
  background-color: #8ab0c3;
  font-family: 'Roboto', sans-serif;
}

.container {
  width: 600px;
  height: 350px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: inline-flex; 
  overflow: hidden; 
}

.backbox {  
  background-color: #777575;
  width: 100%;
  height: 80%;
  position: absolute;
  transform: translate(0, -50%);
  top: 50%;
  display: inline-flex;
  z-index: 1; 
}

.frontbox {
  background-color: white;
  border-radius: 20px;
  height: 100%;
  width: 50%;
  position: absolute;
  right: 0;
  margin-right: 3%;
  margin-left: 3%;
  transition: right .8s ease-in-out;
  z-index: 2; 
}

.moving {
  right: 45%;
}

.loginMsg, .signupMsg {
  width: 50%;
  height: 100%;
  font-size: 15px;
  box-sizing: border-box;
}

.loginMsg .title, .signupMsg .title {
  font-weight: 300;
  font-size: 23px;
}

.loginMsg p, .signupMsg p {
  font-weight: 100;
}

.textcontent {
  color: white;
  margin-top: 65px;
  margin-left: 12%;
}

.loginMsg button, .signupMsg button {
  background-color: #777575;
  border: 2px solid white;
  border-radius: 10px;
  color: white;
  font-size: 12px;
  box-sizing: content-box;
  font-weight: 300;
  padding: 10px;
  margin-top: 20px;
}

.login, .signup {
  padding: 20px;
  text-align: center;
}

.login h2, .signup h2 {
  color: #070847;
  font-size: 22px;
}

.inputbox {
  margin-top: 30px; 
}

.login input {
  display: block;
  width: 100%;
  height: 40px;
  background-color: #f2f2f2;
  border: none;
  margin-bottom: 20px;
  font-size: 12px;
}

.login button,
.signup button{
  background-color: #070847;
  border: none;
  color:white;
  font-size: 12px;
  font-weight: 300;
  box-sizing: content-box;
  padding:10px;
  border-radius: 10px;
  width: 60px;
  position: absolute;
  right:30px;
  bottom: 30px;
  cursor: pointer;
}


.login p {
  cursor: pointer;
  color: #404040;
  font-size: 15px;
}

.loginMsg, .signupMsg {
  transition: opacity .8s ease-in-out;
}

.visibility {
  opacity: 0;
}

.hide {
  display: none;
}

.checkbox {
  padding: 10px;
  border-radius: 10px;
}

</style>