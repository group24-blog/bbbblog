import Vue from 'vue'
import Router from 'vue-router'
import SignUp from '@/components/SignUp'
import HelloWorld from '@/components/HelloWorld'
import Test from '@/components/test/test'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
    },
	{
	  path: '/signup',
	  name: 'SignUp',
	  component: SignUp
	},
	{
		path:'/test',
		name:'test',
		component:Test
	}
  ],
  mode:'history'
})
