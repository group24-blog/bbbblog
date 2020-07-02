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
			 <el-avatar :size="70" class = "userhead"  src="http://07prjk91rd.52http.com/images/1593700860184.png">
			 </el-avatar>

			<el-upload
			  class="upload"
			  action="http://07prjk91rd.52http.com/user/upload"
			  :data= "upaccount"
			  >
			  <el-button  type="test">上传</el-button>
			</el-upload>

			</el-form>
			<el-form class="follow">
				<el-button type="text" @click="showfollow = true">关注</el-button>
			</el-form>
			<el-form class="followed">
				<el-button type="text" @click="showfans = true">粉丝</el-button>
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

		<el-drawer
		  title="关注列表"
		  :visible.sync="showfollow"
		  direction="rtl"
		  size="50%">
		   <el-table :data="showfollow">

		    </el-table>
		</el-drawer>
      </div>
    </div>
</template>

<script>
  export default {

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
		upaccount:{
			account: window.sessionStorage.getItem('account')
		},
		headphoto:''
      }
    },
	created(){
		this.getUserInfo()
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
				console.log(this.headphoto)
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
		left:40%;
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

</style>
