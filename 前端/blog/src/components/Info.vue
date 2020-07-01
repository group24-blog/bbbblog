<template>
    <div class="info_container" id="infoBgPic">
      <div class="info_box">

          <el-form   label-width="80px" class="info">
				<h2>  *账号：  {{userForm.account}}</h2>
				<h2>  *昵称：   {{userForm.name}}</h2>
				<h2>  *性别：  {{userForm.sex}}</h2>
				<h2>  *简介：  {{userForm.introduction}}</h2>
				<h2>  *邮箱：  {{userForm.email}}</h2>

        </el-form>

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
        }

      }
    },
	created(){
		this.getUserInfo()
	},
    methods:{
     async getUserInfo(){

			    const {data: res} = await this.$http.get('http://07prjk91rd.52http.com/user/get/'+ window.sessionStorage.getItem('account'))
				console.log(res)
				this.userForm.account = res.account
				this.userForm.sex = res.sex
				this.userForm.name = res.name
				this.userForm.photo = res.photo
				this.userForm.introduction = res.introduction
				this.userForm.email = res.email
				this.userForm.time = res.time
				this.userForm.password = res.password
				console.log(this.userForm.name)
			},
			changeemail (){
				 this.$prompt('请输入邮箱', '提示', {
				          confirmButtonText: '确定',
				          cancelButtonText: '取消',
				          inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
				          inputErrorMessage: '邮箱格式不正确'
				        }).then(({ value }) => {
				          this.$message({
				            type: 'success',
				            message: '你的邮箱是: ' + value
				          });
						  this.userForm.email = value;

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
				        }).then(({ value }) => {
				          this.$message({
				            type: 'success',
				            message: '你的昵称是: ' + value
				          });
						  this.userForm.name= value;

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
				        }).then(({ value }) => {
				          this.$message({
				            type: 'success',
				            message: '你的简介是: ' + value
				          });
						  this.userForm.introduction= value;

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
    left: 40%;
    top: 15%;
	.info{
		width: 80%;
		height: 70%;
		background-color:whitesmoke;
		border-radius: 10px;
		position: absolute;
		left: 10%;
		top:10%;

	}

	.changebtn{
		width: 30%;
		height: 100%;
		position: absolute;
		left: 50%;
		top: 27%;
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
  }

</style>
