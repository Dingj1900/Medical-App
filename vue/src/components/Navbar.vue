    <template>

        

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">HealMeNow!</a>

  <!-- Links -->


  <ul class="navbar-nav">
    <li class="nav-item">
        <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home</router-link>
        </li>
    <li class="nav-item">
        <router-link v-bind:to="{ name: 'login' }" class="nav-link" v-if="$store.state.token == ''">Sign-up / Login</router-link>
    </li>
    <li class="nav-item">
        <router-link v-bind:to="{ name: 'logout' }" class="nav-link" v-if="$store.state.token != ''">Logout</router-link>
    </li>


    <!-- Dropdown -->
    <!-- <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li> -->
  </ul>
</nav>



    </template>
    


    <script>
    export default {
    
    }
    </script>
    


    <style scoped>
.navbar {
  padding-top: 0.625rem;
  padding-bottom: 0.625rem;
  min-height: 53px;
  margin-bottom: 20px;
  padding-left: 40px;
  box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.15);
}

.navbar a {
  vertical-align: middle;
}

.navbar a:not(.btn):not(.dropdown-item) {
  color: #FFFFFF;
}

.navbar p {
  display: inline-block;
  margin: 0;
  line-height: 21px;
  font-weight: inherit;
  font-size: 50px;
}

.navbar .navbar-nav .nav-link.btn {
  padding: 11px 22px;
}

.navbar .navbar-nav .nav-link.btn.btn-lg {
  padding: 15px 48px;
}

.navbar .navbar-nav .nav-link:not(.btn) {
  text-transform: uppercase;
  font-size: 0.7142em;
  padding: 0.5rem 0.7rem;
  line-height: 1.625rem;
}

.navbar .navbar-nav .nav-link:not(.btn) i.fab+p,
.navbar .navbar-nav .nav-link:not(.btn) i.now-ui-icons+p {
  margin-left: 3px;
}

.navbar .navbar-nav .nav-link:not(.btn) i.fab,
.navbar .navbar-nav .nav-link:not(.btn) i.now-ui-icons {
  font-size: 30px;
  position: relative;
  top: 3px;
  text-align: center;
  width: 21px;
}

.navbar .navbar-nav .nav-link:not(.btn) i.now-ui-icons {
  top: 4px;
  font-size: 30px;
}

.navbar .navbar-nav .nav-item .nav-link:not(.btn):focus,
.navbar .navbar-nav .nav-item .nav-link:not(.btn):hover,
.navbar .navbar-nav .nav-item .nav-link:not(.btn):active {
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 0.1875rem;
}

.navbar .navbar-brand {
  text-transform: uppercase;
  font-size: 2em;
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  line-height: 1.625rem;
}

.navbar .navbar-toggler {
  width: 37px;
  height: 27px;
  outline: 0;
  cursor: pointer;
}

.navbar .navbar-toggler .navbar-toggler-bar.middle-bar {
  width: 17px;
  transition: width .2s linear;
}

.navbar .navbar-toggler:hover .navbar-toggler-bar.middle-bar {
  width: 22px;
}

.navbar .button-dropdown .navbar-toggler-bar:nth-child(2) {
  width: 17px;
}

.navbar.navbar-transparent {
  background-color: transparent !important;
  box-shadow: none;
  color: #FFFFFF;
  padding-top: 20px !important;
}

@media screen and (max-width: 576px) {
  .navbar[class*='navbar-expand-'] .container {
    margin-left: 0;
    margin-right: 0;
  }

  .footer .copyright {
    text-align: center;
  }
}

@media (max-width: 768px) {
  .btn {
    margin-bottom: 10px;
  }
}

#navbar .navbar {
  margin-bottom: 20px;
}

#navbar .navbar-toggler {
  pointer-events: none;
}

@font-face {
  font-family: 'Nucleo Outline';
  src: url("https://github.com/creativetimofficial/now-ui-kit/blob/master/assets/fonts/nucleo-outline.eot");
  src: url("https://github.com/creativetimofficial/now-ui-kit/blob/master/assets/fonts/nucleo-outline.eot") format("embedded-opentype");
  src: url("https://raw.githack.com/creativetimofficial/now-ui-kit/master/assets/fonts/nucleo-outline.woff2");
  font-weight: normal;
  font-style: normal;

}

.now-ui-icons {
  display: inline-block;
  font: normal normal normal 14px/1 'Nucleo Outline';
  font-size: inherit;
  text-transform: none;
}


    </style>