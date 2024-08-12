<template>
    <div class="appointment" v-for="appointment in appointments" v-bind:key="appointment.id">
    </div>
  </template>
  
  <script>
  export default {
    props: {
      appointments: {
        type: Array,
        required: true
      }
    },
  };
  </script>
  