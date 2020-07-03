<template>
	<!--发表博客的页面-->
	<div class="edit">
		<!--标题栏-->
		<el-form :model="briefblog" :rules="editRules" ref="editRef">
		<el-form-item class="titleBox" prop="articleTitle">
		  <el-input placeholder="请输入博客标题" v-model="briefblog.articleTitle" >
		    <template slot="prepend">标题</template>
		  </el-input>
		</el-form-item>
		<el-form-item  prop="articleContent">
			<el-input class="editBox"
			  type="textarea"
			  :rows="20"
			  placeholder="请输入博客正文"
			  v-model="briefblog.articleContent">
			</el-input>
			<el-button  type="primary" style="float:right;margin-top: 10px;" @click = "sendBlog">发表</el-button>
		</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		data (){
			return{
				briefblog :{
					articleTitle:'',
					articleUserAccount: window.sessionStorage.getItem('account'),
					articleContent:''
				},
				editRules:{
					articleTitle: [ { required: true, message: '请输入文章标题', trigger: 'blur' }],
					articleContent: [{ required: true, message: '请输入文章内容', trigger: 'blur' }]
				},
			}
		},
		methods:{
			
			sendBlog(){
				this.$refs.editRef.validate(async (valid) => {
					 if (!valid) return 0
				  const {data: res} = await this.$http.post('http://07prjk91rd.52http.com/blog/publish',this.briefblog)
				  if(res === true){
				  	this.$message.success('发表成功！')
				  	}
				  	else{
				  		this.$message.error('发表失败！')
				  	}
				})
			}

		}
	}
</script>

<style>
	.edit{
		margin: auto;
		width: 60%;
		padding: 30px;
	}
	.titleBox{
		height:40px;
	}
	.editBox{
		margin-top: 10px;
	}
</style>
