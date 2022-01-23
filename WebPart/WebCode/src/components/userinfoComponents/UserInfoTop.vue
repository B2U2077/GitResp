<template>
    <div id="self-content">
        <el-image class="bgImg" :src="backImgUrl">
            <div slot="error" class="image-slot">
                <i class="el-icon-picture-outline"></i>
            </div>
        </el-image>
        <div class="u-userinfo-container">
            <div class="u-ui-img">
                <a style="display: inline-block;
                    width: 100%;
                    height: 96px;">
                    <el-image class="avatarImg" :src="avatarUrl">
                        <div slot="error" class="image-slot">
                            <i class="el-icon-picture-outline"></i>
                        </div>
                    </el-image>
                </a>
                <div class="e-hover-code">
                    <a @click="to('/')">编辑头像</a>
                </div>
            </div>
            <div class="u-ui-name">
                <span class="f-thide">{{userName}}</span>
            </div>
            <div class="u-ui-tag">
                <span>{{tag}}</span>
            </div>
            <div class="u-ui-box f-fr">
                <div class="u-ui-box-i">
                    <div class="u-userInfoBox-container">
                        <div class="u-ui-time" :title="studyTime">
                            <i class="el-icon-time"></i>
                        </div>
                        <div class="u-ui-time-tip" :title="studyTime">
                            <span>学习时长</span>
                        </div>
                        <div class="u-ui-time-cont" :title="studyTime">
                            <span>
                                <span class="f-thide1">76时26分</span>
                            </span>
                        </div>
                        <el-divider class="u-ui-time-spin" direction="vertical"></el-divider>
                        <div class="u-ui-discuss" :title="commentsSum">
                            <i class="el-icon-chat-line-square"></i>>
                        </div>
                        <div class="u-ui-discuss-tip" :title="commentsSum">
                            <span>主题/回复</span>
                        </div>
                        <div class="u-ui-discuss-cont" :title="commentsSum">
                            <span>34</span>
                        </div>
                        <el-divider class="u-ui-disscuss-spin" direction="vertical"></el-divider>
                        <div class="u-ui-zan" :title="thumbLikes">
                            <i class="el-icon-thumb"></i>
                        </div>
                        <div class="u-ui-zan-tip" :title="thumbLikes">
                            <span>获赞数量</span>
                        </div>
                        <div class="u-ui-zan-cnt" :title="thumbLikes">
                            <span>99+</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="u-ui-f2f">
                <span>
                    <span>关注1人</span>
                    |
                    <span>粉丝10人</span>
                </span>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Userinfotop',
        data() {
            return {
                thumbLikes: '获得赞数之和',
                commentsSum: '发帖数、回复数、评论数之和',
                studyTime: '累计视频学习时间',
                userName: '小黑',
                tag: '学生',
                backImgUrl: require('@/assets/img/UserInfoTop.png'),
                avatarUrl: require('@/assets/img/dog.png')
            };
        },
        mounted() {

        },
        methods: {
            to(url) {
                this.$router.push(url);
            }
        },
    };
</script>

<style scoped>
    .u-ui-f2f > span {
        line-height: normal;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 16px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }

    .u-ui-f2f {
        left: 167px;
        top: 102px;
        width: 500px;
        height: 21px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        min-width: 0px;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
    }

    .e-hover-code a {
        position: absolute;
        top: -4px;
        left: -4px;
        width: 104px;
        height: 104px;
        background: rgba(0, 0, 0, 0.4);
        border-radius: 50px;
        text-align: center;
        line-height: 104px;
        color: #ffffff;
    }

    .u-ui-zan-cnt > span {
        line-height: 24px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 18px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }

    .u-ui-zan-cnt {
        left: 225px;
        top: 120px;
        width: 80px;
        height: 24px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 24px;
    }

    .u-ui-zan-tip > span {
        line-height: 19px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 14px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }

    .u-ui-zan-tip {
        left: 225px;
        top: 97px;
        width: 70px;
        height: 19px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 19px;
    }

    .el-icon-thumb {
        line-height: 40px;
        display: inline-block;
        width: 100%;
        font-size: 40px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }
    
    .u-ui-zan {
        left: 180px;
        top: 100px;
        width: 40px;
        height: 40px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 40px;
    }

    .u-ui-disscuss-spin {
        left: 311px;
        top: 100px;
        width: 1px;
        height: 40px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        font-size: 16px;
        background-color: rgb(255, 255, 255);
        margin: 0px;
        padding: 0px;
    }

    .u-ui-discuss-cont > span {
        line-height: 24px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 18px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }
    .u-ui-discuss-cont {
        left: 50px;
        top: 120px;
        width: 90px;
        height: 24px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 24px;
    }

    .u-ui-discuss-tip > span {
        line-height: 19px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 14px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }

    .u-ui-discuss-tip {
        left: 50px;
        top: 97px;
        width: 70px;
        height: 19px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 19px;
    }

    .el-icon-chat-line-square {
        line-height: 40px;
        display: inline-block;
        width: 100%;
        font-size: 40px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }

    .u-ui-discuss {
        left: 0px;
        top: 101px;
        width: 40px;
        height: 40px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 40px;
    }

    .u-ui-time-spin {
        left: 150px;
        top: 100px;
        width: 1px;
        height: 40px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        font-size: 16px;
        background-color: rgb(255, 255, 255);
        margin: 0px;
        padding: 0px;
    }

    .f-thide1 {
        line-height: 24px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 18px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }
    
    .el-icon-time {
        line-height: 40px;
        display: inline-block;
        width: 100%;
        font-size: 55px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }
    .u-ui-time-cont {
        left: 0px;
        top: 120px;
        width: auto;
        height: 24px;
        border-radius: 0px;
        position: relative;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 67px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px 0px 0px 394px;
        padding: 0px;
        line-height: 24px;
    }
    .u-ui-time-tip > span {
        line-height: 19px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 14px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }
    .u-ui-time-tip {
        left: 394px;
        top: 98px;
        width: 61px;
        height: 19px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 19px;
    }
    .u-icon-clock-icon {
        line-height: 40px;
        display: inline-block;
        width: 100%;
        font-size: 40px;
        color: rgb(255, 255, 255);
        text-align: center;
        vertical-align: middle;
    }

    .u-ui-time {
        left: 342px;
        top: 101px;
        width: 40px;
        height: 40px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 4;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 40px;
    }

    .u-userInfoBox-container {
        left: 0px;
        top: 0px;
        width: auto;
        height: 220px;
        border-radius: 0px;
        position: relative;
        clear: none;
        display: block;
        min-width: 0px;
        color: rgb(0, 0, 0);
        font-size: 16px;
        margin: 0px auto;
        padding: 0px;
    }

    .u-ui-box {
        left: 0px;
        top: -10px;
        width: auto;
        height: 220px;
        border-radius: 0px;
        position: relative;
        clear: none;
        min-width: 0px;
        color: rgb(0, 0, 0);
        font-size: 16px;
        margin: 0px;
        padding: 0px;
        float: right;
    }

    .u-ui-name {
        left: 167px;
        top: 38px;
        width: 564px;
        height: 35px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 3;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 35px;
    }

    .u-ui-tag {
        left: 167px;
        top: 78px;
        width: 564px;
        height: 17px;
        border-radius: 0px;
        position: absolute;
        clear: none;
        font-size: 0px;
        display: block;
        min-width: 0px;
        z-index: 3;
        color: rgb(0, 0, 0);
        margin: 0px;
        padding: 0px;
        line-height: 13px;
    }

    .u-ui-tag > span {
        line-height: 13px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 13px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }

    .f-thide {
        line-height: 35px;
        display: inline-block;
        width: 100%;
        font-family: 微软雅黑, "Microsoft YaHei";
        font-size: 26px;
        color: rgb(255, 255, 255);
        text-align: left;
        vertical-align: middle;
    }

    .avatarImg {
        width: 96px;
        height: 96px;
        border-radius: 50px;
    }

    .u-userinfo-container {
        left: 0px;
        top: 0px;
        width: 1260px;
        height: 220px;
        border-radius: 0px;
        position: relative;
        clear: none;
        display: block;
        min-width: 0px;
        color: rgb(0, 0, 0);
        font-size: 16px;
        margin: 0px auto;
        padding: 0px;
    }

    .u-ui-img {
        left: 37px;
        top: 40px;
        width: 96px;
        height: 96px;
        border-radius: 50px;
        position: absolute;
        clear: none;
        display: block;
        min-width: 0px;
        z-index: 3;
        color: rgb(0, 0, 0);
        font-size: 16px;
        border-style: solid;
        border-color: rgb(255, 255, 255);
        border-width: 3px;
        background-color: rgb(255, 255, 255);
        margin: 0px;
        padding: 0px;
        cursor: auto;
    }

    #self-content {
        height: 220px;
        background: #5c7ba3;
    }

    .bgImg {
        width: 100%;
        height: 220px;
        border: 0;
        position: absolute;
        left: 0;
        top: 60;
    }
</style>