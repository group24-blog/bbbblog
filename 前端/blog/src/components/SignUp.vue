<template>
<!--使用带验证功能的表单，来判断密码、用户名等是否符合-->
<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" style="width:400px;margin: auto;padding-right:60px;
border:solid #AAAAAA 4px;border-radius: 10px;">
	<el-row style="text-align: left;width: 100%;">
		<el-col>
			<el-button icon="el-icon-back" style="border: none" click="back"></el-button>
		</el-col>
	</el-row>
		<el-form-item label="用户名" prop="name">
			<!--使用v-model实现数据绑定-->
			<el-input v-model="ruleForm.name" placeholder="请输入长度在3~10的用户名"></el-input>
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
		<el-input v-model="ruleForm.password2" placeholder="请再次输入密码" show-password></el-input>
	</el-form-item>
	<!--注册-->
	<el-form-item style="width: 100%;">
		<el-button type="primary" style="width: 100%" v-on:click="signup">注册</el-button>
	</el-form-item>
		
</el-form>
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
					callback(new Error('请再次输入密码！'))
				} else if (!value.equals(this.ruleForm.password)) {
					callback(new Error('两次密码输入不一致！'))
				} else {
					callback()
				}
			}
			return {
				// 数据
				ruleForm: {
					name: '',
					sex: 'male',
					email: '',
					password: '',
					password2: ''
				},
				rules: {
					name: [{
						validator: validataName,
						trigger: 'blur'
					}],
					password: [{
						validator: validataPass,
						trigger: 'blur'
					}],
					password2: [{
						validator: validCheckPass,
						trigger: 'blur'
					}]
				}

			}
		}
	}
</script>

<style>
</style>
