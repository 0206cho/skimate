import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import store from "./scripts/store";
import router from "./scripts/router";
import moment from 'moment';
import VueMoment from "vue-momentjs";

loadFonts()

createApp(App)
  .use(vuetify)
  .use(moment)
  .use(VueMoment)
  .use(store)
  .use(router)
  .mount('#app')
