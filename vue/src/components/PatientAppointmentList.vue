<template>
    <div class="appointment" v-for="appointment in appointments" v-bind:key="appointment.id">
      <router-link v-bind:to="{ name: 'TopicDetailsView', params: { topicId: topic.id } }">
        {{ topic.title }}  
      </router-link>
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
  