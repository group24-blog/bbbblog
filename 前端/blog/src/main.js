import Vue from 'vue'
import App from './App'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css'
import Notifications from "vue-notification"
Vue.prototype.$notify = Notification

import axios from 'axios'
<<<<<<< HEAD
=======
axios.defaults.baseURI = 'http://07prjk91rd.52http.com'
>>>>>>> 1a9062766f20d8a6ebaf20ac47445995e5e2be91
Vue.prototype.$http = axios

Vue.use(Notifications)

Vue.config.productionTip = false

/*注册评论组件*/

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
