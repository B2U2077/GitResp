<template>
    <div class="m-learnbox">
        <div class="m-quizDoing u-learn-modulewidth">
            <div class="u-learn-moduletitle f-cb" style="height: 40px;">
                <h2 class="j-title f-fl">课程《{{suName}}》结课考试</h2><a class="j-backList backbtn f-fr f-fc9"
                    id="auto-id-1620091103101"><i class="el-icon-back"></i>返回</a>
            </div>
            <div v-if="flag">
                <div class="j-prepare prepare">
                    <div class="m-beforeTest">
                        <div class="j-baseInfo baseInfo f-f0" style="text-align: left;margin-top: 40px;">
                            <p>本次考试仅有一次作答机会，共 <span><em>20</em></span> 道题，总分 <span><em>100</em> </span></p>考试总时长：<span>
                                <em>150</em>分钟</span>
                        </div>
                        <div class="details">
                            <p class="important f-f0">建议您认真完成所有题目后提交试卷</p>
                            <p class="pc">1. 您需要一次性作答并提交，答题过程中不要切换或关闭页面，一旦开启考试，倒计时将不会停止。</p>
                            <p class="pc">2. 答题时请关闭聊天工具、视频等其他无关的软件和工具，避免影响您本次答题。</p>
                            <p class="pc">3. 请在页面上确认考试提交成功再离开考试</p>
                            <p class="pc">4. 考试成绩会在稍后公布，请密切关注公告或消息提醒</p>
                            <p class="pc">5. 根据考试相关规定以及证书要求，在答题前签署考试协议</p>
                        </div>
                        <div style="text-align: left;">
                            <el-radio v-model="radio1" label="1" border>依照学术诚信条款，我保证此考试是本人独立完成的。</el-radio>
                        </div>
                        <div style="text-align: left;margin-top: 20px;">
                            <router-link to="/classComponents/ExamView">
                                <el-button type="success">开始考试</el-button>
                            </router-link>
                        </div>
                    </div>
                </div>
                <div class="j-doing f-dn"></div>
                <div class="j-waitForScore waitForScore f-cb f-dn"></div>
            </div>
            <div v-else>
                <div class="crtBtn">
                    <el-button type="success" @click="examDialog = true">创建考试</el-button>
                </div>
                <div>
                    <el-table :data="tableData" style="width: 100%">
                        <el-table-column fixed prop="eid" label="考试编号" width="150">
                        </el-table-column>
                        <el-table-column prop="ename" label="课程名称" width="120">
                        </el-table-column>
                        <el-table-column fixed="right" label="操作" width="100">
                            <template slot-scope="scope">
                                <el-button @click="handleEdit(scope.$index, scope.row)" type="text" size="small">编辑</el-button>
                                <el-button type="text" @click.native.prevent="deleteRow(scope.$index, scope.row)" size="small">
                                    删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                        :current-page="pageInfo.current" :page-sizes="pageInfo.pageSizes" :page-size="pageInfo.size"
                        layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total"
                        style="text-align: right; margin-right: 40px;"></el-pagination>
                </div>
            </div>

            <!-- 创建考试对话框 -->
            <el-dialog title="创建考试" :visible.sync="examDialog">
                <el-form :model="examForm">
                    <el-form-item label="课程名称" :label-width="formLabelWidth">
                        <el-input type="input" placeholder="请输入课程名称" v-model="examForm.ename">
                        </el-input>
                    </el-form-item>

                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="examDialog = false">取 消</el-button>
                    <el-button type="primary" @click="examSub">确 定</el-button>
                </div>
            </el-dialog>

            <el-drawer title="考试信息编辑" :before-close="handleClose" :visible.sync="dialog" direction="rtl"
                custom-class="demo-drawer" ref="drawer">
                <div class="demo-drawer__content">
                    <el-form :model="questionForm" status-icon ref="questionForm">
                        <el-form-item prop="qindex">
                            <el-input v-model="questionForm.qindex" placeholder="请输入下标">
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="qscores">
                            <el-input v-model="questionForm.qscores" placeholder="请输入分数">
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="qtype">
                            <el-radio v-model="questionForm.qtype" label="单选题" border>单选题</el-radio>
                            <el-radio v-model="questionForm.qtype" label="简答题" border>简答题</el-radio>
                            <el-button type="primary" @click="innerDrawer = true">添加题目</el-button>
                        </el-form-item>
                        <el-form-item prop="qmultiple" v-if="questionForm.qtype === '单选题'">
                            <el-select v-model="questionForm.qmultiple" placeholder="请选择单选题" style="width: 450px;">
                                <el-option
                                  v-for="(item,index) in multipleList"
                                  :key="index"
                                  :label="item.mtext"
                                  :value="item.mid">
                                </el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item prop="qshort" v-if="questionForm.qtype === '简答题'">
                            <el-select v-model="questionForm.qshort" placeholder="请选择简答题" style="width: 450px;">
                                <el-option
                                  v-for="(item,index) in shortList"
                                  :key="index"
                                  :label="item.shText"
                                  :value="item.shId">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-form>
                    <div class="demo-drawer__footer">
                        <el-button class="elBtn" type="primary" @click="submitQuesList" :loading="loading">提 交
                        </el-button>
                        <el-button class="elBtn" @click="cancelForm">关 闭</el-button>
                    </div>

                    <el-drawer ref="quesdrawer"
                        title="添加题目"
                        :append-to-body="true"
                        :before-close="handleClose2"
                        :visible.sync="innerDrawer">
                        <div v-if="questionForm.qtype === '单选题'">
                            <el-form :model="multipleForm" status-icon ref="multipleForm">
                                <el-form-item prop="mtext">
                                    <el-input v-model="multipleForm.mtext" type="textarea" maxlength="100" show-word-limit placeholder="请输入题目内容">
                                    </el-input>
                                </el-form-item>
                                <el-form-item prop="moption1">
                                    <el-input v-model="multipleForm.moption1" type="textarea" maxlength="100" show-word-limit placeholder="请输入选项">
                                    </el-input>
                                </el-form-item>
                                <el-form-item prop="moption2">
                                    <el-input v-model="multipleForm.moption2" type="textarea" maxlength="100" show-word-limit placeholder="请输入选项">
                                    </el-input>
                                </el-form-item>
                                <el-form-item prop="moption3">
                                    <el-input v-model="multipleForm.moption3" type="textarea" maxlength="100" show-word-limit placeholder="请输入选项">
                                    </el-input>
                                </el-form-item>
                                <el-form-item prop="moption4">
                                    <el-input v-model="multipleForm.moption4" type="textarea" maxlength="100" show-word-limit placeholder="请输入选项">
                                    </el-input>
                                </el-form-item>
                                <el-form-item prop="manswer">
                                    <el-input v-model="multipleForm.manswer" type="textarea" maxlength="100" show-word-limit placeholder="请输入答案">
                                    </el-input>
                                </el-form-item>
                            </el-form>
                        </div>
                        <div v-else>
                            <el-form :model="shortForm" status-icon ref="shortForm">
                                <el-form-item prop="shText">
                                    <el-input v-model="shortForm.shText" type="textarea" maxlength="100" show-word-limit placeholder="请输入题目内容"></el-input>
                                </el-form-item>
                                <el-form-item prop="shAnswer">
                                    <el-input v-model="shortForm.shAnswer" type="textarea" maxlength="100" show-word-limit placeholder="请输入答案"></el-input>
                                </el-form-item>
                            </el-form>
                        </div>
                        <el-button class="elBtn" type="primary" @click="questionSubmit">提 交
                        </el-button>
                        <el-button class="elBtn" @click="innerDrawer = false">关 闭</el-button>
                    </el-drawer>
                </div>
            </el-drawer>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Classexamview',
        data() {
            return {
                suName: null,   //课程名字
                innerDrawer: false,    //添加题目标志
                loading: false,
                examDialog: false,  //创建考试对话框标志
                radio1: '',
                flag: true, //判断当前用户身份的标志
                examForm: { //考试
                    eteacher: null,
                    ename: null,
                    esubject: null,
                    eid: null,
                },
                formLabelWidth: '120px',
                tableData: [],  //考试表格数据
                exam: { //考试
                    esubject: null,
                },
                pageInfo: { //分页对象
                    total: 0,   //当前
                    current: 1,    //当前页
                    size: 5,
                    pageSizes: [5, 10, 20, 50, 100]   //分页大小
                },
                dialog: false,
                questionForm: { //题目类型表数据
                    qid: null,
                    qindex: null,
                    qscores: null,
                    qtype: '单选题',
                    qmultiple: null,
                    qshort: null,
                    qexam: null
                },
                multipleList: [],   //单选题列表
                shortList: [],      //简答题列表
                multipleForm: { //单选题表单
                    mtext: null,
                    moption1: null,
                    moption2: null,
                    moption3: null,
                    moption4: null,
                    manswer: null,
                },
                shortForm: {    //简答题表单
                    shText: null,
                    shAnswer: null,
                },
            };
        },
        mounted() {
            let id = localStorage.getItem("character");
            this.suName = localStorage.getItem("suName");
            if (id === '教师') {
                this.flag = false;
                //给考试表单赋值
                let tid = localStorage.getItem("id");
                //老师id
                this.examForm.eteacher = tid;
                //课程编号
                let suId = localStorage.getItem("suId");
                this.examForm.esubject = suId;
                this.exam.esubject = suId;
                this.showExamList();
            } else {
                this.flag = true;
            }
        },
        methods: {
            examSub() { //提交创建考试表单
                console.log("提交创建考试表单");
                let url = 'http://127.0.0.1:8001/study/exam';
                this.$axios.post(url,this.examForm)
                    .then((res) => {
                        console.log(res);
                        this.examForm.eId = res.data.eId;
                    });
                this.examDialog = false;
                this.showExamList();
            },  
            handleEdit(index,row) { //表格编辑方法
                console.log("编辑考试");
                console.log(row);
                this.questionForm.qexam = row.eid;
                this.dialog = true;
                this.showMultipleList();
                this.showShortList();
            },
            deleteRow(index,row) {  //表格删除方法
                console.log("删除考试");
                console.log(row);
            },
            showExamList() {    //显示考试表格方法
                let page = this.pageInfo;
                let exam = this.exam;
                let data = {page,exam};
                let url = 'http://127.0.0.1:8001/study/exam/showList';

                this.$axios.post(url,data)
                    .then((res) => {
                        console.log(res);
                        this.tableData = res.data.data.records;
                        this.pageInfo.size = res.data.data.size;
                        this.pageInfo.total = res.data.data.total;
                        this.pageInfo.current = res.data.data.current;
                    });
            },
            handleSizeChange(val) {
                this.pageInfo.size = val;
                console.log(`每页 ${val} 条`);
                this.showExamList();
            },
            handleCurrentChange(val) {
                this.pageInfo.current = val;
                this.showExamList();
                console.log(`当前页: ${val}`);
            },
            handleClose() {
                this.dialog = false;
            },
            cancelForm() {
                this.loading = false;
                this.dialog = false;
                clearTimeout(this.timer);
            },
            handleClose2() {
                this.innerDrawer = false;
            },
            questionSubmit() {
                let f = this.questionForm.qtype;
                let url = '';
                let data = {};
                if(f === '单选题') {
                    url = 'http://127.0.0.1:8001/study/multipleChoice';
                    data = this.multipleForm;
                    
                } else if(f === '简答题') {
                    url = 'http://127.0.0.1:8001/study/shortAnswer';
                    data = this.shortForm; 
                    
                }
                //发送请求
                this.$axios.post(url,data)
                    .then((res) => {
                        console.log(res);
                        this.$message.success("添加成功");
                    });
                this.innerDrawer = false;
                if(f === '单选题') {
                    this.$refs.multipleForm.resetFields();
                    this.showMultipleList();
                } else if(f === '简答题') {
                    this.$refs.shortForm.resetFields();
                    this.showShortList();
                }
            },
            submitQuesList() {
                let url = 'http://127.0.0.1:8001/study/questionsList';
                let data = this.questionForm;
                this.$axios.post(url,data)
                    .then((res) => {
                        console.log(res);
                        this.$message.success("添加成功");
                    });
                this.$refs.questionForm.resetFields();
            },
            showMultipleList() {    //显示所有的单选题
                let url = 'http://127.0.0.1:8001/study/multipleChoice/getList';
                let data = {};
                this.$axios.post(url,data)
                    .then((res) => {
                        console.log(res);
                        this.multipleList = res.data;
                    });
            },
            showShortList() {   //显示所有的简答题
                let url = 'http://127.0.0.1:8001/study/shortAnswer/getList';
                let data = {};
                this.$axios.post(url,data)
                    .then((res) => {
                        console.log(res);
                        this.shortList = res.data;
                    });
            }
        },
    };
</script>

<style scoped>
    .elBtn {
        width: 200px;
    }
    .crtBtn {
        text-align: left;
    }
    .pc {
        font-size: 12px;
    }

    .m-beforeTest .details .important {
        margin: 18px 0 5px;
        font-size: 15px;
        color: #333;
    }

    .m-beforeTest .details {
        line-height: 22px;
        margin: 0 0 20px;
        text-align: left;
    }

    .m-beforeTest .baseInfo span em {
        font-size: 18px;
    }

    .m-beforeTest .baseInfo span {
        color: #ff3f04;
    }

    .f-f0,
    .success-modal {
        font-family: "Arial", "Hiragino Sans GB", 微软雅黑, "Helvetica", "sans-serif";
    }

    .m-beforeTest .baseInfo {
        padding: 8px 12px;
        font-size: 14px;
        margin: 0 0 8px;
        color: #333;
        background-color: #feffd1;
        line-height: 23px;
    }

    .m-beforeTest {
        color: #666;
        padding: 0 0 30px;
    }

    .f-fr {
        float: right;
    }

    .u-learn-moduletitle .backbtn {
        margin: 8px 0 0;
        color: #999;
        cursor: pointer;
    }

    .m-learnbox .u-learn-moduletitle .backbtn {
        color: #00c758;
    }

    h2 {
        font-size: 20px;
        font-family: "Arial", "Hiragino Sans GB", "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
        line-height: 1.5;
        font-weight: normal;
    }

    .f-fl {
        float: left;
    }

    .u-learn-modulewidth {
        width: 780px;
    }

    .u-learn-moduletitle {
        padding: 10px 0;
        margin-bottom: 20px;
        border-bottom: 1px solid #eee;
        border: 0;
    }

    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
        height: 500px;
    }
</style>