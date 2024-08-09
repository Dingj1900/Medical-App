<template>
    <div>
        <div :style="cssProps"></div>
        <h3 class="officeName"></h3>
        <h3 class="address"></h3>
        <h3 class="phoneNumber"></h3>
        <h3 class="monday"></h3>
        <h3 class="tuesday"></h3>
        <h3 class="wednesday"></h3>
        <h3 class="thursday"></h3>
        <h3 class="friday"></h3>
        <h3 class="saturday"></h3>
        <h3 class="sunday"></h3>
        <h3 class="doctors"></h3>
        <h3 class="costPerHour"></h3>
    </div>
</template>

<script>
 export default {
    data() {
      return {
        cssProps: {
          backgroundImage: `url(${require('@/assets/officebase1img.jpg')})`
        }
      }
    }
  }
</script>

<style scoped>
</style>