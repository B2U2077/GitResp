<template>
    <div class="m-learnbox">
        <div class="m-quizDoing u-learn-modulewidth">
            <div class="u-learn-moduletitle f-cb">
                <h2 class="j-title f-fl">课程《软件工程》结课考试</h2>
                <el-link class="j-backList backbtn f-fr f-fc9"><i class="el-icon-back"></i>返回</el-link>
            </div>
            <div class="j-doing">
                <div class="m-quizDoing">
                    <div class="j-description">
                        一、单选题
                    </div>
                    <div style="text-align: left;" v-for="(item,index) in multipleList" :key="index">
                        <div class="qTitle">
                            <span>{{item.qindex}}</span>
                            <span>{{item.mtext}}({{item.qscores}}分)</span>
                        </div>
                        <div class="choice">
                            <!-- <el-radio-group v-model="radio"> -->
                                <label><input type="radio" :name="item.manswer" :value="item.moption1" @click="setChoice(item,item.moption1)">A.{{item.moption1}}<br/></input></label>
                                <label><input type="radio" :name="item.manswer" :value="item.moption2" @click="setChoice(item,item.moption2)">B.{{item.moption2}}<br/></input></label>
                                <label><input type="radio" :name="item.manswer" :value="item.moption3" @click="setChoice(item,item.moption3)">C.{{item.moption3}}<br/></input></label>
                                <label><input type="radio" :name="item.manswer" :value="item.moption4" @click="setChoice(item,item.moption4)">D.{{item.moption4}}<br/></input></label>
                            <!-- </el-radio-group> -->
                        </div>
                    </div>
                    <div class="j-description">
                        二、简答题
                    </div>
                    <div style="text-align: left;" v-for="(item2,index2) in shortList" :key="index2">
                        <div class="qTitle">
                            <span>{{item2.qindex}}</span>
                            <span>{{item2.shText}}({{item2.qscores}}分)</span>
                        </div>
                        <div class="choice">
                            <textarea rows="3" cols="20" placeholder="请输入内容" @change="setAnswer(item2)" :id="item2.shId" style="width: 500px;"></textarea>
                        </div>
                    </div>
                    <div style="margin-top: 20px;text-align: left;">
                        <el-button type="primary" @click="subAnswer">提交答案</el-button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import $ from 'jquery'
    export default {
        name: 'Examview',
        data() {
            return {
                radio: '',
                multipleList: [],   //单选题列表
                examId: '1',
                shortList: [],  //简答题列表
                textarea: '',
                multipleData: {},   //选择题答案
                shortData: {},  //简答题答案

            };
        },
        mounted() {
            this.multipleData = new Map();
            this.shortData = new Map();
            console.log("考试考试");
            this.getExam();
        },
        methods: {
            getExam() {
                let suId = localStorage.getItem("suId");
                this.formData = new FormData();
                this.formData.append("suId", suId);
                let url = 'http://127.0.0.1:8001/study/exam/getExamId';

                this.$axios.post(url, this.formData)
                    .then((res) => {
                        console.log(res);
                        this.examId = res.data;
                        this.getMultipleList();
                        this.getShortList();
                    });
            },
            getMultipleList() {     //获取单选题列表
                let eId = this.examId;
                let qType = "单选题";
                let data = {
                    "qexam": eId,
                    "qtype": qType
                }
                let url = 'http://127.0.0.1:8001/study/questionsList/getMultipleList';

                this.$axios.post(url, data)
                    .then((res) => {
                        console.log(res);
                        this.multipleList = res.data;
                    })
            },
            getShortList() {
                let eId = this.examId;
                let qType = "简答题";
                let data = {
                    "qexam": eId,
                    "qtype": qType
                }
                let url = 'http://127.0.0.1:8001/study/shortAnswer/getShortList';
                this.$axios.post(url, data)
                    .then((res) => {
                        console.log(res);
                        this.shortList = res.data;
                    })
            },
            setChoice(item,val) {
                console.log(item);
                //获取分数
                let scores = item.qscores;
                let id = item.mid;
                let answer = item.manswer;

                let data = {
                    qScores: scores,
                    mAnswer: answer,
                    choice: val,
                    mId: id
                };
                this.multipleData.set(id,data);
            },
            subAnswer() {
                let url = 'http://127.0.0.1:8001/study/stuExamInfo';
                let multipleDTOMap = this.multipleData;
                let shortDTOMap = this.shortData;
                let examId = this.examId;
                let suId = localStorage.getItem("suId");
                let id = localStorage.getItem("id");

                let config = {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }

                let data = JSON.stringify({
                    multipleDTOMap: multipleDTOMap,
                    shortDTOMap: shortDTOMap,
                    examId: examId,
                    suId: suId,
                    id: id
                });
            
                this.$axios.post(url,data,config)
                    .then((res) => {
                        console.log(res);
                        this.$message.success("提交成功！");
                        setTimeout(() => {
                            this.$router.push("/classComponents/ClassClaimView");
                        }, 1500);
                    });
            },
            setAnswer(item) {
                let id = "#"+item.shId;
                let text = $(id).val();
                console.log(text);
                let data = {
                    shId: item.shId,
                    answer: item.shAnswer,
                    scores: item.qscores,
                    text: text
                };
                this.shortData.set(item.shId,data);
            }
        },
    };
</script>

<style scoped>
    .qTitle {
        margin-top: 20px;
    }

    .choice {
        margin-top: 10px;
    }

    .el-radio {
        display: block;
        line-height: 23px;
        white-space: normal;
        margin-right: 0;
        padding-top: 5px;
    }

    h2 {
        font-family: "Arial";
        line-height: 1.5;
        font-weight: normal;
        font-size: 22px;
    }

    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
    }

    .u-learn-modulewidth {
        width: 780px;
    }

    .f-cb,
    .g-container {
        zoom: 1;
    }

    .u-learn-moduletitle {
        border: 0;
        padding: 10px 0;
        margin-bottom: 20px;
    }

    .f-fl {
        float: left;
    }

    .m-learnbox .u-learn-moduletitle .backbtn {
        color: #00c758;
    }

    .m-quizDoing .warnTip,
    .m-quizScore .warnTip {
        color: #ff4000;
    }

    .f-dn {
        display: none;
    }

    .j-description {
        margin-top: 60px;
        text-align: left;
        font-size: 20px;
    }
</style>