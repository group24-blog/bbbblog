<template>
    <div class="login_container" :style="backgroundPic">
      <div class="login_box">

        <!-- 头像区 -->
        <div class="awatar_box">
          <img src="../assets/logo.png" alt="" >
        </div>
        <!-- 登录区 -->
        <el-form  :model="loginForm" label-width="80px" size="mini" class="login_form">
          <el-form-item label="账号">
            <el-input v-model="loginForm.username"
              placeholder="请输入账号"
              prefix-icon="el-icon-user">
            </el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="loginForm.password" show-password
              placeholder="请输入密码"
              prefix-icon="el-icon-lock">
            </el-input>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="primary">登录</el-button>
            <el-button type="info">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
</template>

<script>
export default {
  data () {
    return {
      // 登录表单的数据绑定对象
      loginForm: {
        username: '',
        password: '11'
      },
      backgroundPic: {
        backgroundImage: 'url(' + require('../assets/登录柠檬.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% 100%'
      }
    }
  }
}
</script>

<style lang="less" scoped>
.login_container{
  background-color: antiquewhite;
  height: 100%;
}
  .login_box{
    width: 350px;
    height: 450px;
    background-color: aliceblue;
    border-radius: 3px;
    position: absolute;
    left: 60%;
    top: 10%;
    .awatar_box{
      height: 100px;
      width: 100px;
      border: 1px solid #eeeeee;
      border-radius: 50%;
      padding: 10px;
      box-shadow: 0 0 10px #dddddd;
      position: absolute;
      left: 50%;
      transform: translate(-50%,50%);

      img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eeeeee;
      }

    }
  }
  .login_form{
    position: absolute;
    bottom: 20%;
    left: 8%;
    padding: 0 10px;
    box-sizing: border-box;
  }
  .btns{
    display: flex;
    justify-content: flex-end;
  }
</style>
