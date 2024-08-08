<template>
    <div>
        <div :style="cssProps"></div>
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