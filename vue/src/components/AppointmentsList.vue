<template>
  <table>
          <thead>
              <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Reason</th>
                  <th>Appointment Date</th>
                  <th>Appointment Time</th>
                  <th>Doctor Id</th>
                  <th>Appointment Id</th>
              </tr>
          </thead>

        <tbody>
            <tr v-for="appointments in appointmentsList" v-bind:key="appointments.appointmentId">
                <td>{{ appointments.first }}</td>
                <td>{{ appointments.last }}</td>
                <td>{{ appointments.reason }}</td>
                <td>{{ appointments.apptDate }}</td>
                <td>{{ appointments.doctor }}</td>
                <td>{{ appointments.apptId }}</td>

            </tr>
        </tbody>

      </table>
</template>

<script>
export default {
    props: ['appointmentsList']

}
</script>

<style scoped>

</style>