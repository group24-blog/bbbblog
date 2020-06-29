<template>
	<!--将router设为true将根据index作为Path跳转-->
 <el-menu :default-active="this.$route.path" class="menu" router="true" mode="horizontal" @select="handleSelect">
   <el-menu-item index="/info"><el-img class="pic" src="userpic"></el-menu-item>
   <el-menu-item index="/myblog">个人博客</el-menu-item>
   <el-menu-item index="/recommend">推荐内容</el-menu-item>
   <el-menu-item index="/follow">关注内容</el-menu-item>
   <el-menu-item index="5">
	   <el-input
	       placeholder="搜索"
	       prefix-icon="el-icon-search"
	       v-model="searchContent">
	    </el-input>
		<el-button class="button" @click="serch">搜索</el-button>
   </el-menu-item>
   <el-menu-item index="/publicBlog">发表博客</el-menu-item>
 </el-menu>
</template>

<script>
  export default {
    name: 'Home',
	props:{
		userpic:''
	},
    data(){
		return{
			searchContent:''
		}
    },
    methods:{
      showInfo(){
        this.$router.push('/info')
      },
	search(){
		  //搜索
	  }

    }

  }
</script>

<style lang="less" scoped>
  .menu{
    height: 100%;
  }
  .userpic{
	  width:32px;
	  height=32px;
	  border-radius:50%;
  }
.el-header {
  background-color: gray;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: white;
  font-size: 25px;
  height: 10%;
  width: 100%;
  >div{
    display: flex;
    align-items: center;
  }
}
  .head_box {
    position: absolute;
    left: 1%;
    top: 1%;
    width: 80%;
    height: 8%;
    img {
      padding: 2px;
      border: 1px solid #eeeeee;
      box-shadow: 0 0 10px #dddddd;
      width: 5%;
      height: 100%;
      border-radius: 50%;
      background-color: #eeeeee;
    }
  }

</style>
