<template>
	<div class="blogItem">
		<el-image :src="src" class="image"></el-image>
		<el-card class="blogCard" @click="detail">
			<div class="title">
				<span>{{blogTitle}}</span>
			</div>
			<div class="content">{{content}}</div>
		</el-card>
	</div>
</template>

<script>
	export default{
		name:"blogitem",
		props:{
			blogTitle: {type: String, default: "博客标题"},
			requestUrl: {type: String, default: "this.$http.defaults"},
			content:{type:String,defualt:"博客内容"},
			author:{type:String,defualt:"nobody"},
			blogid:{type:Number}
		},
		methods:{
			open(){
				//打开新的页面显示具体内容
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
		width:50%;
		heght:130px;
		border-radius: 10px;
		padding:10px;
	}
	.image{
		width: 50px;
		height: 50px;
		border-radius: 50%;
		margin: 0 auto;
	}
	.title{
		font-size: 18px;
		text-align: start;
		font-weight: bold;
	}
	.content{
		font-size: 16px;
		text-align: start;
	}
</style>
