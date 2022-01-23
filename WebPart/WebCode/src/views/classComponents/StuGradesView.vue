<template>
    <div class="m-learnbox">
        <div class="m-quizDoing u-learn-modulewidth">
            <div class="u-learn-moduletitle f-cb" style="height: 40px;">
                <h2 class="j-title f-fl">课程《{{suName}}》考试成绩</h2><a class="j-backList backbtn f-fr f-fc9"
                    id="auto-id-1620091103101"><i class="el-icon-back"></i>返回</a>
            </div>
            <div>
                <div>
                    <el-table :data="tableData" style="width: 100%">
                        <el-table-column fixed prop="stuName" label="学生姓名" width="150">
                        </el-table-column>
                        <el-table-column prop="suName" label="课程名称" width="120">
                        </el-table-column>
                        <el-table-column prop="tname" label="教师姓名" width="120">
                        </el-table-column>
                        <el-table-column prop="ename" label="考试名称" width="120">
                        </el-table-column>
                        <el-table-column prop="sgScores" label="考试成绩" width="120">
                        </el-table-column>
                    </el-table>
                    <div style="margin-top: 20px;">
                        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                        :current-page="pageInfo.current" :page-sizes="pageInfo.pageSizes" :page-size="pageInfo.size"
                        layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total"
                        style="text-align: right; margin-right: 40px;"></el-pagination>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Stugradesview',
    data() {
        return {
            suName: null,   //课程名称
            pageInfo: { //分页对象
                total: 0,   //当前
                current: 1,    //当前页
                size: 5,
                pageSizes: [5, 10, 20, 50, 100]   //分页大小
            },
            tableData:[]    //表格数据

        };
    },
    mounted() {
        this.suName = localStorage.getItem("suName");
        this.getAllList();
    },
    methods: {
        getAllList() {
            let url = 'http://127.0.0.1:8001/study/stuGrades/getAllList';
            let suId = localStorage.getItem("suId");
            let page = this.pageInfo;
            let data = {
                page,suId
            };
            
            this.$axios.post(url,data)
                .then((res) => {
                    console.log(res);
                    this.pageInfo.size = res.data.size;
                    this.pageInfo.total = res.data.total;
                    this.pageInfo.current = res.data.current;
                    this.tableData = res.data.records;
                })
        },
        handleSizeChange(val) {
            this.pageInfo.size = val;
            console.log(`每页 ${val} 条`);
            this.getAllList();
        },
        handleCurrentChange(val) {
            this.pageInfo.current = val;
            this.getAllList();
            console.log(`当前页: ${val}`);
        },
    },
};
</script>

<style scoped>
    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
        height: 500px;
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
</style>