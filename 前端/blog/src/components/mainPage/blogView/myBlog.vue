<template>
	<div class="block">
	  <el-timeline v-if="num">
		  <!--以空格分割日期字符串，时间戳只显示年月日-->
		  <el-timeline-item v-for="blog in myBlogs" v-bind:key="blog.articleId" 
		    @click.native="gotoDetail(blog.articleId)" v-bind:timestamp="getDate(blog)" placement="top">
			  <el-card>
			    <h4>{{blog.articleTitle}}</h4>
				<p>{{blog.articleContent}}</p>
			    <p style="float: right;">{{blog.articleUserAccount+" 提交于 "+blog.articleTime}}</p>
			  </el-card>
		  </el-timeline-item>
	  </el-timeline>
	  <el-divider v-else>一篇博客也没有哦</el-divider>
	</div>
</template>

<script>
	export default{
		name:'myBlog',
		data(){
			return {
				myBlogs:Array,
				UrlData:{
					baseUrl:'http://07prjk91rd.52http.com',
					myBlogs:'/myblog/'
				},
				num:'false',
				date:','
			}
		},
		//挂载el的时候自动执行方法
		created:function(){
			if(window.sessionStorage.getItem('iflogin') === 'true'){
				this.getMyBlogs();
			}
			else{
				this.$message.error('请先登录')
			}
		},
		methods:{
			async getMyBlogs(){
				var account=window.sessionStorage.getItem('account');
				const {data: res} = await this.$http.get('http://07prjk91rd.52http.com/blog/myblog/'+account)
				console.log(res)
				this.myBlogs=res;
				if(res.length!=0)
				{
					this.num='true'
				}
			},
			gotoDetail(id){
				console.log("click");
				let {href}= this.$router.resolve({
				   path: "/blog",   // 这里写的是要跳转的路由地址
				   query: {blogId:id}  // 这里写的是页面参数
				});
				window.open(href, '_blank');
			},
			getDate(blog){
				var date=blog.articleTime.split(" ")[0];
				console.log(date)
				return date;
			}
		}
		
	}
</script>

<style>
	.block{
		width: 70%;
		margin: auto;
		padding: 30px;
	}
</style>
