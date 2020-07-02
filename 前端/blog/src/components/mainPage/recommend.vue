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
				url:'',
			}
		},
		components:{
			"blog-list":ViewList,
		}
	}
</script>

<style>
</style>
