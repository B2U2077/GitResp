<template>
    <div id="divTeacher">
        <h1>教师信息</h1>
        <div style="padding: 20px;">
            <el-input v-model="teacher.scName" placeholder="请输入要查询的学校名称" style="width: 300px;"
                prefix-icon="el-icon-search"></el-input>
            <el-input v-model="teacher.tName" placeholder="请输入要查询的教师姓名" style="width: 300px;"
                prefix-icon="el-icon-search"></el-input>
            <el-button type="warning" plain style="margin-left: 10px;width: 100px;" @click="teacherSearch()">查询
            </el-button>
        </div>
        <div class="divTable">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column fixed prop="tid" label="教师序号" width="150">
                </el-table-column>
                <el-table-column prop="tname" label="教师姓名" width="120">
                </el-table-column>
                <el-table-column prop="tgender" label="教师性别" width="120">
                </el-table-column>
                <el-table-column prop="scName" label="所属学校" width="120">
                </el-table-column>
                <el-table-column prop="tinfo" label="教师简介" width="120">
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
        name: 'Teacherinfo',
        data() {
            return {
                pageInfo: {
                    total: 0,   //当前
                    current: 1,    //当前页
                    size: 5,
                    pageSizes: [5, 10, 20, 50, 100]   //分页大小
                },
                dialog: false,  //判断弹出抽屉标志
                loading: false,
                formLabelWidth: '80px',
                tableData: [],
                teacher: {
                    tId: null,
                    tName: null,
                    tGender: null,
                    tInfo: null,
                    scName: null,   //学校名称
                },
                timer: null,
            };
        },
        mounted() {
            this.teacherSearch();
        },
        methods: {
            handleSizeChange(val) {
                this.pageInfo.size = val;
                console.log(`每页 ${val} 条`);
                this.teacherSearch();
            },
            handleCurrentChange(val) {
                this.pageInfo.current = val;
                this.teacherSearch();
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
            teacherSearch() {
                if (this.teacher.scName === '') {
                    this.teacher.scName = null;
                }
                if(this.teacher.tName === '') {
                    this.teacher.tName = null;
                }
                let page = this.pageInfo;
                let dto = this.teacher;

                let data = { page, dto };
                this.$axios.post("http://127.0.0.1:8001/study/teacher/teachervo", data)
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