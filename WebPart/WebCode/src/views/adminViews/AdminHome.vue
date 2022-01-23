<template>
  <el-container id="aside">
    <AsideSpace />
    <el-container>
      <el-header style="height: 60px;background-color: rgb(253 253 253)">
        <HeadSpace />
      </el-header>
      <el-main id="main" style="background-color: rgb(236 241 234);">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>

  import AsideSpace from '@/components/adminComponents/AsideSpace'
  import HeadSpace from '@/components/adminComponents/HeadSpace'

  export default {
    name: 'Adminhome',
    components: { AsideSpace, HeadSpace },
    data() {
      return {
        tab_data: [],
        aside_state: false,
        route: true,
      };
    },
    mounted() {
      if (sessionStorage.getItem('theme_link') != null) {
        document.getElementById("themeLinkId").href = sessionStorage.getItem('theme_link')
      }
      
    },
    methods: {
      
    },
  };
</script>

<style scoped>
  #aside {
    height: 100vh;
  }

  #main {
    height: 100vh;
    overflow: auto;
  }

  /*滚动条的宽度*/
  ::-webkit-scrollbar {
    width: 9px;
    height: 9px;
  }

  /*外层轨道。可以用display:none让其不显示，也可以添加背景图片，颜色改变显示效果*/
  ::-webkit-scrollbar-track {
    width: 6px;
    background-color: #f2f6fc;
    -webkit-border-radius: 2em;
    -moz-border-radius: 2em;
    border-radius: 2em;
  }

  /*滚动条的设置*/

  ::-webkit-scrollbar-thumb {
    background-color: #F56C6C;
    background-clip: padding-box;
    min-height: 1px;
    -webkit-border-radius: 2em;
    -moz-border-radius: 2em;
    border-radius: 2em;
  }

  /*滚动条移上去的背景*/

  ::-webkit-scrollbar-thumb:hover {
    background-color: #fff;
  }
</style>