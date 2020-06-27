<template>
    <div class="login_container" :style="backgroundPic">
      <div class="login_box">
        <!-- 头像区 -->
        <div class="awatar_box">
          <img src="../assets/logo.png" alt="" >
        </div>
        <!-- 登录区 -->
        <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="80px" size="mini" class="login_form">
          <el-form-item label="账号" prop="username">
            <el-input v-model="loginForm.username"
              placeholder="请输入账号"
              prefix-icon="el-icon-user">
            </el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="loginForm.password" show-password
              placeholder="请输入密码"
              prefix-icon="el-icon-lock">
            </el-input>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="primary" @click="login">登录</el-button>
            <el-button type="info" @click="resetLoginForm">取消</el-button>
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
        password: ''
      },
      backgroundPic: {
        backgroundImage: 'url(' + require('../assets/登录柠檬.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% 100%'
      },
      // 表单验证规则对象
      loginFormRules: {
        name: [ { required: true, message: '请输入用户账号', trigger: 'blur' },
          { min: 10, max: 10, message: '输入的账号不正确', trigger: 'blur' }],
        password: [{ required: true, message: '请输入用户密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在6-15个字符', trigger: 'blur' }]
      }
    }
  },
  methods: {
    // 点击取消
    resetLoginForm () {
      this.$refs.loginFormRef.resetFields()
    },
    login () {
      this.$refs.loginFormRef.validate(async (valid) => {
        if (!valid) return 0
        const result = await this.$http.post('http://192.168.1.102:8181/login/user', this.loginForm)
        console.log(result)
      })
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
