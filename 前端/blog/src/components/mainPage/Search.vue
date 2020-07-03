<template>
	<div>
		<blog-list 
		v-bind:url="this.url">
		</blog-list>
		<el-divider>·以上为全部搜索结果</el-divider>
	</div>
</template>

<script>
	import ViewList from "./blogView/viewlist.vue"
	
	export default{
		name:"search",
		data(){
			var content=this.$route.query.content;
			return{
				url:'http://07prjk91rd.52http.com/blog/search/'+content,
			}
		},
		components:{
			"blog-list":ViewList,
		}
	}
</script>

<style>
</style>
