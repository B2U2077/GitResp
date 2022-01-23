<template>
    <div class="g-body">
        <div class="m-cbg"></div>
        <div class="m-learnhead">
            <div class="f-cb" style="height: 40px;">
                <a class="schoolImg f-fl" hidefocus="true" target="_blank" title="东北大学" href="#">
                    <el-image :src="schoolImgUrl" style="width: 108px;height: 40px;"></el-image>
                </a>
                <div class="f-fl info">
                    <div class="f-cb" style="height: 24.8px;">
                        <a hidefocus="true" class="f-fl" target="_blank" href="/course/NEU-1001812013?tid=1450631470">
                            <h4 class="f-fc3 courseTxt">{{suName}}</h4>
                        </a>
                        <a target="_blank" href="https://www.icourse163.org/topics/2018NationalLevelMOOC/">
                            <span class="tag f-f0 f-fl ga-click" data-cate="201609奖学金" data-action="点击奖学金"
                                style="background-color: #CBA265">国家精品
                            </span>
                        </a>
                        <div class="u-cert u-cert2 f-fc6 f-fl" id="web-cert-apply-btn">
                            <div class="_1Zv--">
                                <span>
                                    <i class="el-icon-medal-1"></i>
                                    申请认证证书
                                </span>
                            </div>
                        </div>
                    </div>
                    <h5 class="f-fc6 padding-top-5">
                        <a class="f-fcgreen" href="/u/mooc1478594311713" target="_blank">张爽</a>
                        、<a class="f-fcgreen" href="/u/mooc1533991429689" target="_blank">胡清河</a>
                        、<a class="f-fcgreen" href="/u/mooc15744841498307739" target="_blank">王蓓蕾</a>
                        、<a class="f-fcgreen" href="/u/mooc1533859494873" target="_blank">王学毅</a>
                    </h5>
                </div>
                <div class="f-fr learn-hours" id="j-learn-hours">
                    <div class="_1d3mQ">
                        <div class="learn-hours-first-see"><a class="QsUtY">我的学习时长</a></div>
                    </div>
                </div>
                <div class="f-fr comment">
                    <div class="comment_link" id="j-comment-link" v-if="flag" @click="dialogFormVisible = true">发布课程
                    </div>
                    <div class="comment_link" id="j-comment-link" v-else>评价课程</div>
                    <div class="comment_rating" id="j-comment-rating"></div>
                </div>
            </div>
        </div>
        <!-- 发布课程表单 -->
        <el-dialog title="上传视频" :visible.sync="dialogFormVisible">
            <el-form :model="videoForm" ref="vForm">
                <el-form-item>
                    <el-upload class="upload-demo" action="#" ref='uploadVideo' :auto-upload='false'
                        :http-request="uploadFile" :on-preview="handlePreview" multiple :limit="1">
                        <el-button size="small" type="primary">点击上传</el-button>
                        <div slot="tip" class="el-upload__tip">请上传视频</div>
                    </el-upload>
                </el-form-item>
                <el-form-item label="课程名称" :label-width="formLabelWidth">
                    <el-input v-model="videoForm.vName" autocomplete="off" placeholder="请输入课程名称"></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="videoSubmit">确 定</el-button>
            </div>
        </el-dialog>
        <div class="g-wrap f-cb learnPage">
            <div class="g-sd1">
                <div class="m-learnleft">
                    <div class="top f-pr">
                        <el-image :src="classImg"
                            style="width: 230px;height: 130px;border-radius: 6px;float: left;margin-left: 10px;">
                        </el-image>
                        <el-row class="tab u-tabul">
                            <el-col style="text-align: left;">
                                <el-menu class="el-menu-vertical-demo" router>
                                    <el-menu-item index="/classComponents/ClassClaimView">
                                        <i class="el-icon-s-claim"></i>
                                        <span slot="title">公告</span>
                                    </el-menu-item>
                                    <el-menu-item index="/classComponents/ClassRateStandard">
                                        <i class="el-icon-s-flag"></i>
                                        <span slot="title">评分与标准</span>
                                    </el-menu-item>
                                    <el-menu-item index="/classComponents/ClassVideoView">
                                        <i class="el-icon-document"></i>
                                        <span slot="title">课件</span>
                                    </el-menu-item>
                                    <el-menu-item index="/classComponents/ClassExamView">
                                        <i class="el-icon-s-order"></i>
                                        <span slot="title">考试</span>
                                    </el-menu-item>
                                    <el-menu-item v-if="gradeFlag" index="/classComponents/StuGradesView">
                                        <i class="el-icon-tickets"></i>
                                        <span slot="title">学生成绩</span>
                                    </el-menu-item>
                                </el-menu>
                            </el-col>
                        </el-row>
                    </div>
                </div>
            </div>
            <div class="g-mn1">
                <div class="g-mn1c">
                    <router-view />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Classinfoview',
        data() {
            return {
                suId: null,   //当前课程id
                videoForm: {    //视频表单数据
                    vName: '',

                },
                formLabelWidth: '120px',
                dialogFormVisible: false,   //发布视频表单弹出框标志
                flag: '',
                schoolImgUrl: 'http://localhost:8001/study/img/e6d1bb413b614d5c8a88e15d83d6e782hniu.png',
                classImg: '',
                suName: null,
                gradeFlag: false,
            };
        },
        mounted() {
            let id = localStorage.getItem('character');
            if (id === '教师') {
                this.flag = true;
                this.gradeFlag = true;
            } else if (id === '学生') {
                this.flag = false;
            }
            this.suName = localStorage.getItem("suName");
            this.classImg = localStorage.getItem("imgUrl");
            console.log(this.classImg);
            // //获取当前课程id
            // let suId = this.$route.params.id;
            // this.suId = suId;
            // localStorage.setItem("suId",suId);
        },
        methods: {
            uploadFile(file) {  //自定义的文件上传方法
                this.formData.append('file', file.file);
            },
            videoSubmit() {
                this.dialogFormVisible = false;
                this.formData = new FormData();
                this.$refs.uploadVideo.submit();
                this.formData.append('vName', this.videoForm.vName);
                let suId = localStorage.getItem("suId");
                this.formData.append("suId",suId);
                let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }
                let url = 'http://127.0.0.1:8001/study/videolist';

                this.$axios.post(url, this.formData, config)
                    .then((res) => {
                        console.log(res);
                        this.$refs.uploadVideo.clearFiles();
                        this.$refs.vForm.resetFields();
                        console.log("清除已上传文件！");
                    });
            },
            handlePreview(file) {
                console.log(file);
            }
        },
    };
</script>

<style scoped>
    .g-wrap {
        width: 100%;
    }

    .learnPage {
        background: #eee;
    }

    .g-sd1 {
        position: absolute;
        float: left;
        width: 225px;
        margin-right: -225px;
    }

    .g-mn1c {
        margin-left: 245px;
    }

    .g-mn1 {
        float: right;
        width: 100%;
    }

    .m-learnleft {
        padding: 20px 0;
    }

    /* .m-learnleft .top {
        padding-left: 10px;
    } */

    .f-pr {
        position: relative;
    }

    .m-learnleft .tab {
        width: 230px;
        padding: 0;
        margin: 10px;
    }

    .padding-top-5 {
        margin-top: 0px;
        margin-left: 0px;
        float: left;
        height: 13px;
    }

    h1,
    h2,
    h3,
    h5,
    h6,
    small {
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
        line-height: 1.5;
        font-weight: normal;
        font: 12px/1.5 "Arial", "Hiragino Sans GB", "SimSun", 宋体, "serif";
    }

    .m-learnhead .info .tag {
        font-size: 12px;
        margin-left: 15px;
        padding: 4px;
        vertical-align: middle;
        color: #fff;
        cursor: pointer;
    }

    .m-learnhead .info .courseTxt {
        font-weight: bold;
    }

    .f-fc3,
    .f-fcdark {
        color: #343d42;
    }

    .f-f0,
    .success-modal {
        font-family: "Arial", "Hiragino Sans GB", 微软雅黑, "Helvetica", "sans-serif";
    }

    .info a {
        text-decoration: none;
    }

    .m-learnhead .comment_link {
        color: #00c758;
        cursor: pointer;
        padding-top: 10px;
    }

    .m-learnhead .comment {
        font-size: 14px;
        margin-right: 40px;
    }

    ._1d3mQ .QsUtY {
        color: #00c758;
        padding-top: 10px;
        font-size: 14px;
        padding-left: 10px;
    }

    .learn-hours-first-see {
        position: relative;
    }

    .f-fr {
        float: right;
    }

    .m-learnhead .learn-hours {
        height: 40px;
        line-height: 38px;
        margin-right: 40px;
    }

    a.f-fcgreen {
        color: #00c758;
    }

    ._1Zv-- span {
        font-size: 13px;
        color: #859295;
        padding-left: 6px;
    }

    .el-icon-medal-1 {
        color: #FF4000;
        font-size: 24px;
        margin-right: 4px;
    }

    .f-fc6,
    .f-fclight {
        color: #859295;
    }

    .u-cert2 {
        width: auto;
        border-color: #FFDC74;
        background-color: #FDFFD8;
        padding: 0 10px;
    }

    .m-learnhead .u-cert {
        margin: -2px 0 0 30px;
    }

    .f-fl {
        float: left;
    }

    .m-learnhead .info {
        margin-left: 70px;
        padding-left: 40px;
        width: 50%;
        border-left: 1px solid #ccc;
    }

    .m-learnhead .schoolImg {
        padding-left: 70px;
    }

    .m-learnhead {
        background-color: #f8f8f8;
        border: 1px solid #ddd;
        padding: 10px 0;
        height: 45px;
    }

    #g-body {
        padding-bottom: 0;
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
        line-height: 1.4;
    }

    .m-cbg {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        background-color: #fff;
        z-index: -1;
        -webkit-box-shadow: -1px 0px 2px rgba(0, 0, 0, 0.1);
        box-shadow: -1px 0px 2px rgba(0, 0, 0, 0.1);
    }
</style>