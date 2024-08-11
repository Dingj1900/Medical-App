<template>
<!-- <head>
    <title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body> -->

<!-- Side Navigation -->
<!-- <nav class="w3-sidebar w3-bar-block w3-card w3-animate-left w3-center" style="display:none" id="mySidebar">
  <h1 class="w3-xxxlarge w3-text-theme">Side Navigation</h1>
  <button class="w3-bar-item w3-button" onclick="w3_close()">Close <i class="fa fa-remove"></i></button>
  <a href="#" class="w3-bar-item w3-button">Link 1</a>
  <a href="#" class="w3-bar-item w3-button">Link 2</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 4</a>
</nav> -->

<!-- Header -->
<!-- <header class="w3-container w3-theme w3-padding" id="myHeader">
  <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i> 
  <div class="w3-center">
  <h4>BEAUTIFUL OFFICE CHOICES</h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">MY OFFICE</h1>
    <div class="w3-padding-32">
      <button class="w3-btn w3-xlarge w3-dark-grey w3-hover-light-grey" onclick="document.getElementById('id01').style.display='block'" style="font-weight:900;">LEARN W3.CSS</button>
    </div>
  </div>
</header> -->

<!-- Modal -->
<!-- <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-top">
      <header class="w3-container w3-theme-l1"> 
        <span onclick="document.getElementById('id01').style.display='none'"
        class="w3-button w3-display-topright">×</span>
        <h4>Oh snap! We just showed you a modal..</h4>
        <h5>Because we can <i class="fa fa-smile-o"></i></h5>
      </header>
      <div class="w3-padding">
        <p>Cool huh? Ok, enough teasing around..</p>
        <p>Go to our <a class="w3-btn" href="/w3css/default.asp">W3.CSS Tutorial</a> to learn more!</p>
      </div>
      <footer class="w3-container w3-theme-l1">
        <p>Modal footer</p>
      </footer>
    </div>
</div>

<div class="w3-row-padding w3-center w3-margin-top">
<div class="w3-third">
  <div class="w3-card w3-container" style="min-height:460px">
  <h3>Services</h3><br>
  <i class="fa fa-desktop w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <p>Built-in responsiveness</p>
  <p>Mobile first fluid grid</p>
  <p>Fits any screen sizes</p>
  <p>PC Tablet and Mobile</p>
  </div>
</div>

<div class="w3-third">
  <div class="w3-card w3-container" style="min-height:460px">
  <h3>Info</h3><br>
  <i class="fa fa-css3 w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <p>Standard CSS only</p>
  <p>Easy to learn</p>
  <p>No need for jQuery</p>
  <p>No JavaScript library</p>
  </div>
</div>

<div class="w3-third">
  <div class="w3-card w3-container" style="min-height:460px">
  <h3>My Office</h3><br>
  <i class="fa fa-diamond w3-margin-bottom w3-text-theme" style="font-size:120px"></i>
  <p>Paper like design</p>
  <p>Bold colors and shadows</p>
  <p>Equal across platforms</p>
  <p>Equal across devices</p>
  </div>
</div>
</div>
</body>
</template> -->



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

<!-- <script>
// Side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "100%";
  x.style.fontSize = "40px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Tabs
function openCity(evt, cityName) {
  var i;
  var x = document.getElementsByClassName("city");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  var activebtn = document.getElementsByClassName("testbtn");
  for (i = 0; i < x.length; i++) {
    activebtn[i].className = activebtn[i].className.replace(" w3-dark-grey", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-dark-grey";
}

var mybtn = document.getElementsByClassName("testbtn")[0];
mybtn.click();

// Accordions
function myAccFunc(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

// Slideshows
var slideIndex = 1;

function plusDivs(n) {
  slideIndex = slideIndex + n;
  showDivs(slideIndex);
}

function showDivs(n) {
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}

showDivs(1);

// Progress Bars
function move() {
  var elem = document.getElementById("myBar");   
  var width = 5;
  var id = setInterval(frame, 10);
  function frame() {
    if (width == 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
      elem.innerHTML = width * 1  + '%';
    }
  }
}
</script> -->









<style scoped>
</style>