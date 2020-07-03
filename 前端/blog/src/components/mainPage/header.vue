<template>
  <div>
    <!--将router设为true将根据index作为Path跳转-->
    <el-menu :default-active="homeUrl" class="menu" router="true" @select="handleSelect" mode="horizontal">
      <el-img src="userpic" class="pic"></el-img>
      <el-menu-item index="/home/info" class="pic">个人信息</el-menu-item>
      <el-menu-item index="/home/myblog"><router-link to="myblog"></router-link>个人博客</el-menu-item>
      <el-menu-item index="/home/recommend">推荐内容</el-menu-item>
      <el-menu-item index="/home/follow">关注内容</el-menu-item>
      <el-menu-item>
        <el-input class="inputBox" size="small"
                  prefix-icon="el-icon-search" @input="search" v-model="searchContent">
          <el-button slot="append" type="primary" class="button" @click="search">搜索</el-button>
        </el-input>
      </el-menu-item>
      <el-menu-item index="/home/edit">发表博客</el-menu-item>
	   <el-menu-item >
		   <el-button @click="loginOrExit">{{this.iflogin}}</el-button>
	   </el-menu-item>
    </el-menu>
    <!--变化的部分-->
  </div>
</template>

<script>
  import Blogs from "./blogView/viewlist.vue";
  import Recommend from "./recommend.vue"
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
        homeUrl:this.$route.path+"/myblog",
				iflogin:'登录'
      }
    },
	created() {
		if(window.sessionStorage.getItem('iflogin') === 'true'){
			this.iflogin = '退出'
		}
		else{
			this.iflogin = '登录'
		}
	},
    methods:{
      showInfo(){
        this.$router.push('/info')
      },
      search(){
        //搜索

			var content=this.searchContent;
			console.log(content);
			this.$router.push({path:'/home/search',query:{content:content}})
      },

			loginOrExit(){
					this.$router.push('/login')
					window.sessionStorage.setItem('iflogin','false')
			}
    },
    components:{
      Blogs,
      Info,
	  Recommend
    }

  }
</script>

<style>
  .menu{
    height: 100%;
	padding-left:10%;
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
