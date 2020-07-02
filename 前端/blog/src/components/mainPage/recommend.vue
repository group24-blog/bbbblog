<template>
	<div>
		<blog-list 
		v-bind:url="this.url">
		</blog-list>
	</div>
</template>

<script>
	import ViewList from "./blogView/viewlist.vue"
	
	export default{
		name:"recommend",
		data(){
			return{
				url:'http://07prjk91rd.52http.com/blog/recommend/',
			}
		},
		components:{
			"blog-list":ViewList,
		}
	}
</script>

<style>
</style>
