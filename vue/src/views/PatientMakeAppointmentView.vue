<template>
    <section>
        <h1>Here is your appointment info:</h1>
        <div>
            {{  appointmentInfo }}
        </div>

    </section>
</template>

<script>


export default {
    data() {
        return {
            apptInfo: {

            }
        };
    },
    computed: {
        appointmentInfo() {
            return this.$store.state.appointmentInfo;
        }
    },
    methods: {
        createAppointment() {
            // this.$store.commit("SET_APPOINTMENT_INFO", this.apptInfo);
        }
    }

}
</script>

<style scoped>

</style>