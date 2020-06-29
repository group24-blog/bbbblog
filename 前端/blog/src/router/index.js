import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import SignUp from '../components/SignUp'
import Info from '../components/Info'
import Home from '../components/mainPage/Home'
import Blogs from "../components/mainPage/blogView/viewlist"

Vue.use(Router)

export default new Router({
	mode:'history',
  routes: [
    {
      path: '/', redirect: '/home'
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
	  children:[{
	  		  path:'/info',
	  		  component:Info
	  },
	  {
	  		  path:'/myblog',
	  		  component:Blogs
	  }
	  ],
	  components:{
	  		default:Home,
			panel:Info,
			panel:Blogs,
	  		},
    },
  ]
})
