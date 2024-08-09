<template>
     <div>
    <div :style="cssProps"></div>
    <div class="office-info-container">
      <h2>Office Name:</h2>
      <h3 class="officeName">{{ office.officeName }}</h3>
      <div id="app">
  <h2>Address:</h2>
  <div v-if="isEditingAddress">
    <input v-model="office.address" type="text" />
    <button @click="saveAddress">Save</button>
    <button @click="cancelEdit('address')">Cancel</button>
  </div>
  <div v-else>
    <h3 class="address">{{ office.address }}</h3>
    <a href="#" @click.prevent="editField('address')">Edit</a>
  </div>

  <h2>Phone Number:</h2>
  <div v-if="isEditingPhoneNumber">
    <input v-model="office.phoneNumber" type="text" />
    <button @click="savePhoneNumber">Save</button>
    <button @click="cancelEdit('phoneNumber')">Cancel</button>
  </div>
  <div v-else>
    <h3 class="phoneNumber">{{ office.phoneNumber }}</h3>
    <a href="#" @click.prevent="editField('phoneNumber')">Edit</a>
  </div>

  <h2>Office Hours:</h2>
  <div v-if="isEditingHours">
    <div v-if="office.isMonday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isMonday" /> Monday
    </div>
    <div v-if="office.isTuesday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isTuesday" /> Tuesday
    </div>
    <div v-if="office.isWednesday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isWednesday" /> Wednesday
    </div>
    <div v-if="office.isThursday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isThursday" /> Thursday
    </div>
    <div v-if="office.isFriday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isFriday" /> Friday
    </div>
    <div v-if="office.isSaturday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isSaturday" /> Saturday
    </div>
    <div v-if="office.isSunday">
      <input v-model="office.hoursFrom" type="text" placeholder="From" />
      <input v-model="office.hoursTo" type="text" placeholder="To" />
      <input type="checkbox" v-model="office.isSunday" /> Sunday
    </div>
    <button @click="saveHours">Save</button>
    <button @click="cancelEdit('hours')">Cancel</button>
  </div>
  <div v-else>
    <div v-if="office.isMonday">
      <h3 class="monday">Monday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isTuesday">
      <h3 class="tuesday">Tuesday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isWednesday">
      <h3 class="wednesday">Wednesday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isThursday">
      <h3 class="thursday">Thursday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isFriday">
      <h3 class="friday">Friday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isSaturday">
      <h3 class="saturday">Saturday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <div v-if="office.isSunday">
      <h3 class="sunday">Sunday: {{ office.hoursFrom }} - {{ office.hoursTo }}</h3>
    </div>
    <a href="#" @click.prevent="editField('hours')">Edit</a>
  </div>

  <h2>Doctors:</h2>
  <div v-if="isEditingDoctor">
    <input v-model="user.last_name" type="text" />
    <button @click="saveDoctor">Save</button>
    <button @click="cancelEdit('doctor')">Cancel</button>
  </div>
  <div v-else>
    <h3 class="doctors">Dr. {{ user.last_name }}</h3>
    <a href="#" @click.prevent="editField('doctor')">Edit</a>
  </div>

  <h2>Service Cost:</h2>
  <div v-if="isEditingCost">
    <input v-model="services.hourlyRate" type="text" />
    <button @click="saveCost">Save</button>
    <button @click="cancelEdit('cost')">Cancel</button>
  </div>
  <div v-else>
    <h3 class="costPerHour">{{ services.hourlyRate }}</h3>
    <a href="#" @click.prevent="editField('cost')">Edit</a>
  </div>
</div>
    </div>
  </div>
</template>

<script>
import OfficeService from '../services/OfficeService';
import AuthService from '../services/AuthService';
export default {
  data() {
    return {
      // cssProps: {
      //   backgroundImage: `url(${require('@/assets/officebase1img.jpg')})`
      // },
       office: {
        officeName: '',
        address: '',
        phoneNumber: '',
        isMonday: false,
        isTuesday: false,
        isWednesday: false,
        isThursday: false,
        isFriday: false,
        isSaturday: false,
        isSunday: false,
        hoursFrom: '',
        hoursTo: ''
      },
      user: {
        last_name: ''
      },
      services: {
        hourlyRate: ''
      },
      edit: {
        isEditingAddress: false,
        isEditingPhoneNumber: false,
        isEditingHours: false,
        isEditingDoctor: false,
        isEditingCost: false
      },
    };
  },
  methods: {
    editField(field) {
      this[`isEditing${this.capitalizeFirstLetter(field)}`] = true;
    },
    cancelEdit(field) {
      this[`isEditing${this.capitalizeFirstLetter(field)}`] = false;
    },
    saveAddress() {
      this.isEditingAddress = false;
    },
    savePhoneNumber() {
      this.isEditingPhoneNumber = false;
    },
    saveHours() {
      this.isEditingHours = false;
    },
    saveDoctor() {
      this.isEditingDoctor = false;
    },
    saveCost() {
      this.isEditingCost = false;
    },
    capitalizeFirstLetter(string) {
      return string.charAt(0).toUpperCase() + string.slice(1);
    }
  },
  async mounted() {
    try {
      const [officeResponse, userResponse, servicesResponse] = await Promise.all([
        OfficeService.get(),
        // AuthService.getUserInfo(), 
        // ServicesService.getServiceInfo() 
      ]);

      this.office = officeResponse.data;
      this.user = userResponse.data;
      // this.services = servicesResponse.data; 
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }
};
</script>

<style scoped>
</style>