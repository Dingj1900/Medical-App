import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import PatientView from '../views/PatientView.vue';
import PatientSettings from '../components/PatientSettings.vue';
import BookAppointment from '../components/BookAppointment.vue';
import ProviderView from '../views/ProviderView.vue';
import ProviderRegisterView from '../views/ProviderRegisterView.vue';
import OfficeView from '../views/OfficeView.vue';
import CalendarView from '../views/CalendarView.vue';
import ServicesView from '../views/ServicesView.vue';
import PatientOfficeView from '../views/PatientOfficeView.vue';
// import Office from '../components/Office.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register/provider",
    name: "registerProvider",
    component: ProviderRegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/patient",
    name: "patientView",
    component: PatientView,
    meta: {
        requiresAuth: false
    }
  },
  {
    path: "/patient/settings",
    name: "patientSettings",
    component: PatientSettings,
    meta: {
        requiresAuth: false
    }
  },
  {
    path: "/patient/bookappointment",
    name: "bookAppointment",
    component: BookAppointment,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/provider",
    name: "providerView",
    component: ProviderView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/provider/office',
    name: 'providerOfficeView',
    component: OfficeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/provider/calendar',
    name: 'calendarView',
    component: CalendarView,
    meta: {
        requiresAuth: false
    }
  },
  {
    path: '/provider/services',
    name: 'servicesView',
    component: ServicesView,
    meta: {
        requiresAuth: false
    }
  },
  {
    path: '/patient/office',
    name: 'PatientOfficeView',
    component: PatientOfficeView,
    meta: {
        requiresAuth: false
    }
  }
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
