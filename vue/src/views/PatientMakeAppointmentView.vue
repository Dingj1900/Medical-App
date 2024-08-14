<template>
    <section>
        <h1>
            Here are the available appointments for
            {{ appointmentInfo.user?.firstName }} {{ appointmentInfo.user?.middleInitials }} {{  appointmentInfo.user?.lastName  }}
        </h1>
        <div>
            <p>{{ appointmentInfo.office?.officeName }}</p>
            <p>{{ appointmentInfo.office?.officeAddress }}</p>
            <p>{{ appointmentInfo.office?.phoneNumber }}</p>
            
            <p></p>
            <p v-show="appointmentInfo.user.openMonday">Monday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Monday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openTuesday">Tuesday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Tuesday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openWednesday">Wednesday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Wednesday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openThursday">Thursday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Thursday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openFriday">Friday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Friday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openSaturday">Saturday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Saturday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openSunday">Sunday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment('Sunday', (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            
            <p></p>

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

            apptInfo: {
                
            },
            startTime: 0,
            endTime: 0
        };
    },
    computed: {
        appointmentInfo() {
            return this.$store.state.appointmentInfo;
        },
        patient() {
            return this.$store.state.user;
        },
        formattedHoursFrom() {
            if (this.appointmentInfo.user?.hoursFrom) {
                let ampm = 'am';
                const hrsFromPieces = this.appointmentInfo.user?.hoursFrom.split(":"); // 13:00:00
                let hour = parseInt(hrsFromPieces[0]);
                const min = hrsFromPieces[1];

                if (hour > 12) {
                    hour -= 12;
                    ampm = 'pm';
                }

                return `${hour}:${min} ${ampm}`;
            }

            return '';
        },
        formattedHoursTo() {
            if (this.appointmentInfo.user?.hoursTo) {
                let ampm = 'am';
                const hrsFromPieces = this.appointmentInfo.user?.hoursTo.split(":");
                let hour = parseInt(hrsFromPieces[0]);
                const min = hrsFromPieces[1];

                if (hour > 12) {
                    hour -= 12;
                    ampm = 'pm';
                }

                return `${hour}:${min} ${ampm}`;
            }
            return '';
        }
    },
    methods: {
        handleCreateAppointment(day, hour) {
            // Make the appointment at ${hour} on ${day}
            alert("Making appointment at " + this.formatDate(hour) + " on " + day);
        },
        createAppointment() {
             this.$store.commit("SET_APPOINTMENT_INFO", this.apptInfo);
        },
        formatDate(hours) {
            if (hours) {
                let ampm = 'am';
                let hr = parseInt(hours);

                if (hr >= 12) {
                    ampm = 'pm';

                    if (hr > 12) {
                        hr -= 12;
                        ampm = 'pm';
                    }
                }

                return `${hr}:00 ${ampm}`;
            }
            return '';
        }
    },
    created() {
        if (!this.appointmentInfo.user && !this.appointmentInfo.office) {
            this.$router.push( {name: 'PatientServicesView'} );
        }
        
        this.startTime = parseInt(this.appointmentInfo.office.hoursFrom) - 1;
        this.endTime = parseInt(this.appointmentInfo.office.hoursTo);

    }

}
</script>



<style scoped>
    button {
        margin: 10px;
    }

</style>