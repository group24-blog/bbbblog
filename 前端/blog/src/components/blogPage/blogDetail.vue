<template>
	<div class="container">
		<router-view name="mainheader"></router-view>
		<el-page-header @back="goBack"></el-page-header>
		<el-container>
			<el-aside style="width: 220px;">
				<el-card class="authorCard">
					<div>
						<el-avatar :size="50" :src="Blog.photo"></el-avatar>
						<div class="author">{{Blog.articleUserName}}</div>
						<el-row class="detail">
							<el-col :span="12">{{"关注者："+Blog.followers+"人"}}</el-col>
							<el-col :span="12">{{"博客数:"+Blog.blogNum}}</el-col>
						</el-row>
						<el-button class="follow" size="small" type="danger" @click="follow">{{FollowButtonContent}}</el-button>
					</div>
				</el-card>
			</el-aside>
			<el-container>
				<el-main>
					<el-card class="content">
						<div>{{this.Blog.articleTitle}}</div>
						<div class="time">{{"发表于 "+Blog.articleTime}}</div>
						<el-divider></el-divider>
						<div>{{Blog.articleContent}}</div>
					</el-card>
				</el-main>
				<el-footer>
					<!--评论区-->
					<!--分页page-size每页10条-->
					<comment-module style="width: 100%;height: auto;"
					:comments="Comments"
					:blogId="this.Id">
					</comment-module>
				</el-footer>
			</el-container>
		</el-container>
	</div>
</template>

<script>
	import Comment from "./comment.vue"
	export default {
		name: 'blogDetail',
		data() {
			return {
				Id: 2,
				Url: 'http://07prjk91rd.52http.com/blog/detail/',
				Blog: {},
				Comments:[],
				Author: {},
				blogNum:0,
				FollowButtonContent:'关注'
			}
		},
		components: {
			//注册
			'comment-module': Comment,
		},
		created: function() {
			console.log("begin");
			this.getBlog();
		},
		methods: {
			goBack() {
				this.$http.push('/home')
			},
			async getBlog() {
				this.Id =Number (this.$route.query.blogId);
				var id=this.Id;
				var url=this.Url;
				console.log(this.Id);
				const {
					data: res
				} = await this.$http.get(url+id);
				console.log(res);
				this.Blog = res;
				this.Author=res.atticleUser;
				this.blogNum=res.blogNum;
				this.Comments=res.briefCommentList;
				consle.log(this.Comments);
			},
			//关注博主
			follow(){
				
			}
		}
	}
</script>

<style>
	.container {
		width: 80%;
		margin: auto;
	}

	.aside {
		width: 200px;
	}

	.authorCard {
		width: 200px;
		text-align: center;
		margin-top: 10%;
	}
	.author {
		font-size: 16px;
		font-weight: bold;
	}

	.detail {
		font-size: 14px;
		color: #999999;
		width: 100%;
		margin: auto;
		margin-top: 10px;
	}

	.follow {
		margin: auto;
		margin-top: 10px;
	}
	.time{
		float: right;
		color: #999999;
		font-size: 14px;
	}
</style>
