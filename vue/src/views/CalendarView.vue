<template>
    <section>
        <h2>
            INSERT CALENDAR (V CALENDAR)
        </h2>
        <Calendar />
        <DatePicker v-model="date" />
    </section>
</template>

<script>
import 'v-calendar/style.css';
import { Calendar, DatePicker } from 'v-calendar';

export default {
    components: {
        Calendar,
        DatePicker,
    },

    data() {
        return {
            date: new Date(),
        };
    },

}
</script>

<style scoped>

</style>