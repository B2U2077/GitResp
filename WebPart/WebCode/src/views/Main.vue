<template>
    <div class="hello">
        <el-container class="el-container">
            <el-header id="divHeader">
                <div id="divHeaderChild1">
                    <el-menu :default-active='activeIndex' class="el-menu-demo" mode="horizontal"
                        background-color="#ffffff" text-color="#433f3a"
                        active-text-color="#ffd04b">
                        <el-menu-item index="1">
                            <router-link to="/mainComponents/indexview">
                                <el-image :src="require('@/assets/img/2077.png')">
                                    <div slot="error" class="image-slot">
                                        <i class="el-icon-picture-outline"></i>
                                    </div>
                                </el-image>
                            </router-link>
                        </el-menu-item>
                        <el-submenu index="2">
                            <template slot="title">课程</template>
                            <el-menu-item index="2-1">选项1</el-menu-item>
                            <el-menu-item index="2-2">选项2</el-menu-item>
                            <el-menu-item index="2-3">选项3</el-menu-item>
                            <el-menu-item index="2-3">选项4</el-menu-item>
                        </el-submenu>
                        <el-menu-item index="2">学校</el-menu-item>
                        <el-menu-item index="3">下载App</el-menu-item>
                        <el-menu-item index="4">我的学校云</el-menu-item>
                        <el-menu-item index="5">
                            <div>
                                <el-input placeholder="请搜索感兴趣的课程" suffix-icon="el-icon-search">
                                </el-input>
                            </div>
                        </el-menu-item>
                        <el-submenu index="6" id="infoCenter" v-if="flag">
                            <template slot="title" suffix-icon="el-icon-s-custom">
                                <span>
                                    <el-avatar :size="50" :src="require('@/assets/img/dog.png')"></el-avatar>
                                </span>
                                个人中心
                            </template>
                            <el-menu-item index="6-1">
                                <router-link to="/mainComponents/userinfo" style="text-decoration: none; color: inherit;">
                                    我的信息
                                </router-link>
                            </el-menu-item>
                            <el-menu-item index="6-2" @click="logout()">注销</el-menu-item>
                        </el-submenu>
                        <div index="6" id="loginInfo" v-else>
                            <el-link @click="to('/login')">
                                登录
                            </el-link>
                             | 
                            <el-link @click="to('/register')">
                                注册
                            </el-link>
                        </div>
                    </el-menu>
                </div>
            </el-header>

            <el-main class="mainView">
                <router-view/>
            </el-main>

            <el-footer class="footerClass" style="height: 200px;">
                <div class="g-flow f-cb">
                    <div class="f1 f-fl">
                        <div class="logo"></div>
                        <p class="f-fc14 f-fc9">
                            由高教社联手网易推出，让每一个有提升愿望的用户能够学到中国知名高校的课程，并获得认证。
                        </p>
                    </div>

                    <div class="f4 f-fr f-pr">
                        <h4>友情链接</h4>
                        <div class="f-cb">
                            <a href="#" class="f-fc9 f4a" style="text-decoration:none;color: #999;">
                                网易云课堂
                            </a>
                        </div>
                    </div>

                    <div class="f2 f-fr f-pr">
                        <h4>关于我们</h4>
                        <div class="f-cb">
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                关于我们
                            </a>
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                学校云
                            </a>
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                联系我们
                            </a>
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                常见问题
                            </a>
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                意见反馈
                            </a>
                            <a href="#" class="f-fc9 f2a" style="text-decoration:none;color: #999;">
                                法律条款
                            </a>
                        </div>
                    </div>
                </div>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: 'Main',
        inject: ['reload'],
        data() {
            return {
                activeIndex: '1',
                flag: false     //判断是否登录标志
            }
        },
        mounted() {
            let userName = localStorage.getItem("userName");
            if(userName) {
                this.flag = true;
            } else {
                this.flag = false;
            }
        },
        methods: {
            to(url) {
                this.$router.push(url)
            },
            logout() {  //注销
                localStorage.removeItem("userName");
                this.reload();
            }
        }
    }
</script>

<style>

    .f-cb {
        zoom: 1;
    }

    .f2 .f2a {
        display: inline-block;
        width: 60px;
        height: 25px;
        font-size: 12px;
    }

    .f2 {
        width: 128px;
        margin-right: 50px;
    }

    h4 {
        margin-top: 0;
        font-weight: 500;
        color: #CCCCCC;
        font-size: 16px;
        margin-bottom: 16px;
    }

    .f4 .f4a {
        display: block;
        width: 72px;
        height: 25px;
        font-size: 12px;
    }

    .f-fr {
        float: right;
        position: relative;
    }
    
    .logo {
        width: 100%;
        height: 88px;
        background: url('../assets/img/2077_88.png') no-repeat;
        background-size: contain;
    }

    .f1 p {
        margin-top: 12px;
        font-size: 13px;
        width: 516px;
    }

    .f-fl {
        float: left;

    }

    .f-fc9 {
        color: #999;
    }

    #loginInfo {
        font-size: 30px;
        margin-top: 10px;
        
    }

    #divHeader {
        left: 0px;
        top: 0px;
        width: 100%;
        height: 64px;
        border-radius: 0px;
        position: relative;
        clear: none;
        display: block;
        min-width: 0px;
        z-index: 21;
        color: black;
        margin: 0px;
        padding: 0px;
        background-color: #fff;
    }


    #divHeaderChild1 {
        left: 0px;
        top: 0px;
        width: 1200px;
        height: 64px;
        border-radius: 0px;
        position: relative;
        clear: none;
        display: block;
        min-width: 0px;
        color: black;
        font-size: 16px;
        background-color: white;
        margin: 0px auto;
        padding: 0px;
    }

    #infoCenter {
        margin-left: 40px;
    }

    li.el-menu-item {
        font-size: 17px;
    }

    .el-menu--horizontal>.el-submenu .el-submenu__title {
        height: 60px;
        line-height: 60px;
        border-bottom: 2px solid transparent;
        color: #fff;
        font-size: 17px;
    }

    .mainView {
        margin-top: 3px;
        background-color: #f7f7f7;
        padding: 0;
    }

    .footerClass {
        bottom: 0;
        width: 100%;
        height: 143px;
        border-top: 1px solid #272727;
        background-color: #272727;
        padding: 35px 0 35px 0;
        line-height: 20px;
        /* position: absolute; */
    }

    .g-doc, .g-flow {
        width: 960px;
        margin: 0 auto;
    }

    
</style>