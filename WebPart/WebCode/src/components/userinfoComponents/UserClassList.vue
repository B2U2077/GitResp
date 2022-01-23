<template>
    <div>
        <div id="j-home-content" class="home-content">
            <div class="main-content f-cb">
                <div class="main-box f-fl">
                    <div id="j-plan-panle"></div>
                    <div id="j-module-tab" class="module-tab">
                        <div class="u-selectTab-container">
                            <div class="item u-st-course  current ga-click" data-action="课程tag点击">
                                <a href="#" target="_top" class="u-st-course_a1">
                                    <span class="u-st-course_span2">MOOC课程<i class="count">(9)</i></span>
                                </a>
                            </div>
                            <div class="item u-st-spoc-course   ga-click" data-action="课程tag点击">
                                <a href="#" target="_top" class="u-st-course_a1">
                                    <span class="u-st-course_span2">SPOC课程<i class="count">(4)</i></span>
                                </a>
                            </div>
                            <!--Regular if42-->
                            <!--Regular if43-->
                            <div class="item u-st-column  ">
                                <a href="#" target="_top" class="u-st-discuss_a3">
                                    <span class="u-st-column_span4">专栏<i class="count"></i></span></a>
                            </div>
                            <!--Regular if44-->
                            <div class="item u-st-discuss  ">
                                <a href="#" target="_top" class="u-st-discuss_a3">
                                    <span class="u-st-discuss_span4">讨论<i class="count">(34)</i></span>
                                </a>
                            </div>
                            <div class="item u-st-cert   ">
                                <a href="#" target="_top" class="u-st-cert_a5">
                                    <span class="u-st-cert_span6">证书<i class="count">(1)</i></span>
                                </a>
                            </div>
                            <div class="item u-st-course  ">
                                <a href="#" target="_top" class="u-st-course_a1">
                                    <span class="u-st-course_span2">学习计划</span>
                                </a>
                            </div>
                            <div class="item u-st-course  ">
                                <el-button @click="publishClass" v-if='classFlag' type="success" round>发布课程</el-button>
                            </div>
                            <!--Regular if45-->
                        </div>
                    </div>
                    <!-- 发布课程表单弹出框 -->
                    <el-dialog title="发布课程" :visible.sync="dialogFormVisible">
                        <el-form :model="classForm">
                            <el-form-item>
                                <el-upload class="upload-demo" action="#" ref='uploadImg' :auto-upload='false'
                                    :http-request="uploadImg" multiple :limit="1">
                                    <el-button size="small" type="primary">点击上传</el-button>
                                    <div slot="tip" class="el-upload__tip">请上传课程头像</div>
                                </el-upload>
                            </el-form-item>
                            <el-form-item label="课程名称" :label-width="formLabelWidth">
                                <el-input v-model="classForm.suName" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="课程简介" :label-width="formLabelWidth">
                                <el-input v-model="classForm.suInfo" type="textarea"  placeholder="请输入课程简介" maxlength="100"
                                    show-word-limit>
                                </el-input>
                            </el-form-item>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="classSubmit">确 定</el-button>
                        </div>
                    </el-dialog>

                    <div id="j-module-box" class="module-box">
                        <div class="">
                            <div class="b-10"></div>
                            <div class="g-flow f-cb">
                                <div class="g-mn2">
                                    <div class="g-mn2c">
                                        <div class="m-mcdoc">
                                            <div id="j-cnt1">
                                                <div class="m-hometop f-cb">
                                                    <div class="f-fl f-f0" id="j-tab"><a id="auto-id-1618310125253"
                                                            class="active">全部</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
                                                            id="auto-id-1618310125255">正在进行</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
                                                            id="auto-id-1618310125257">即将开始</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
                                                            id="auto-id-1618310125259">已结束</a>
                                                    </div>
                                                </div>
                                                <div id="j-coursewrap" class="m-homecourse">
                                                    <div class="course-panel-wrapper">
                                                        <div class="course-panel-body-wrapper"
                                                            style="text-align: left;">
                                                            <div class="course-card-wrapper" style="text-align: left;" v-for="(classItem,index) in classList" :key="index">
                                                                <div class="box">
                                                                    <el-link class="ga-click"
                                                                        @click="to(classItem.suId,classItem.suName,classItem.vdef10)"
                                                                        target="_blank">
                                                                        <div class="img">
                                                                            <el-image :src="classItem.vdef10">
                                                                                <div slot="error" class="image-slot">
                                                                                    <i class="el-icon-picture-outline"></i>
                                                                                </div>
                                                                            </el-image>
                                                                            <div class="badges"></div>
                                                                        </div>
                                                                        <div class="body">
                                                                            <div class="common-info-wrapper common-info-wrapper-fix-height">
                                                                                <div class="title">
                                                                                    <div class="text"
                                                                                        style="text-align: left;">
                                                                                        <span class="badges">
                                                                                            <el-link target="_blank"
                                                                                                @click="to(classItem.suId,classItem.suName,classItem.vdef10)">
                                                                                                <div class="badge"
                                                                                                    style="background-color: rgb(203,162,101);">
                                                                                                    国家精品
                                                                                                </div>
                                                                                            </el-link>
                                                                                        </span>
                                                                                        <span class="text">{{classItem.suName}}</span>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="school">
                                                                                    <el-link
                                                                                        @click="to(classItem.suId,classItem.suName,classItem.vdef10)"
                                                                                        target="_blank">
                                                                                        {{classItem.scName}}
                                                                                    </el-link>
                                                                                </div>
                                                                            </div>
                                                                            <div class="personal-info">
                                                                                <div class="course-progress">
                                                                                    <div class="status">
                                                                                        <div class="text">
                                                                                            <el-link
                                                                                                @click="to(classItem.suId,classItem.suName,classItem.vdef10)"
                                                                                                target="_blank">
                                                                                                <span
                                                                                                    class="course-progress-text-span">
                                                                                                    已更新46课时
                                                                                                </span>
                                                                                            </el-link>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="course-status">
                                                                                    已于2077年12月10日结束
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </el-link>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Userclasslist',
        data() {
            return {
                subData: '',
                classList: [],  //课程列表
                formLabelWidth: '120px',
                formData: '',
                classForm: {
                    suName: '', //课程名称
                    suInfo: '', //课程简介
                    tAcc: '', //教师账号
                    tPwd: ''    //教师密码
                },
                dialogFormVisible: false,   //课程表单显示标志
                classFlag: false,   //发布课程标志
                imgUrl: require('@/assets/img/SoftwareEngineering.png')
            };
        },
        mounted() {
            let id = localStorage.getItem('character');
            if (id === '教师') {
                this.classFlag = true;
                let account = localStorage.getItem('userName');
                let pwd = localStorage.getItem('userPwd');
                this.classForm.tAcc = account;
                this.classForm.tPwd = pwd;

            } else if (id === '学生') {
                this.classFlag = false;
            }
            this.showClassList();

        },
        methods: {
            uploadImg(file) {
                this.formData.append("file", file.file);
            },
            to(id,name,imgUrl) {
                localStorage.setItem("suName",name);
                localStorage.setItem("suId",id);
                localStorage.setItem("imgUrl",imgUrl);
                this.$router.push('/classComponents/ClassInfoView/${id}');
            },
            publishClass() {
                console.log("发布");
                this.dialogFormVisible = true;
            },
            classSubmit() {
                this.dialogFormVisible = false;
                this.formData = new FormData();
                this.$refs.uploadImg.submit();
                this.formData.append("suName", this.classForm.suName);
                this.formData.append("suTeacher", this.classForm.suTeacher);
                this.formData.append("tAcc",this.classForm.tAcc);
                this.formData.append("tPwd",this.classForm.tPwd);
                this.formData.append("suInfo",this.classForm.suInfo);

                let url = 'http://127.0.0.1:8001/study/subjectList';
                //请求头
                let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }

                this.$axios.post(url, this.formData, config)
                    .then((res) => {
                        console.log(res);
                        this.$refs.uploadImg.clearFiles();
                        console.log("清除已上传文件！");
                        this.showClassList();
                    });
            },
            showClassList() {   //查询出当前用户所参与的课程
                //角色
                let role = localStorage.getItem("character");
                //用户id
                let id = localStorage.getItem("id");
                this.subData = new FormData();
                this.subData.append("role",role);
                this.subData.append("id",id);
                let url = 'http://127.0.0.1:8001/study/userClass/classList';
                this.$axios.post(url,this.subData)
                    .then((res) => {
                        console.log(res);
                        this.classList = res.data;
                    });
            }
        },
    };
</script>

<style scoped>
    .course-card-wrapper .box .body .personal-info .course-status {
        position: absolute;
        bottom: 16px;
        font-size: 12px;
        color: #999999;
    }

    .course-card-wrapper .box .body .personal-info {
        padding-top: 8px;
        height: 65px;
    }

    .course-card-wrapper .box .body .personal-info .course-progress {
        font-size: 13px;
        color: #00c758;
        position: relative;
    }

    .course-card-wrapper .box .body .personal-info .course-progress .status {
        padding-bottom: 6px;
        font-size: 0px;
        top: -10px;
    }

    .course-card-wrapper .box .body .personal-info .course-progress .status .text {
        font-size: 12px;
        width: 110px;
    }

    .course-card-wrapper a,
    .course-card-wrapper a:hover {
        text-decoration: none;
        color: inherit;
    }

    .course-card-wrapper .box .body .common-info-wrapper .school {
        padding-top: 4px;
        color: #999999;
        font-size: 12px;
    }

    .course-card-wrapper a,
    .course-card-wrapper a:hover {
        text-decoration: none;
        color: inherit;
    }

    .course-card-wrapper .box .body .common-info-wrapper .title .badge {
        display: inline-block;
        background-color: #55A8FF;
        font-size: 12px;
        color: white;
        padding-top: 2px;
        padding-bottom: 2px;
        padding-left: 4px;
        padding-right: 4px;
        display: inline-block;
        margin-right: 6px;
    }

    .course-panel-body-wrapper .course-card-wrapper {
        margin-right: 20px;
        margin-bottom: 20px;
    }

    .course-card-wrapper {
        display: inline-block;
        vertical-align: top;
        position: relative;
    }

    .course-card-wrapper .box {
        width: 212px;
        background: #FFFFFF;
        border: 1px solid #EDEDED;
        position: relative;
        z-index: 990;
        height: 246px;
    }

    .course-card-wrapper a,
    .course-card-wrapper a:hover {
        text-decoration: none;
        color: inherit;
    }

    .course-card-wrapper .box .img {
        position: relative;
        width: 100%;
        height: 110px;
        overflow: hidden;
    }

    .course-card-wrapper .box .img el-img {
        position: absolute;
        width: 100%;
        top: -7.96px;
    }

    .course-card-wrapper .box .img .badges {
        position: absolute;
    }

    .course-card-wrapper .box .body {
        padding-top: 4px;
        padding-bottom: 4px;
        padding-left: 7px;
        padding-right: 7px;
    }

    .course-card-wrapper .box .body .common-info-wrapper-fix-height {
        height: 60px;
    }

    .course-card-wrapper .box .body .common-info-wrapper .title {
        font-size: 14px;
        color: #111111;
    }

    .course-card-wrapper .box .body .common-info-wrapper .title .text {
        font-size: 0px;
    }

    .course-card-wrapper .box .body .common-info-wrapper .title .text {
        font-size: 14px;
    }

    .course-panel-wrapper {
        font-family: "Microsoft YaHei", 微软雅黑, "Arial", "Hiragino Sans GB", "Helvetica", "sans-serif";
    }

    .course-panel-body-wrapper {
        font-size: 0px;
        width: 960px;
        margin: auto;
    }

    .c1>a {
        float: left;
    }

    .b-10,
    .b-20,
    .b-30,
    .b-15,
    .b-40,
    .b-50 {
        clear: both;
        height: 10px;
        overflow: hidden;
        display: block;
    }

    .home-content {
        width: 1260px;
        margin: 0 auto;
    }

    .main-content {
        width: 1200px;
        margin: 0 auto;
    }

    .f-fl {
        float: left;
    }

    .u-selectTab-container {
        left: 0px;
        top: 0px;
        width: 920px;
        height: 36px;
        position: relative;
        display: block;
        min-width: 0px;
        z-index: 0;
        font-family: 微软雅黑, 'Microsoft YaHei';
        color: #333333;
        font-size: 16px;
        border-style: solid;
        border-color: #e6e6e6;
        border-width: 0px 0px 1px;
        border-radius: 0px;
        margin: 0px;
        margin-top: 0px;
        padding: 0px;
        padding-bottom: 0px;
        margin-top: 40px;
        padding-bottom: 13px;
    }

    .u-selectTab-container .item.current {
        border-bottom: 2px solid #00C758;
    }

    .u-selectTab-container .item {
        display: inline-block;
        margin-right: 30px;
        float: left;
    }

    .u-selectTab-container .item a {
        text-decoration: none;
        display: inline-block;
        height: 48px;
        line-height: 48px;
        color: #333333;
    }

    .u-selectTab-container .item.current a {
        color: #00C758;
    }

    .u-selectTab-container i.count {
        font-size: 14px;
        font-style: normal;
    }

    .g-flow {
        width: 1205px;
        margin: 0 auto;
    }

    .g-mn2 {
        float: left;
        width: 100%;
    }

    .g-mn2c {
        margin-right: 245px;
    }

    .m-hometop {
        border-bottom: none;
        font-size: 14px;
        color: #ccc;
        margin-bottom: 40px;
        height: 30px;
    }

    .f-f0,
    .coupon-card {
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
    }

    .m-hometop a.active {
        color: #00c758;
    }

    .m-hometop a {
        vertical-align: middle;
        color: #555;
    }

    .f-f0,
    .coupon-card {
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
    }
</style>