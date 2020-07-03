<template>
    <div class="info_container" id="infoBgPic">
      <div class="info_box" >
		  <!-- 数据区 -->
		    <div class="signForm">
		  		<div class="fontStyle">账号：{{userForm.account}}</div>
				
		  		<div class="fontStyle">昵称：{{userForm.name}}<el-button type="primary" plain size="mini
				" style="float: right;"  @click="changename" >修改</el-button></div>
		  		<div  class="fontStyle">性别：{{userForm.sex}}</div>
		  		<div  class="fontStyle">简介：{{userForm.introduction}}
				<el-button type="primary" plain size="mini" style="float:right" 
				@click="changeintr" >修改</el-button></div>
		  		<div  class="fontStyle">邮箱：{{userForm.email}}
				<el-button type="primary" plain size="mini" style="float:right"
				 @click="changeemail" >修改</el-button></div>
		  </div>
		<!-- 头像区 -->
			 <el-avatar :size="70" class = "userhead"  :src= "headphoto">
			 </el-avatar>

			<el-upload
			  class="upload"
			  action="http://07prjk91rd.52http.com/user/upload"
			  :data= "upaccount"
			  >
			  <el-button  type="test" size="small">上传</el-button>
			</el-upload>

			<el-form class="follow">
				<el-button type="text" @click="visibleFollowing=true">关注 </el-button>
				<el-button type="text" >{{this.followedlist.length}}</el-button>
			</el-form>
			<el-form class="followed">
				<el-button type="text" @click="visibleFollower=true">粉丝</el-button>
					<el-button type="text" >{{this.followlist.length}}</el-button>
			</el-form>
		
		</div>
		
		<el-drawer
		  title="我的粉丝"
		  :visible.sync="visibleFollower"
		  :with-header="false"
		  :append-to-body="true">
		  <!-- 粉丝 -->
		  		 <div class="follow_box">
		  			 	<el-card class="followCard" v-bind:key="follow.account" v-for="follow in followlist">
		  
		  						<el-avatar :size="50" :src="follow.photo" class="avatar" ></el-avatar>
		  						<el-button type="primary" style="float: right;" plain size="small" round @click="changeuser(follow.account)">进他主页</el-button>
		  
		  						<div class="finfo">
		  							 	<span style="margin: 10px;">{{'账号: '+follow.account}}</span>
		  								<span style="margin: 10px;">{{'昵称:'+follow.name}}</span>
		  							 	 <div style="margin: 10px;">{{'简介:'+follow.introduction}}</div>
		  						</div>
		  			 	</el-card>
		  		 </div>
		</el-drawer>
		
		
		<el-drawer
		  title="我的关注"
		  :visible.sync="visibleFollowing"
		  :with-header="false"
		  :append-to-body="true">
		  <!-- 关注 -->
		  <div class="followed_box">
		  		<el-card class="followerCard" v-bind:key="followed.account" v-for="followed in followedlist">
		   		 <el-avatar :size="50" :src="followed.photo" class="avatar" ></el-avatar>
		   		 <el-button type="primary" plain size="small" round 
				 @click="changeuser(followed.account)"
				 style="float: right;">进他主页</el-button>
		
  		 		 <div class="finfo">
  			 		 	<span style="margin: 10px;">{{'账号: '+followed.account}}</span>
						<span style="margin: 10px;">{{'昵称:'+followed.name}}</span>
		  			 	 <div style="margin: 10px;">{{'简介:'+followed.introduction}}</div>
		  		</div>
		  			 	</el-card>
		  </div>
		  
		</el-drawer>
    </div>
</template>

<script>
  export default {
	inject:['reload'],
    data () {
      return {
        userForm: {
          account:'',
          sex:'',
          name:'',
          password:'',
          photo:'',
          introduction:'',
          email:'',
          time:'',
          blogs:[],
          comments:[],
          friends:[],
        },

			followlist:Array,
			followedlist:Array,
		upaccount:{
			account: window.sessionStorage.getItem('account')
		},
		headphoto:'',
		visibleFollower:false,
		visibleFollowing:false,
      }
    },
	created(){
		if(window.sessionStorage.getItem('iflogin') === 'true'){
			this.getUserInfo()
			this.getFollow()
			this.getFollowed()	
		}
		else{
			this.$message.error('请先登录')
		}
		
	},
    methods:{
    async getUserInfo(){

			    const {data: res} = await this.$http.get('http://07prjk91rd.52http.com/user/get/'+ window.sessionStorage.getItem('account'))
				this.userForm.account = res.account
				this.userForm.sex = res.sex
				this.userForm.name = res.name
				this.userForm.photo = res.photo
				this.userForm.introduction = res.introduction
				this.userForm.email = res.email
				this.userForm.time = res.time
				this.userForm.password = res.password
				this.headphoto = res.photo
			},
	async getFollow(){

				    const {data: res} = await this.$http.get('http://07prjk91rd.52http.com/user/friends/'+ window.sessionStorage.getItem('account'))
					this.followlist = res
					console.log(res)
				},
	async getFollowed(){

				    const {data: res} = await this.$http.get('http://07prjk91rd.52http.com/user/subscribe/'+ window.sessionStorage.getItem('account'))
					this.followedlist = res
					console.log(res)
				},
			changeemail (){
				 this.$prompt('请输入邮箱', '提示', {
				          confirmButtonText: '确定',
				          cancelButtonText: '取消',
				          inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
				          inputErrorMessage: '邮箱格式不正确'
				        }).then(async({ value }) => {
				          this.$message({
				            type: 'success',
				            message: '你的邮箱是: ' + value
				          });
						  this.userForm.email = value;

						const{data:res} = await this.$http.put('http://07prjk91rd.52http.com/user/settings',this.userForm)

						if(res === true){
							this.$message.success('修改成功');
						}
						else
							this.$message.error('后台数据更新失败');

				        }).catch(() => {
				          this.$message({
				            type: 'info',
				            message: '取消输入'
				          });
						 })

			},
			 changename (){
				 this.$prompt('请输入昵称', '提示', {
				          confirmButtonText: '确定',
				          cancelButtonText: '取消'
				        }).then( async ({value}) => {
				          this.$message({
				            type: 'success',
				            message: '你的昵称是: ' + value
				          });
						  this.userForm.name= value;

							const{data:res} = await this.$http.put('http://07prjk91rd.52http.com/user/settings',this.userForm)

							if(res === true){
								this.$message.success('修改成功');
							}
							else
								this.$message.error('后台数据更新失败');

				        }).catch(() => {
				          this.$message({
				            type: 'info',
				            message: '取消输入'
				          });
						 })
			},
			changeintr (){
				 this.$prompt('请输入简介', '提示', {
				          confirmButtonText: '确定',
				          cancelButtonText: '取消'
				        }).then(async({ value }) => {
				          this.$message({
				            type: 'success',
				            message: '你的简介是: ' + value
				          });
						  this.userForm.introduction= value;
							const{data:res} = await this.$http.put('http://07prjk91rd.52http.com/user/settings',this.userForm)

							if(res === true){
								this.$message.success('修改成功');
							}
							else
								this.$message.error('后台数据更新失败');
				        }).catch(() => {
				          this.$message({
				            type: 'info',
				            message: '取消输入'
				          });
						 })
			},
			changeuser: function(foaccount){
				sessionStorage.setItem('account',foaccount)
				console.log(foaccount)
				this.reload()
			},

	  }
  }
</script>

<style lang="less" scoped>
  #infoBgPic{
    background: url("../assets/注册.png");
    width:100%;
    height:100%;
    position:fixed;
    background-size:100% 100%;
    }

.info_container{
  height: 100%;
  width: auto;
}
.signForm{
	width: 90%;
	padding-left: 20px;
	margin-top: 30%;
	.fontStyle{
		margin: 20px;
		font-size: 20px;
	}
}
  .info_box{
    width: 500px;
    height: 400px;
    background-color: white;
    border-radius: 10px;
    position: absolute;
    margin: auto;
    left: 35%;
    top: 15%;
	.info{
		width: 80%;
		height: 70%;
		background-color:white;
		border-radius: 10px;
		position: absolute;
		left: 10%;
		top:30%;

	}
	.changebtn{
		width: 30%;
		height: 100%;
		position: absolute;
		left: 55%;
		top: 47%;

		.namebtn{
			position: absolute;
			left: 70%;
			top: 0%;
		}
		.intrbtn{
			position: absolute;
			left: 70%;
			top: 27%;
		}
		.emailbtn{
			position: absolute;
			left: 70%;
			top: 38%;
		}

	}
	.userhead{
		position:absolute;
		left:40%;
		top:5%;
	}
	.upload{
		position:absolute;
		left:42%;
		top:25%;
	}
	.follow{
		  position: absolute;
		  top: 5%;
		  left: 60%;
	}
	.followed{
		  position: absolute;
		  top: 15%;
		  left: 60%;
	}

}

  .followbox{
  	position: absolute;
  	top: 15%;
  	left: 10%;
  }

</style>
