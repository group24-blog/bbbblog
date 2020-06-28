import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import SignUp from '../components/SignUp.vue'

Vue.use(Router)

export default new Router({
	mode:'history',
  routes: [
    {
      path: '/', redirect: '/login'
    },
    {
      path: '/login',
      component: Login,
    },
	{
		path:'/sign',
		component:SignUp,
	}
  ]
})
