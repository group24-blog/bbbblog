<template>
	<!--发表博客的页面-->
	<div class="edit">
		<!--标题栏-->
		<div class="titleBox">
		  <el-input placeholder="请输入博客标题" v-model="input1">
		    <template slot="prepend">标题</template>
		  </el-input>
		</div>
		<div>
			<el-input class="editBox"
			  type="textarea"
			  :rows="20"
			  placeholder="请输入博客正文"
			  v-model="textarea">
			</el-input>
			<el-button  type="primary" style="float:right;margin-top: 10px;">发表</el-button>
		</div>
	</div>
</template>

<script>
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
