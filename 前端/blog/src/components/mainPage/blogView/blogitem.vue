<template>
	<div class="blogItem">
		<el-row>
			<el-col :span="3">
				<el-avatar :size="50" :src="this.avatarSrc"></el-avatar>
				<div class="author">{{this.author}}</div>
			</el-col>
			<el-col :span="18">
				<el-card class="blogCard" @click="detail">
					  <div slot="header" class="title">
					    <span>{{this.blogTitle}}</span>
						<div class="date">{{this.time}}</div>
					   </div>
				<div class="content">{{this.blogContent}}</div>
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
				}
		},
		props:{
			blogTitle: String,
			blogContent:String,
			author:String,
			time:String,
			blogid:Number,
			avatarSrc:String,
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
	.date{
		float:right;
		font-size: 12px;
		color: #999999;
		font-weight: lighter;
		margin-top: 15px;
	}
</style>
