<template>
	<div class="">
		<el-container>
		  <el-header><el-page-header @back="goBack"></el-page-header></el-header>
		  <el-container>
		    <el-aside width="200px">
				<el-card>
					<div>
						<el-avatar :src="pic"></el-avatar>
						<el-button size="small" type="danger">关注</el-button>
					</div>
					<div>nobody</div>
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
						<el-pagination
						  small
						  :hide-on-single-page="true"
						  layout="prev, pager, next"
						  :page-size="10"
						  :total="50">
						</el-pagination></el-footer>
		    </el-container>
		  </el-container>
		</el-container>
	</div>
</template>

<script>
</script>

<style>
</style>
