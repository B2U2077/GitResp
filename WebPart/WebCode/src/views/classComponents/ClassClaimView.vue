<template>
    <div id="courseLearn-inner-box" class="m-learnbox">
        <div class="m-notice f-cb">
            <div class="left-mn">
                <div class="left-mnc f-cb">
                    <div class="progress f-cb j-progressbar">
                        <div style="height: 75px">
                            <div class="cnt f-f0">
                                <h3>亲爱的{{userName}}，欢迎回来~，</h3>
                                <p class="tnt">
                                    好好学习，天天向上！
                                </p>
                            </div>
                            <span v-if='roleFlag'>
                                <el-button class="btnContinue" type="primary" @click="to('/classComponents/ClassVideoView')"
                                    v-if="flag === 'continue'">继续学习</el-button>
                                <el-button class="btnContinue" type="primary" @click="attendClass"
                                    v-else-if="flag === 'attend'">立即参加</el-button>
                            </span>
                            <span v-else>
                                <el-button class="btnContinue" type="primary" @click="dialogFormVisible = true">发布公告</el-button>
                            </span>
                        </div>
                    </div>
                    <!-- 发布课程表单 -->
                    <el-dialog title="发布公告" :visible.sync="dialogFormVisible">
                        <el-form :model="announceForm">
                            <el-form-item label="课程名称" :label-width="formLabelWidth">
                                <el-input type="textarea" placeholder="请输入公告内容" v-model="announceForm.aannouncement"
                                    maxlength="100" show-word-limit>
                                </el-input>
                            </el-form-item>

                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="dialogFormVisible = false">取 消</el-button>
                            <el-button type="primary" @click="AnnounceSubmit">确 定</el-button>
                        </div>
                    </el-dialog>

                    <h2 class="u-learn-moduletitle j-moduleName">公告</h2>
                    <el-divider></el-divider>
                    <div class="f-richEditorText" style="display: block;" v-for="(announceItem,index) in announceList"
                        :key='index'>
                        <p>
                        <div style="color: rgb(255, 122, 62);">
                            <strong>
                                {{announceItem.aannouncement}}
                            </strong>
                        </div>
                        <div class="lptimeout">
                            <div class="divTeam">{{announceItem.tname}}&nbsp;&nbsp;&nbsp;{{announceItem.adate}}</div>
                        </div>
                        </p>
                        <el-divider><i class="el-icon-message-solid"></i></el-divider>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Classclaimview',
        data() {
            return {
                announceForm: {  //公告表单内容
                    asubject: null,    //课程编号
                    aannouncement: '',  //公告内容
                    ateacher: null,    //发布人
                },
                formLabelWidth: '120px',
                dialogFormVisible: false,   //发布公告弹窗标志
                flag: '',    //判断教师、学生标志
                userName: "朋友",
                announceList: [],   //公告列表
                selectData: '',     //钩子函数中查询方法的参数
                userClassForm: {    //用户课程关系表表单
                    ucSub: null,
                    ucType: null,
                    ucStu: null,
                    ucTeacher: null,
                },
                roleFlag: true,
            };
        },
        mounted() {
            console.log("公告");
            this.announceForm.asubject = localStorage.getItem("suId");
            this.findRole();

            this.showAnnounceList();
        },
        methods: {
            to(url) {
                this.$router.push(url);
            },
            AnnounceSubmit() {
                console.log("发布公告");
                let tid = localStorage.getItem("id");
                this.announceForm.ateacher = tid;
                let data = this.announceForm;
                let url = 'http://127.0.0.1:8001/study/annList';

                this.$axios.post(url, data)
                    .then((res) => {
                        console.log(res);
                    });
                this.dialogFormVisible = false;
                this.showAnnounceList();
            },
            showAnnounceList() {
                //将所有的公告根据日期列举出来
                let suId = localStorage.getItem("suId");
                this.formData = new FormData();
                this.formData.append("suId", suId);
                let url = "http://127.0.0.1:8001/study/annList/showList";
                this.$axios.post(url, this.formData)
                    .then((res) => {
                        console.log(res);
                        this.announceList = res.data;
                        console.log(this.announceList);
                    });

            },
            attendClass() { //参加课程
                let url = 'http://127.0.0.1:8001/study/userClass';
                let role = localStorage.getItem("character");
                this.userClassForm.ucType = role;
                this.userClassForm.ucSub = localStorage.getItem("suId");
                this.userClassForm.ucStu = localStorage.getItem("id");

                this.$axios.post(url,this.userClassForm)
                    .then((res) => {
                        console.log(res);
                    });
                this.$message.success("参加成功！");
                this.findRole();
            },
            findRole() {    //根据数据查询表中信息
                let role = localStorage.getItem("character");
                let url = 'http://127.0.0.1:8001/study/userClass/getOne';
                let id = localStorage.getItem("id");
                let suId = localStorage.getItem("suId");

                this.selectData = new FormData();
                this.selectData.append("id", id);
                this.selectData.append("role", role);
                this.selectData.append("suId", suId);

                this.$axios.post(url, this.selectData)
                    .then((res) => {
                        console.log(res);
                        if (res.data) {
                            this.flag = "continue";
                        } else {
                            this.flag = "attend";
                        }
                    });

                if (role === '教师') {
                    this.roleFlag = false;
                } else {
                    this.roleFlag = true;
                }
            }
        },
    };
</script>

<style scoped>
    .divTeam {
        float: right;
        font-size: 15px;
    }

    .lptimeout {
        margin-right: 15px;
        margin-top: 2px;
        color: #aaa;
        font-size: 12px;
    }

    .f-richEditorText div {
        word-wrap: break-word;
        white-space: pre-wrap;
    }

    .f-richEditorText p {
        margin: 0;
        padding: 0;
    }

    .f-richEditorText {
        margin-top: 15px;
        color: #666;
        margin: 0;
        margin-top: 0px;
        padding: 0;
        border: 0;
        text-align: left;
        color: #666;
        line-height: 22px;
        word-break: break-word;
        word-wrap: break-word;
        white-space: pre-wrap;
    }

    .btnContinue {
        padding: 11px 14px;
        font-size: 20px;
        line-height: 20px;
        min-width: 110px;
        margin-top: 15px;
        float: right;
    }

    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
        height: 500px;
    }

    .m-notice .left-mn {
        float: left;
        width: 100%;
    }

    .m-notice .left-mnc {
        margin-right: 270px;
        text-align: left;
    }

    .m-notice .progress {
        padding: 8px 20px;
        background: #F8F8F8;
        margin-bottom: 10px;
        margin-top: 15px;
        height: 75px;
    }

    .m-notice .progress .cnt {
        float: left;
        max-width: 500px;
    }

    .f-f0,
    .ban-user-modal {
        font-family: "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
    }

    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    small {
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
        line-height: 1;
        font-weight: normal;
    }

    h3 {
        font-size: 15px;
        font-weight: bold;
    }

    .m-notice .progress .tnt {
        font-size: 14px;
    }
</style>