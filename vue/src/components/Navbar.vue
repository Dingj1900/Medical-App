    <template>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">(Company Name)</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <router-link v-bind:to="{ name: 'home' }" class="nav-link">Home</router-link>
    </li>
    <li class="nav-item">
        <router-link v-bind:to="{ name: 'login' }" class="nav-link">Sign-up / Login</router-link>
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
    
    </style>