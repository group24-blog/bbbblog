<template>
  <div class="sign_container" id="signBgPic">
<!--使用带验证功能的表单，来判断密码、用户名等是否符合-->
<el-form  class="signForm" :model="ruleForm" :rules="rules" ref="ruleFormRef" label-width="100px">
	<el-row class="backBtn" >
		<el-col>
			<el-button icon="el-icon-back" style="border: none" v-on:click="back"></el-button>
		</el-col>
	</el-row>
		<el-form-item label="用户名" prop="account">
			<!--使用v-model实现数据绑定-->
			<el-input v-model="ruleForm.account" placeholder="请输入长度在3~10的用户名"></el-input>
		</el-form-item>
	<!--单选框选择性别-->
	<el-form-item label="性别" prop="sex" style="text-align: left;">
		<el-radio label="male" v-model="ruleForm.sex">男</el-radio>
		<el-radio label="female" v-model="ruleForm.sex">女</el-radio>
	</el-form-item>
	<!--输入邮箱-->
	<el-form-item label="邮箱" prop="email">
		<el-input v-model="ruleForm.email" placeholder="请输入邮箱"></el-input>
	</el-form-item>
	<!--输入密码-->
	<el-form-item label="密码" prop="password">
		<el-input v-model="ruleForm.password" placeholder="请输入8-16位的密码" show-password></el-input>
	</el-form-item>
	<!--再次输入密码-->
	<el-form-item label="确认密码" prop="password2">
		<el-input v-model="ruleCheck.password2" placeholder="请再次输入密码" show-password></el-input>
	</el-form-item>
	<!--注册-->
	<el-form-item class="signbtn" >
		<el-button type="primary" style="width: 100%" v-on:click="signup">注册</el-button>
	</el-form-item>
</el-form>
  </div>
</template>

<script>
	export default {
		data() {
			// 用户名检验函数
			var validataName = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('用户名不能为空'))
				} else if (value.length < 3 || value.length > 10) {
					callback(new Error('用户名长度必须在3~10个字符'))
				}
			}
			// 密码检验函数
			var validataPass = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('密码不能为空'))
				} else if (value.length < 8 || value.length > 16) {
					callback(new Error('密码必须为8~16位'))
				}
			}
			// 再次输入密码检验函数
			var validCheckPass = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请再次输入密码！'+value))
				} else if (value==this.ruleForm.password) {
					callback(new Error('两次密码输入不一致！'))
				} else {
					callback()
				}
			}
			return {
				// 数据
				ruleForm: {
					account: '',
					sex: 'male',
					email: '',
					password: '',
				},
				ruleCheck:{
					password2:''
				},
				rules: {
					account: [{
					  require:true,
						validator: validataName,
						trigger: 'blur'
					}],
					password: [{
            require:true,
						validator: validataPass,
						trigger: 'blur'
					}],
					password2: [{
            require:true,
						validator: validCheckPass,
						trigger: 'blur'
					}]
				},
				UrlData:{
					currentUrl:'/signup',
					postUrl:'/posting'
				},

			}
		},
		methods:{
			signup:function(){
				var self=this
			  //这里来原来是rules我改成了ruleForm，不知道会不会影响到你的功能，留意一下
				this.$refs.ruleFormRef.validate(async (valid) =>{
					if(!valid)
						return 0
				}),
				this.$http.post('http://54g64mqf56.52http.com/register',self.ruleForm)
				  .then(function (response) {
					  /*注册成功、用户名已被注册等情况
					  *注册成功：state=1，用户已被注册:state=2,莫名其妙：state=3?
					  * 这里的this代表axios，vue应该用self
					  * */
					  if(response.data===1){
						  self.$notify({
							  type:'sucess',
							  message:'注册成功！'
						  })
						  //注册成功转到主页
						  this.$router.push({name:'home'})
					  }
					  else if(response.data===2){
						  //用户已被注册，报错
						  self.$notify({
					  		  type:'warning',
							  message:'该用户已被注册！'
						  })
					  }
					  else {
						  //莫名其妙地错
						  self.$notify.error({
						  	  type:'sucess',
						  	  message:'注册成功！'
						  })
					  }
				    console.log(response);
				  })
				  .catch(function (error) {
					  self.$notify({
						  type:'warning',
							message:'连接服务器失败！'
					  })
				    console.log(error);
				  });
			},
			//返回登录页面
			back:function(){
				this.$router.push('/login')
			}
		}
	}
</script>

<style lang="less" scoped>
#signBgPic{
    background: url("../assets/注册.png");
    width:100%;
    height:100%;
    position:fixed;
    background-size:100% 100%;
}
  .sign_container {

  height: 100%;
  width: auto;
}
      .signForm {
        background-color: white;
        position: absolute;
        height: 400px;
        width: 350px;
        top: 10%;
        left: 35%;
		//margin:0 auto;
        padding-right: 60px;
        border: solid #AAAAAA 4px;
        border-radius: 10px;
        .backbtn {
          position: absolute;
          text-align: left;
          width: 100%;
        }
        .signbtn {
          position: absolute;
          width: 100%;
          left: -10%;
        }
      }
</style>
