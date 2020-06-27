<template>
  <div id="app">
    <img src="./assets/logo.png">
    <div>
      <p>
        If Element is successfully added to this project, you'll see an
        <code v-text="'<el-button>'"></code>
        below
      </p>
		  <el-button>SignUp</el-button>
    </div>
	<!--这个是重点，页面跳转的渲染都在这里实现-->
	<router-view></router-view>
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import	SignUp from	'./components/SignUp.vue'
export default {
  name: 'app',
  components: {
    //SignUp
    HelloWorld
  },
  data(){
	  return{
		  UrlData:{
			  signup:'/signup'
		  }
	  }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
