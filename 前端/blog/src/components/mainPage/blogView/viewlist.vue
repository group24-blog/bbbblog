<template>
	<div>
		<BlogItem v-for="blog in Blogs" 
		v-bind:key="blog.articleId"
		:blogTitle="blog.articleTitle"
		:avatarSrc="blog.avatarSrc"
		:blogContent="blog.articleContent"
		:author="blog.articleUserAccount"
		:time="blog.articleTime">
		</BlogItem>
	</div>
</template>

<script>
	import BlogItem from './blogitem'
	export default {
		name:"ViewList",
		data(){
			return {
				//返回的未处理的一堆数据
				rawData:[{}],
				//每次处理10条预览
				size:10,
			}
		},
		props:{
			//后端接口
			url:String,
			//最终展示的也是它items为所有item的集合
			Blogs:Array,
		},
		components:{
			BlogItem
		},
		mounted:function(){
			console.log(this.url);
			this.getList();
		},
		methods:{
			async getList(){
				var account=window.sessionStorage.getItem('account');
				var toUrl=this.url;
				console.log(toUrl);
				const {data: res} = await this.$http.get(toUrl+account);
				console.log(res);
				this.Blogs=res;
			},
			goBack(){
				//返回主页
				this.$router.push('/home')
			},
			//分段处理后端传来的信息
			sliceArray(array){
				var result=[];
				for(var x=0;x<Math.ceil(array.length/this.size);x++){
					var start=x*this.size;
					var rend=start+size;
					//将数据切片处理，每次只处理this.size那么多条
					result.push(array.slice(start,end));	
				}
				return result;
			},
			//获取数据
			getRawDatw(String ){
				this.$axios.get(this.content,{
					query:{user:this.user}
				}).then(res=>{
					
				});
			}
		}
	}
</script>

<style>
</style>
