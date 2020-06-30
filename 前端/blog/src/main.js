// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css'
import Notifications from "vue-notification"
Vue.prototype.$notify = Notification

import axios from 'axios'
axios.defaults.baseURI = 'http://07prjk91rd.52http.com'
Vue.prototype.$http = axios

Vue.use(Notifications)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
