<template>
  <div id="capstone-app">
    <div id="nav">
      <navbar />
    </div>
    <router-view />
    <!-- <footer /> -->
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
import Footer from './components/Footer.vue'

export default {
  components: {
    Navbar,
    Footer
  }
}
</script>