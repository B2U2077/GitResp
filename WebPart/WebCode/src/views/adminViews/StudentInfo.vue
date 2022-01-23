<template>
    <div id="divStudent">
        <h1>学生信息</h1>
        <div style="padding: 20px;">
            <el-input v-model="student.stuSchool" placeholder="请输入要查询的学校名称" style="width: 300px;"
                prefix-icon="el-icon-search"></el-input>
            <el-input v-model="student.scName" placeholder="请输入要查询的学生姓名" style="width: 300px;"
                prefix-icon="el-icon-search"></el-input>
            <el-button type="warning" plain style="margin-left: 10px;width: 100px;" @click="studentSearch()">查询
            </el-button>
        </div>
        <div class="divTable">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column fixed prop="stuId" label="学生序号" width="150">
                </el-table-column>
                <el-table-column prop="stuName" label="学生姓名" width="120">
                </el-table-column>
                <el-table-column prop="stuGender" label="学生性别" width="120">
                </el-table-column>
                <el-table-column prop="scName" label="所在学校" width="120">
                </el-table-column>
                <el-table-column prop="stuMajor" label="所在专业" width="120">
                </el-table-column>
                <el-table-column prop="stuGrade" label="所在年级" width="120">
                </el-table-column>
                <el-table-column prop="stuClass" label="所在班级" width="120">
                </el-table-column>
                <el-table-column fixed="right" label="操作" width="120">
                    <template slot-scope="scope">
                        <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">
                            删除
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                :current-page="pageInfo.current" :page-sizes="pageInfo.pageSizes" :page-size="pageInfo.size"
                layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total"
                style="text-align: right; margin-right: 40px;"></el-pagination>

        </div>

    </div>
</template>

<script>
    export default {
        name: 'Studentinfo',
        data() {
            return {
                pageInfo: {
                    total: 0,   //当前
                    current: 1,    //当前页
                    size: 5,
                    pageSizes: [5, 10, 20, 50, 100]   //分页大小
                },
                student: {
                    stuId: null,
                    stuGender: null,
                    stuName: null,
                    scName: null,
                    stuMajor: null,
                    stuGrade: null,
                    stuClass: null,

                },
                tableData: [],

            };
        },
        mounted() {
            this.studentSearch();
        },
        methods: {
            handleSizeChange(val) {
                this.pageInfo.size = val;
                console.log(`每页 ${val} 条`);
                this.studentSearch();
            },
            handleCurrentChange(val) {
                this.pageInfo.current = val;
                this.studentSearch();
                console.log(`当前页: ${val}`);
            },
            handleEdit(index, row) {
                console.log(index, row);
                this.dialog = true;

            },
            deleteRow(index, rows) {
                console.log(index,rows);
                let tid = rows[index].tid;
                this.$axios.delete("http://127.0.0.1:8001/study/teacher",{
                    params: {
                        tid: tid
                    }
                }).then((res) => {
                    console.log(res);
                    let flag = res.data.msg;
                    if(flag === '执行成功') {
                        rows.splice(index, 1);
                    }
                });
            },
            cancelForm() {
                this.loading = false;
                this.dialog = false;
                clearTimeout(this.timer);
            },
            studentSearch() {
                if (this.student.scName === '') {
                    this.student.scName = null;
                }
                if(this.student.tName === '') {
                    this.student.tName = null;
                }
                let page = this.pageInfo;
                let dto = this.student;

                let data = { page, dto };
                this.$axios.post("http://127.0.0.1:8001/study/student/stuvo", data)
                    .then((res) => {
                        this.tableData = res.data.records;
                        this.pageInfo.size = res.data.size;
                        this.pageInfo.total = res.data.total;
                        this.pageInfo.current = res.data.current;

                    });
            }
        },
    };
</script>

<style scoped>
    .elBtn {
        width: 200px;
    }

    .demo-drawer__content {
        display: flex;
        flex-direction: column;
        height: 100%;
    }

    .divTable {
        background-color: #fff;
        text-align: left;
    }

    h1 {
        font-size: 30px;
    }
</style>