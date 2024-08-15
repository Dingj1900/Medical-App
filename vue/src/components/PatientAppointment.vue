<template>
    <div class="w3-container w3-card w3-white w3-round w3-margin"><br>

        <span class="w3-right w3-opacity">
            <p>Time: {{ formatDate(appointmentDetails.apptDate) }} </p>
        </span>

        <h4>Dr. {{ appointmentDetails.doctorFirstName }} {{ appointmentDetails.doctorLastName }}</h4>
        <hr class="w3-clear">

            <p><i>{{ appointmentDetails.officeAddress }}</i></p>
            <p><i>{{ appointmentDetails.officePhone }}</i></p>
            <p>Gender: {{ appointmentDetails.gender }}</p>
            <p>{{ appointmentDetails.dateOfBirth }}</p>
            <p>{{ appointmentDetails.email }}</p>
            <p>{{ appointmentDetails.phone_number }}</p>
            <p>Service: {{ appointmentDetails.serviceDescription }}</p>
        
        <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-half">
                <!--<img src="/w3images/lights.jpg" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">-->
              <p>{{ appointmentDetails.apptFrom }}</p>
            </div>

            <div class="w3-half">
                <!--<img src="/w3images/nature.jpg" style="width:100%" alt="Nature" class="w3-margin-bottom">-->
                <p>{{ appointmentDetails.apptTo }}</p>
            </div>
        </div>
        <!--
        <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i>  Update</button> 
        <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> Delete</button> 
        -->
    </div>
      
</template>
<script>
export default{
    props:{
        appointmentDetails:{
            type: Object,
            required: true
        }
    },
    data(){
        return{


        };
    },
    methods: {
        formatDate(incomingDate) {
            // 2024-08-21 14:00:00.0
            if (incomingDate) {
                const noMillis = incomingDate.substring(0, incomingDate.length - 5);
                const dateString = noMillis.split(" ")[0];
                const timeString = noMillis.split(" ")[1];

                const year = dateString.split("-")[0];
                const month = dateString.split("-")[1];
                const date = dateString.split("-")[2];

                let hour = parseInt(timeString.split(":")[0]);

                let ampm = 'am';
                if (hour >= 12) {
                    ampm = 'pm';
                    
                    if (hour > 12) {
                        hour -=12;
                    }
                }

                return `${month}/${date}/${year} at ${hour}:00 ${ampm}`;
            }
            return '';
        }
    }
}
</script>


<style scoped>

</style>