<template>
    <div class="info_container" id="infoBgPic">
      <div class="info_box">
        <el-form   label-width="80px">
          <el-form-item label="昵称">

          </el-form-item>
        </el-form>
      </div>
    </div>
</template>

<script>
  export default {
    data () {
      return {

      }
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
  }

</style>
