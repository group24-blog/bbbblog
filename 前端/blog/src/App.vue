<template>
  <div id="app">
    <!-- 路由占位符 -->
	<router-view name="mainheader"></router-view>
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
	 export default {
	    name: 'App',
		//提供局部刷新方法
	    provide(){
	      return{
	        reload:this.reload
	      }
	    },
	    data(){
	      return {
	        isRouterAlive:true,
	      }
	    },
	    methods:{
	      reload(){
	        this.isRouterAlive = false;
	        this.$nextTick(function () {
	          this.isRouterAlive = true
	        });
	      },
	    },
	  }
</script>

<style>
</style>
