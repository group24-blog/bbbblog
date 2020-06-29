<template>
  <el-container class="home_container">
    <!-- 头部区 -->
    <el-header>
      <div class="head_box">
        <img src="../assets/logo.png" alt="">
        <span>个人博客系统</span>
        <el-button type="info" plain @click="showInfo">个人信息</el-button>
      </div>

    </el-header>
    <!-- 主体区 -->
    <el-main>Main</el-main>
  </el-container>
</template>

<script>
  export default {
    name: 'Home',
    data(){

    },
    methods:{
      showInfo(){
        this.$router.push('/info')
      }

    }

  }
</script>

<style lang="less" scoped>
  .home_container{
    height: 100%;
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
