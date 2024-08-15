<template>
    <section>

        <form>
            <div>
                <label class="name" for="srvcName">Service Name:</label>
                <input name="srvcName" type="text" v-model="serviceObject.serviceName" />
            </div>

            <div>
                <label class="details" for="srvcDeets">Service Details:</label> 
                <input name="srvcDeets" v-model="serviceObject.serviceDetails" />
            </div>

            <div>
                <label for="srvcRate">Hourly Rate:</label>
                <input class="rate" name="srvcRate" type="number" v-model="serviceObject.hourlyRate" />
            </div>

            <button class="save" @click.prevent="save">Save!</button>
            <button class="cancel" @click.prevent="cancel">Cancel</button>

        </form>

    </section>
</template>

<script>
import DoctorService from '../services/DoctorService';

export default {
    data() {
        return {
            serviceObject: {},
            addMode: false,
        };
    },
    methods: {
        save() {
            if (this.addMode) { // fresh new service, call create (POST)
                DoctorService.createService(this.serviceObject).then(response => {
                    alert("Success!");
                    this.$router.push({ name: 'servicesView' });
                })
                .catch(error =>{
                    console.error(error);
                    alert("Couldn't change service list! Please try again later");
                })
            } else { // changed service, call update (PUT)
                DoctorService.updateServiceById(this.serviceObject).then(response => {
                    alert("Success!");
                    this.$router.push({ name: 'servicesView' });
                })
                .catch(error =>{
                    console.error(error);
                    alert("Couldn't change service list! Please try again later");
                })
            }
        },
        cancel() {
            this.$router.push({ name: 'servicesView' });
        }
    },
    created() {
        this.serviceObject = this.$store.state.serviceUpdateObject;
        this.addMode = this.serviceObject.serviceId ? false : true;
    }
}
</script>

<style scoped>

form {
    display: flex;
        justify-content: center;
        justify-content: space-between;
        align-items: stretch;
        font-size: 15px;
        border-bottom: 15px solid white;
}
textarea {
    width: 120%;
}
.details {
    font-size: 15px;
}
.rate {
    width: 50%;
}

</style>