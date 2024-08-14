<template>
    <section>
        <h1>
            Available appointments for
            {{ appointmentInfo.user?.firstName }} {{ appointmentInfo.user?.middleInitials }} {{  appointmentInfo.user?.lastName  }}
        </h1>

        <div class="service">
            <i><p>{{ appointmentInfo.office?.officeName }}</p>
            <p>{{ appointmentInfo.office?.officeAddress }}</p>
            <p>{{ appointmentInfo.office?.phoneNumber }}</p></i>
            
            <!-- <p></p> does this need v-model? -->

            <p v-show="appointmentInfo.user.openMonday">Monday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[0], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openTuesday">Tuesday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[1], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openWednesday">Wednesday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[2], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openThursday">Thursday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[3], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openFriday">Friday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[4], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openSaturday">Saturday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[5], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            <p v-show="appointmentInfo.user.openSunday">Sunday: <template v-for="n in endTime" :key="n"><button @click="handleCreateAppointment(nearestDays[6], (n + startTime))" v-if="n + startTime <= endTime">{{ formatDate((n+startTime)) }}</button></template></p>
            
    </div>
            </section>
    

            <!-- <p>{{ appointmentInfo.user.phoneNumber }}</p> -->
            <!-- <p>{{  }}</p>
            <p>{{  }}</p> -->

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

</template>




<script>
import PatientService from '../services/PatientService'; 


export default {
    data() {
        return {
            startTime: 0,
            endTime: 0
        };
    },
    computed: {
        nearestDays() {
            // TODO: fix this
            return ['2024-08-19', '2024-08-20', '2024-08-21', '2024-08-22', '2024-08-23', '2024-08-24', '2024-08-25'];
        },
        appointmentInfo() {
            return this.$store.state.appointmentInfo;
        },
        patient() {
            return this.$store.state.user;
        },
    },
    methods: {
        handleCreateAppointment(day, hour) {
            // Make the appointment at ${hour} on ${day}
            alert("Making appointment at " + this.formatDate(hour) + " on " + day);
            const appointmentDto = {
                appointmentId: 0,
                serviceId: this.appointmentInfo.service.serviceId,
                officeId: this.appointmentInfo.office.officeId,
                patientId: this.patient.id,
                doctorId: this.appointmentInfo.service.doctorId,
                apptDate: `${day} ${hour}:00:00`,
                notified: false,
                approved: false
            };

            console.log(appointmentDto);


            PatientService.createAppointment(appointmentDto).then(response => {  // Postgres (via service file that creates an HTTP)
                if (response.status === 201) {
                    // successfully created!
                    this.$router.push({ name: 'patientView' });

                } else {
                    alert("Couldn't save appointment. Try again later?");
                }
            })
            .catch(err => {
                alert("Couldn't save appointment. Try again later?");
                console.error(err);
            });

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
.service {
    margin-left: 50px;
    margin-right: 20px;
}
button {
  background-color: blueviolet;
  margin: 5px;
  border-radius: 8px;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
    .serviceLinks {
        text-decoration: underline;
        color: blue;
        cursor: pointer;
        margin: 20px;
    }

  .service{
  background: rgb(245, 245, 245);
  border: solid 2px rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  margin-bottom: 10px;
  padding: 10px;
  text-shadow: 0 1px 1px rgba(255, 255, 255, 0.8);
  word-wrap: break-word;
  cursor: pointer;
}

</style>