<template>
    <section>

        <form>
            <div>
                <label for="srvcName">Service Name:</label>
                <input name="srvcName" type="text" v-model="serviceObject.serviceName" />
            </div>

            <div>
                <label for="srvcDeets">Service Details:</label>
                <textarea name="srvcDeets" v-model="serviceObject.serviceDetails"></textarea>
            </div>

            <div>
                <label for="srvcRate">Hourly Rate:</label>
                <input name="srvcRate" type="number" v-model="serviceObject.hourlyRate" />
            </div>

            <button @click.prevent="save">Save!</button>
            <button @click.prevent="cancel">Cancel</button>

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

</style>