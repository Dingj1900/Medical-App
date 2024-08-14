<template>
    <section>
        <h1>Here is your appointment info:</h1>
        <div>
            <p>{{ appointmentInfo.user?.firstName }} {{ appointmentInfo.user?.middleInitials }} {{  appointmentInfo.user?.lastName  }}</p>
            <p>{{ appointmentInfo.user?.gender }}</p>
            <p>{{ appointmentInfo.user?.middle }}</p>
            <!-- <p>{{ appointmentInfo.user.phoneNumber }}</p> -->
            <!-- <p>{{  }}</p>
            <p>{{  }}</p> -->
        </div>

        <!--For adding time for the appointment-->
        <!-- <div><label for="hours">Appointment Starting Hours</label>
          <select name="hours" required autofocus>
            <option disabled selected>Hours From</option>
            <option value="00:00:00">12:00am</option>
            <option value="01:00:00">1:00am</option>
            <option value="02:00:00">2:00am</option>
            <option value="03:00:00">3:00am</option>
            <option value="04:00:00">4:00am</option>
            <option value="05:00:00">5:00am</option>
            <option value="06:00:00">6:00am</option>
            <option value="07:00:00">7:00am</option>
            <option value="08:00:00">8:00am</option>
            <option value="09:00:00">9:00am</option>
            <option value="10:00:00">10:00am</option>
            <option value="11:00:00">11:00am</option>
            <option value="12:00:00">12:00pm</option>
            <option value="13:00:00">1:00pm</option>
            <option value="14:00:00">2:00pm</option>
            <option value="15:00:00">3:00pm</option>
            <option value="16:00:00">4:00pm</option>
            <option value="17:00:00">5:00pm</option>
            <option value="18:00:00">6:00pm</option>
            <option value="19:00:00">7:00pm</option>
            <option value="20:00:00">8:00pm</option>
            <option value="21:00:00">9:00pm</option>
            <option value="22:00:00">10:00pm</option>
            <option value="23:00:00">11:00pm</option>
          </select> -->

        <!-- </div> -->

        <button> Make the appointment </button>

    </section>
</template>

<script>


export default {
    data() {
        return {
            apptInfo: []

        };
    },
    computed: {
        appointmentInfo() {
            return this.$store.state.appointmentInfo;
        }
    },
    methods: {
        createAppointment() {
             this.$store.commit("SET_APPOINTMENT_INFO", this.apptInfo);
        }
    },
    created() {
        if (!this.appointmentInfo.user) {
            this.$router.push( {name: 'servicesView'} );
        }
    }

}
</script>

<style scoped>

</style>