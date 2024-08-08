<template>
    <div>
        <div :style="cssProps"></div>
        <div class="office info container">
        <h2>Office Name:</h2>
        <h3 class="officeName">{{ office.officeName }}</h3>
        <h2>Address:</h2>
        <h3 class="address">{{ office.address }}</h3>
        <h2>Phone Number:</h2>
        <h3 class="phoneNumber">{{ office.phoneNumber }}</h3>
        <h2>Office Hours:</h2>
        <h3 class="monday">{{ office.isMonday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="tuesday">{{ office.isTuesday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="wednesday">{{ office.isWednesday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="thursday">{{ office.isThursday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="friday">{{ office.isFriday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="saturday">{{ office.isSaturday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h3 class="sunday">{{ office.isSunday }}{{ office.hoursFrom }}{{ office.hoursTo }}</h3>
        <h2>Doctors:</h2>
        <h3 class="doctors">Dr. {{ user.last_name }}</h3>
        <h2>Service Cost:</h2>
        <h3 class="costPerHour">{{ services.hourlyRate }}</h3>
        </div>
    </div>
</template>

<script>
 export default {
    return: {
        cssProps: {
          backgroundImage: `url(${require('@/assets/officebase1img.jpg')})`
        }
      },
    }
</script>

<style scoped>
</style>