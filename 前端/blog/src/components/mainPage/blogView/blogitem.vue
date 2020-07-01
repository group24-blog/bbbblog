<template>
	<div class="blogItem">
		<el-row>
			<el-col :span="3">
				<el-avatar :size="50" :src="rawData.src" @click="toAthor"></el-avatar>
				<div class="author">{{rawData.author}}</div>
			</el-col>
			<el-col :span="18">
				<el-card class="blogCard" @click="detail">
					  <div slot="header" class="title">
					    <span>{{rawData.blogTitle}}</span>
					   </div>
				<div class="content">{{rawData.blogContent}}</div>
				</el-card>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default{
		name:"blogitem",
		data(){
			return{
				rawData:{
					blogTitle: "博客标题",
					requestUrl: {type: String, default: "this.$http.defaults"},
					blogContent:"博客内容",
					author:"nobody",
					blogid:0,
					src:"https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
					}
			}
		},
		methods:{
			open(){
				//打开新的页面显示具体内容
				let routeUrl = this.$router.resolve({
				          path: "/details",
						  query:{author:'author',blogid:'blogid'}
				     });
				     window.open(routeUrl .href, '_blank');
			},
			toAuthor(){
				//去作者的主页
				let routeUrl = this.$router.resolve({
				          path: "/details",
						  query:{author:'author',blogid:'blogid'}
				     });
				     window.open(routeUrl .href, '_blank');
			}
		},
	}
</script>

<style>
	.blogItem{
		width:80%;
		border-radius: 10px;
		padding:10px;
		margin: 20px;
		margin-left: 10%;
	}
	.blogCard{
		border-radius: 10px;
		padding-left: 5px;
		padding-right:5px;
		width: 100%;
		height: 140px;
	}
	.image{
		width: 50px;
		height: 50px;
		border-radius: 50%;
		margin: 0 auto;
	}
	.title{
		margin: -5px;
		font-size: 16px;
		text-align: start;
		font-weight: bold;
	}
	.content{
		margin: -5px;
		font-size: 14px;
		text-align: start;
	}
	.author{
		width: 8%;
		text-align: center;
		margin-top: 10%;
		color: #AAAAAA;
	}
</style>
