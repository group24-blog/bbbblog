<!--评论模块-->
<template>
	 <div class="commentBox">
	   <div class="info">
	     <img class="avatar" :src="this.photo" width="36" height="36"/>
	     <div class="right">
	       <div class="name">{{this.userName}}</div>
	       <div class="date">{{this.time}}</div>
	     </div>
	   </div>
	   <div class="content">{{this.content}}</div>
	   <div class="control">
	     <span class="comment-reply" @click="showCommentInput(item)">
	       <i class="iconfont icon-comment"></i>
	       <span>回复</span>
	     </span>
	   </div>
	  </div>
</template>

<script>

  import Vue from 'vue'

  export default {
	  name:'comment-item',
	  data(){
		  return{
			  
		  }
	  },
	  props:{
		  photo:String,
		  content:String,
		  time:String,
		  userName:String,
		  replyName:String,
		  commentId:Number,
	  },
	  methods:{
		  showCommentInput(item){
			  this.$emit("setReplyId",this.commentId);
		  }
	  }
    }
</script>

<style>

</style>