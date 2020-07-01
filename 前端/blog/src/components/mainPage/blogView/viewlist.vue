<template>
	<div>
		<BlogItem v-for="(item,index) in items"
		:key="index">
		</BlogItem>
	</div>
</template>

<script>
	import BlogItem from './blogitem'
	export default {
		data(){
			return {
				//最终展示的也是它items为所有item的集合
				items:[{}],
				//返回的未处理的一堆数据
				rawData:[{}],
				//每次处理10条预览
				size:10,
				content:'recommend',
				user:{default:'none'}
			}
		},
		components:{
			BlogItem
		},
		methods:{
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
