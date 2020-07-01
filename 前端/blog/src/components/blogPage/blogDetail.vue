<template>
<div class="container">
	<el-page-header @back="goBack"></el-page-header>
		  <el-container>
		    <el-aside style="width: 220px;">
				<el-card class="author">
					<div>
						<el-avatar :size="50" :src="pic"></el-avatar>
						<div>nobody</div>
						<div>关注者：</div>
						<el-button size="small" type="danger">关注</el-button>
					</div>
				</el-card>
			</el-aside>
		    <el-container>
		      <el-main><el-card class="content">
			  <div>Title</div>
			  <el-divider></el-divider>
			  <div>Content</div>
			  </el-card>
			  </el-main>
		      <el-footer><!--评论区-->
				<!--分页page-size每页10条-->
				<comment-module style="width: 100%;height: auto;"></comment-module>
			</el-footer>
		    </el-container>
		  </el-container>
	</div>
</template>

<script>
	import Comment from "./comment.vue"
	export default{
		name:'blogDetail',
		components:{
			//注册
			'comment-module':Comment,
		},
		methods:{
			goBack(){
				this.$http.push('/home')
			}
		}
	}
</script>

<style>
	.container{
		width: 80%;
		margin: auto;
	}
	.aside{
		width: 200px;
	}
	.author{
		width: 200px;
		text-align: center;
		margin-top: 10%;
		color: #AAAAAA;
	}
</style>
