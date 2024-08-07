<template>
  <div id="capstone-app">
    <div id="nav">
      <navbar />
    </div>
    <div id="body">
    <router-view />
  </div>
    <div id="footer">
    <Footer />
    </div>
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

<style scoped>



</style>
