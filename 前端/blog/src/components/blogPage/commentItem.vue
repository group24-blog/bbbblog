<!--评论模块-->
<template>
	 <div class="commentBox">
		 <el-divider></el-divider>
	   <div class="info">
	     <el-avatar class="avatar" style="float: left;" :src="this.photo" size="30"></el-avatar>
	     <div class="right">
	       <div class="name">{{this.userName}}</div>
	       <div class="date">{{this.time}}</div>
	     </div>
	   </div>
	   <el-row><div class="content">{{this.content}}</div></el-row>
	   <div class="control">
	     <span class="comment-reply" @click="showCommentInput(item)">
	       <i class="iconfont icon-comment"></i>
	       <span class="button">回复</span>
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
	 .commentBox{
		 width: 100%;
		 margin: 5px;
	 }
	 .right{
		 float: left;
		 text-align: left;
		 margin-left: 15px;
	 }
	 .name{
		 color: black;
		 font-size: 16px;
	 }
	 .date{
		 color: #999999;
		 font-size: 12px;
	 }
	 .button{
		 color: #777777;
		 font-size: 14px;
		 float: right;
	 }
</style>