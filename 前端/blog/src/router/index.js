import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import SignUp from '../components/SignUp'
import Info from '../components/Info'
import Home from '../components/Home'

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
		path:'/signup',
		component:SignUp,
	},
    {
      path: '/home',
      component: Home
    },
    {
      path: '/info',
      component: Info
    }
  ]
})
