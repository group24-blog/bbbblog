<template>
    <div class="info_container" id="infoBgPic">
      <div class="info_box" >
		  <!-- 数据区 -->
		    <el-form   label-width="80px" class="info">
		  		<h2>  *账号：  {{userForm.account}}</h2>
		  		<h2>  *昵称：   {{userForm.name}}</h2>
		  		<h2>  *性别：  {{userForm.sex}}</h2>
		  		<h2>  *简介：  {{userForm.introduction}}</h2>
		  		<h2>  *邮箱：  {{userForm.email}}</h2>
		  </el-form>
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
				<el-button type="text"  >关注 </el-button>
				<el-button type="text" >{{this.followedlist.length}}</el-button>


			</el-form>
			<el-form class="followed">
				<el-button type="text" >粉丝</el-button>
					<el-button type="text" >{{this.followlist.length}}</el-button>
			</el-form>
		<!-- 按钮区 -->
		<el-form class="changebtn">

			<el-form-item class="namebtn">
				<el-button type="primary"  @click="changename" >修改</el-button>
			</el-form-item>
			<el-form-item class="intrbtn">
				<el-button type="primary" @click="changeintr" >修改</el-button>
			</el-form-item>
			<el-form-item class="emailbtn">
				<el-button type="primary" @click="changeemail" >修改</el-button>
			</el-form-item>

		</el-form>


      </div>
	  <!-- 粉丝 -->
		 <div class="follow_box">
			 <el-col :span="18" v-for="follow in followlist">
			 	<el-card class="followCard" >

						<el-avatar :size="50" :src="follow.photo" class="avatar" ></el-avatar>
						<el-button type="primary" plain size="medium" round @click="changeuser(follow.account)">进他主页</el-button>

						<div class="finfo">
							<h4>{{'*账号*: '+follow.account}}</h4>
							<h4>{{'*昵称*:'+follow.name}}</h4>
							<h4>{{'*简介*:'+follow.introduction}}</h4>
						</div>
			 	</el-card>
			 </el-col>
		 </div>

		 <!-- 关注 -->
		 <div class="followed_box">
		 			 <el-row :span="18" v-for="followed in followedlist">
		 			 	<el-card class="followerCard">
		 			 		 <el-avatar :size="50" :src="followed.photo" class="avatar" ></el-avatar>
		 			 		 <el-button type="primary" plain size="medium" round @click="changeuser(followed.account)">进他主页</el-button>

		 			 		 <div class="finfo">
		 			 		 	<h4>{{'*账号*: '+followed.account}}</h4>
		 			 		 	<h4>{{'*昵称*:'+followed.name}}</h4>
		 			 		 	<h4>{{'*简介*:'+followed.introduction}}</h4>
		 			 		 </div>
		 			 	</el-card>
		 			 </el-row>
		 </div>


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
      }
    },
	created(){
		this.getUserInfo()
		this.getFollow()
		this.getFollowed()
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
