<template>
  <el-aside id="aside" style="background-color: rgb(51 153 153);width: 200px;">
    <div style="height:60px;color:#fff">
      <p style="padding-top:10%;padding-left:30%;">赛博教育管理平台</p>
    </div>
    <el-menu class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b"
      router>
      <el-menu-item index="/adminHomeSpace">
        <i class="el-icon-s-marketing"></i>
        <span slot="title">统计</span>
      </el-menu-item>
      <el-menu-item index="/schoolInfo">
        <i class="el-icon-menu"></i>
        <span slot="title">学校管理</span>
      </el-menu-item>
      <el-menu-item index="/teacherInfo">
        <i class="el-icon-s-custom"></i>
        <span slot="title">教师管理</span>
      </el-menu-item>
      <el-menu-item index="/studentInfo">
        <i class="el-icon-user-solid"></i>
        <span slot="title">学生管理</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
</template>

<script>
  import Pass from "@/plugins/Pass.js";

  export default {
    name: 'Asidespace',
    data() {
      return {

      };
    },
    created() {
      Pass.$on("aside_state", (val) => {
        this.aside.aside_state = val;
        if (this.aside.aside_state) {
          this.aside.aside_width =
            this.$cookies.get("setting").aside_small_width + "px";
          this.aside.aside_title = this.$cookies.get("setting").aside_small_title;
        } else {
          this.aside.aside_width =
            this.$cookies.get("setting").aside_width + "px";
          this.aside.aside_title = this.$cookies.get("setting").aside_title;
        }
      });
    },
    methods: {
      change_aside_menu(index) {
        this.activie_index = index;
        if (index != this.$cookies.get("activie_index")) {
          this.$cookies.set("activie_index", index);
          this.$router.push(this.$cookies.get("activie_index"));
        }
      },
      get(e) {
        console.log(e.target.innerHTML);
      },
    },
    mounted() {
      // if (this.$cookies.get("activie_index") == null) {
      //   this.$cookies.set("activie_index", 1);
      //   this.$router.push(this.$cookies.get("activie_index"));
      // }
    },
  };
</script>
<style scoped>
  .el-menu-vertical-demo {
    text-align: left;
  }

  .el-menu {
    /* 去除右侧边框线 */
    border-right: 0 !important;
  }

  #aside::-webkit-scrollbar {
    display: none;
  }

  #aside {
    height: 100vh;
    overflow-x: hidden;
    overflow-y: scroll;
  }
</style>