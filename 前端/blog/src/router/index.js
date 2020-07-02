import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import SignUp from '../components/SignUp'
import Info from '../components/Info'
import Home from '../components/mainPage/Home'
import MyBlogs from "../components/mainPage/blogView/myBlog"
import Blogs from "../components/mainPage/blogView/viewlist.vue"
import Header from "../components/mainPage/header"
import Edit	from "../components/mainPage/edit"
import Recommend from "../components/mainPage/recommend"
import Test from "../components/blogPage/blogDetail.vue"

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/', redirect: '/home/myblog'
    },

    {
		name:Login,
      path: '/login',
      component: Login,
    },
    {
		name:SignUp,
      path:'/signup',
      component:SignUp,
    },
	{
		//测试用
		path:'/test',
		component:Test
	},
    {
      path: '/home',
      name:Home,
      components:{
        default:Home,
        mainheader:Header,
      },
      children:[{
        path:'info',
        component:Info
      },
        {
          path:'myblog',
          component:MyBlogs
        },
        {
          path:'recommend',
          component:Recommend,
        },
        {
          path:'follow',
          component:Blogs
        },
		{
			path:'edit',
			component:Edit
		}],
    },
  ]
})
