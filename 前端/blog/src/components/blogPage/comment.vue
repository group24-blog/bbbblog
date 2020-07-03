<template>
	<div class="container">
		  <!--评论输入框-->
		<div class="inputBox">
			  <el-input class="gray-bg-input"
			            v-model="inputComment"
			            type="textarea"
			            :rows="3"
			            autofocus
			            placeholder="写下你的评论">
			  </el-input>
			  <div class="btn-control">
			    <span class="cancel" @click="cancel">取消</span>
			    <el-button class="btn" type="success" round @click="commitComment">确定</el-button>
			  </div>
		</div>
		<!--分页-->
		<div style="width: auto;text-align: center;margin-top: 5%;">
			<el-pagination class="pagination"
				small
				:hide-on-single-page="true"
				layout="prev, pager, next"
				:page-size="10"
				:total="11">
				<comment-item v-bind:key=comment.commentId v-for="comment in comments">
					
				</comment-item>
				<el-divider>·以上就是全部回复了</el-divider>
			</el-pagination>
		</div>
	</div>
</template>

<script>
	import CommentItem from "./commentItem.vue"
	export default{
		name:'comment-module',
		data(){
			return{
				inputComment:'',
				replyId:0
			}
		},
		props:{
			comments:Array,
			blogId:Number,
		},
		methods:{
			cancel(){
				this.inputComment=''
			},
			//发表 
			commitComment(){
				let Comment={
					"commentContent":this.inputComment,
					"userAccount":window.sessionStorage.getItem('account'),
					"userName":'',
					"commentTime":'',
					"replyId":this.replyId,
					"replyAccount":'',
					"commentId":null,
					"blogId":this.blogId,
					"avatar":'',
				};
				var self=this;
				this.$http.post('http://07prjk91rd.52http.com/comments/publish',Comment)
				  .then(function (response) {
				    console.log(Comment);
				  })
				  .catch(function (error) {
					  self.$notify({
						  type:'warning',
							message:'连接服务器失败！'
					  })
				    console.log(error);
				  });
				  this.replyId=0;
			},
			setReplyId(id){
				this.replyId=id;
			}
		},
		components:{
			"comment-item":CommentItem,
		}
	}
	
</script>

<style>
	.inputBox{
		width: auto;
		height: 100px;
		margin-top: 20px;
	}
	.btn-control{
		margin-top: 15px;
		float: right;
	}
	.cancel{
		margin-right: 30px;
	}
	.pagination{
		margin: auto;
	}
</style>
