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
			</el-pagination>
		</div>
	</div>
</template>

<script>
	export default{
		name:'comment-module',
		data(){
			return{
				props:{
					comments:['']
				}
			}
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
