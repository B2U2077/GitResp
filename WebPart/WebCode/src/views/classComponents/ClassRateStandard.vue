<template>
    <div id="courseLearn-inner-box" class="m-learnbox">
        <div class="u-learn-modulewidth">
            <h2>评分标准</h2>
            <div class="">
                <div class="j-content content f-richEditorText f-f0 edueditor_styleclass_8 edueditor_styleclass_25">
                    <p style="white-space: normal;">
                        <span style="color: rgb(0, 0, 0); font-size: 16px;">1.
                            完成课程全部内容的学习；
                        </span>
                    </p>
                    <p style="white-space: normal;">
                        <span
                            style="color: rgb(0, 0, 0); font-size: 16px;">2、课程《{{suName}}》结课考试共计20个单选题，每题5分；
                        </span>
                    </p>
                    <p style="white-space: normal;">
                        <span style="color: rgb(0, 0, 0); font-size: 16px;">
                            3、结课考试时长为2.5个小时，为开卷考试，可以查阅有关参考资料和英文词典；
                        </span>
                    </p>
                    <p style="white-space: normal;">
                        <span style="color: rgb(0, 0, 0); font-size: 16px;">
                            4、学员结课考试得分50分以上，即合格，即可申请合格证书；80分以上，即可
                            <span style="color: rgb(0, 0, 0); font-size: 16px;">
                                申请
                            </span>优秀证书。
                        </span>
                    </p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Classratestandard',
        data() {
            return {
                suName: null,
            };
        },
        mounted() {
            let name = localStorage.getItem("suName");
            this.suName = name;
        },
        methods: {

        },
    };
</script>

<style scoped>
    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
        height: 500px;
    }
    .u-learn-modulewidth {
        width: 780px;
    }
    .u-learn-moduletitle {
        border: 0;
    }
    .u-learn-moduletitle {
        padding: 10px 0;
        margin-bottom: 20px;
        border-bottom: 1px solid #eee;
    }
    .auto-1618536961403 .content {
        font-size: 14px;
    }
    .f-f0, .ban-user-modal {
        font-family: "Microsoft YaHei", 微软雅黑, "Helvetica", "sans-serif";
    }
    .f-richEditorText {
        margin: 0;
        padding: 0;
        border: 0;
        text-align: left;
        color: #666;
        line-height: 22px;
        word-break: break-word;
        word-wrap: break-word;
        white-space: pre-wrap;
    }
    .f-richEditorText p {
        margin: 0;
        padding: 0;
    }
</style>