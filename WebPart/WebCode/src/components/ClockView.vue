<template>
    <div id="divClass">
        <div v-if="flag">
            <div>
                <el-avatar :size="72" class="avatarClass" :src="require('@/assets/img/dog.png')"></el-avatar>
            </div>
            <div class="userName">
                帅帆
            </div>
            <div class="myClass">

            </div>
            <div>
                <el-button type="primary" round class="classBtn">我的课程</el-button>
            </div>
        </div>
        <div v-else class="_2yDxf _31uH4">
            <div class="_3xsx0">免费学习来自名校名师的精品课程</div>
            <div>
                <el-avatar :size="72" class="logoutAvatarClass" :src="require('@/assets/img/logoutAvatar.png')"></el-avatar>
            </div>
            <div>
                <el-button type="success" class="classBtn" round @click="to('/login')">登录 | 注册</el-button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Clockview',
        data() {
            return {
                flag: false
            };
        },
        mounted() {
            let userName = localStorage.getItem("userName");
            if (userName) {
                this.flag = true;
            } else {
                this.flag = false;
            }
        },
        methods: {
            to(url) {
                this.$router.push(url)
            }
        },
    };
</script>

<style >

    .logoutAvatarClass {
        margin-top: 90px;
        margin-bottom: 20px;
    }

    ._2yDxF {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        position: relative;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-flow: column nowrap;
        flex-flow: column nowrap;
        -ms-flex-align: center;
        align-items: center;
        width: 200px;
        height: 360px;
        border-radius: 4px;
        background-color: rgb(255, 255, 255);
    }

    ._3xsx0 {
        position: absolute;
        top: 24px;
        width: 160px;
        font-size: 14px;
        line-height: 20px;
        text-align: center;
        color: rgb(51, 51, 51);
        margin-left: 22px;
    }

    #divClass {
        width: 200px;
        height: 360px;
        background-color: rgb(255, 255, 255);
    }

    .classBtn {
        width: 168px;
        height: 32px;
        line-height: 8px;
        font-size: 14px;
        text-align: center;
        position: relative;
    }

    .avatarClass {
        margin-top: 28px;
    }

    .userName {
        font-size: 16px;
        margin-top: 5px;
        margin-bottom: 5px;
    }
</style>