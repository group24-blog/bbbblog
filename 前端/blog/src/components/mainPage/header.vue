<template>
	<div>
		<!--将router设为true将根据index作为Path跳转-->
	 <el-menu :default-active="homeUrl" class="menu" router="true" mode="horizontal" @select="handleSelect">
	   <el-img src="userpic" class="pic"></el-img>
	   <el-menu-item index="/home/info" class="pic">头像</el-menu-item>
	   <el-menu-item index="/home/myblog"><router-link to="myblog"></router-link>个人博客</el-menu-item>
	   <el-menu-item index="/home/recommend">推荐内容</el-menu-item>
	   <el-menu-item index="/home/follow">关注内容</el-menu-item>
	   <el-menu-item>
<<<<<<< HEAD
		   <el-input
		       placeholder="搜索" prefix-icon="el-icon-search" v-model="searchContent">
			   <el-button slot="append"  @click="search">搜索</el-button>
		    </el-input>
=======
		   <el-input class="inputBox" size="small"
		        prefix-icon="el-icon-search" v-model="searchContent">
		    <el-button slot="append" type="primary" class="button" @click="serch">搜索</el-button>
			</el-input>
>>>>>>> 880fe4bbe8a09035d58c7bcfa7b2681c96ee5828
	   </el-menu-item>
	   <el-menu-item index="writeBlog">发表博客</el-menu-item>
	 </el-menu>
	 <!--变化的部分-->
	 </div>
</template>

<script>
	import Blogs from "./blogView/viewlist.vue";
	import Info from "../Info.vue";	
	export default {
		  //局部刷新
		  inject:['reload'],
	  name: 'Home',
		search:'',
		props:{
			userpic:'../assets/logo.png'
		},
	  data(){
			return{
				searchContent:'',
				panel:"Blogs",
				homeUrl:this.$route.path+"/myblog"
			}
	  },
	  methods:{
	    showInfo(){
	      this.$router.push('/info')
	    },
		search(){
			  //搜索
		  }
	
	  },
		components:{
			Blogs,
			Info
		}
	
	}
</script>

<style>
	.menu{
	  height: 100%;
	}
	.userpic{
		  width:32px;
		  height:32px;
		  border-radius:50%;
	}
	.inputBox{
		width: 300px;
		line-height: 28px;
		border-radius: 10px;
	}
</style>
