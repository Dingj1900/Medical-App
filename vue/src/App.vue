<template>
  <div id="capstone-app">
      <navbar />

    <router-view />

    <div id="footer">
    <Footer />
  </div>
</div>

</template>


<script>
import Navbar from './components/Navbar.vue';
import Footer from './components/Footer.vue';

export default {
  components: {
    Navbar,
    Footer
  }
}
</script>



<style>

#capstone-app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

#footer {
  margin-top: auto;
}
</style>
