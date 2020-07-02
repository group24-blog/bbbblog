<template>
    <div class="login_container" :style="backgroundPic">
	<div>
		<img src="../assets/登录标语.png" alt="" class="title">
	</div>
      <div class="login_box">
        <!-- 头像区 -->
        <div class="awatar_box">
          <img src="../assets/logo.png" alt="" >
        </div>
      <!-- 登录区 -->
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="80px" size="mini" class="login_form">
        <el-form-item label="账号" prop="account">
          <el-input v-model="loginForm.account"
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
      </el-form>
      <!-- 按钮区 -->
      <el-form class="buttons">
        <el-form-item class="loginbtn">
          <el-button type="primary" class="btn2"  @click="login">登录</el-button>
        </el-form-item>
        <el-form-item class="elsebtn">
          <el-button type="text" class="btn1" @click="signup">注册账号</el-button>
          <el-button type="text" class="btn3">忘记密码</el-button>
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
        account: 'shengziwei',
        password: '1234567'
      },
      backgroundPic: {
        backgroundImage: 'url(' + require('../assets/登录柠檬.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'contain'
      },
      // 表单验证规则对象
      loginFormRules: {
        account: [ { required: true, message: '请输入用户账号', trigger: 'blur' },
          { min: 10, max: 10, message: '输入的账号不正确', trigger: 'blur' }],
        password: [{ required: true, message: '请输入用户密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在6-15个字符', trigger: 'blur' }]
      }
    }
  },
  methods: {
    login () {
      this.$refs.loginFormRef.validate(async (valid) => {
        //验证账号密码，后续添加
        if (!valid) return 0
        const {data :res} = await this.$http.post('http://07prjk91rd.52http.com/user/login', this.loginForm)
        if(res === false)  this.$message.error("登录失败！")
        else {
          this.$message.success('登录成功！')
		  window.sessionStorage.setItem('account',this.loginForm.account)
          this.$router.push('/home')
        }
      })
    },
	signup(){
		this.$router.push('/signup')
	}
  },
}
</script>

<style lang="less" scoped>
  .login_container{
    background-color: white;
    height: 100%;
    width: auto;
  }
  .title{
    width:180px;
    margin-top:1%;
    margin-left:68%
  }
  .login_box{
    width: 350px;
    height: 400px;
    background-color: #DDDDDD;
    border-radius: 10px;
    position: absolute;
    margin: auto;
    left: 68%;
    top: 20%;
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
  .login_form {
    position: absolute;
    bottom: 25%;
    left: 5%;
    padding: 0 10px;
    box-sizing: border-box;
  }
  .buttons{
    width: 250px;
    height: 100px;
    position: absolute;
    bottom: 0%;
    .loginbtn{
      position: absolute;
      width: 100%;
      bottom: 40%;
      left: 60%;
    }
    .elsebtn{
      position: absolute;
      bottom: -10%;
      width: 100%;
      left: 5%;
      .btn2{
        position: absolute;
        width: 100%;
        bottom: 0%;
        left: 0%;
      }
      .btn3{
        position: absolute;
        bottom: 0%;
        left: 100%;
      }
    }

  }

</style>
