import { createApp } from 'vue';
import CapstoneApp from './App.vue';
import { createStore } from './store'; // Ensure createStore is compatible with Vue 3
import router from './router';
import axios from 'axios';
import BootstrapVue3 from 'bootstrap-vue-3'; // Use BootstrapVue3 for Vue 3
import 'bootstrap/dist/css/bootstrap.css'; // Import Bootstrap CSS
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'; // Import BootstrapVue 3 CSS

// Set the base URL for server API communication with axios
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

// Configure Axios authorization header if token exists
const currentToken = localStorage.getItem('token');
if (currentToken) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store with credentials
const store = createStore(); // Adjust according to your store setup

// Create the Vue application
const app = createApp(CapstoneApp);

// Use plugins
app.use(store);
app.use(router);
app.use(BootstrapVue3);

// Mount the Vue app
app.mount('#app');