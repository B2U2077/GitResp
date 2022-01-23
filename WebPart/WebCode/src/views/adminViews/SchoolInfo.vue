<template>
    <div id="divSchool">
        <h1>学校信息</h1>
        <div style="padding: 20px;">
            <el-input v-model="school.scName" placeholder="请输入要查询的学校名字" style="width: 300px;"
                prefix-icon="el-icon-search"></el-input>
            <el-button type="warning" plain style="margin-left: 10px;width: 100px;" @click="schoolSearch()">查询
            </el-button>
            <el-button type="warning" plain style="margin-left: 10px;width: 100px;" @click="addSchool()">添加
            </el-button>
        </div>
        <div class="divTable">
            <el-table :data="tableData" style="width: 100%">
                <el-table-column fixed prop="scId" label="学校序号" width="150">
                </el-table-column>
                <el-table-column prop="scName" label="学校名称" width="120">
                </el-table-column>
                <el-table-column prop="vdef1" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef2" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef3" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef4" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef5" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef6" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef7" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef8" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="vdef9" label="学校院校" width="120">
                </el-table-column>
                <el-table-column prop="scStatus" label="学校状态" width="120">
                </el-table-column>
                <el-table-column prop="scInfo" label="学校简介" width="120">
                </el-table-column>
                <el-table-column fixed="right" label="操作" width="100">
                    <template slot-scope="scope">
                        <el-button @click="handleEdit(scope.$index, scope.row)" type="text" size="small">编辑</el-button>
                        <el-button type="text" @click.native.prevent="deleteRow(scope.$index, tableData)" size="small">
                            删除</el-button>
                    </template>
                </el-table-column>

            </el-table>
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                :current-page="pageInfo.current" :page-sizes="pageInfo.pageSizes" :page-size="pageInfo.size"
                layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total"
                style="text-align: right; margin-right: 40px;"></el-pagination>

        </div>

        <!-- 学校信息弹出框 -->
        <el-drawer title="学校信息编辑页" :before-close="handleClose" :visible.sync="dialog" direction="rtl"
            custom-class="demo-drawer" ref="drawer">
            <div class="demo-drawer__content">
                <el-form :model="form" status-icon ref="form" :rules="formRules">
                    <el-form-item prop="vdef10">
                        <el-upload class="avatar-uploader" ref="uploadimg" action="" :show-file-list="false"
                            :on-success="handleAvatarSuccess" :auto-upload="false"
                            accept="image/jepg,image/jpg,image/png" :before-upload="beforeAvatarUpload"
                            :http-request="uploadFile">

                            <img v-if="imageUrl" :src="imageUrl" class="avatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                    </el-form-item>
                    <el-form-item prop="scName">
                        <el-input v-model="form.scName" placeholder="请输入学校名称">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef1">
                        <el-input v-model="form.vdef1" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef2">
                        <el-input v-model="form.vdef2" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef3">
                        <el-input v-model="form.vdef3" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef4">
                        <el-input v-model="form.vdef4" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef5">
                        <el-input v-model="form.vdef5" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef6">
                        <el-input v-model="form.vdef6" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef7">
                        <el-input v-model="form.vdef7" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef8">
                        <el-input v-model="form.vdef8" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="vdef9">
                        <el-input v-model="form.vdef9" placeholder="请输入学院">
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="scInfo">
                        <el-input type="textarea" placeholder="请输入学校简介" v-model="form.scInfo" maxlength="150"
                            show-word-limit>
                        </el-input>
                    </el-form-item>
                </el-form>
                <div class="demo-drawer__footer">
                    <el-button class="elBtn" type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">提交
                    </el-button>
                    <el-button class="elBtn" @click="cancelForm">取 消</el-button>
                </div>
            </div>
        </el-drawer>
    </div>
</template>

<script>
    import qs from 'qs'

    export default {
        name: 'Schoolinfo',
        data() {
            return {
                isEdit: false,  //是否为编辑状态标志
                imageUrl: '',
                formRules: {    //表单规则

                },
                pageInfo: {
                    total: 0,   //当前
                    current: 1,    //当前页
                    size: 5,
                    pageSizes: [5, 10, 20, 50, 100]   //分页大小
                },
                dialog: false,  //判断弹出抽屉标志
                loading: false,
                tableData: [],
                form: {
                    scName: '',
                    scId: '',
                    scInfo: '',
                    vdef1: '',
                    vdef2: '',
                    vdef3: '',
                    vdef4: '',
                    vdef5: '',
                    vdef6: '',
                    vdef7: '',
                    vdef8: '',
                    vdef9: '',
                    vdef10: '',
                },
                formLabelWidth: '80px',
                timer: null,
                school: {
                    scName: null
                },
                formData: '',
            };
        },
        mounted() {
            this.schoolSearch();
        },
        methods: {
            addSchool() {
                this.isEdit = false;
                this.dialog = true;
            },
            uploadFile(file) {
                this.formData.append('file', file.file);
            },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isLt2M;
            },
            handleSizeChange(val) {
                this.pageInfo.size = val;
                console.log(`每页 ${val} 条`);
                this.schoolSearch();
            },
            handleCurrentChange(val) {
                this.pageInfo.current = val;
                this.schoolSearch();
                console.log(`当前页: ${val}`);
            },
            handleEdit(index, row) {    //编辑学校信息
                console.log(index, row);
                this.form = row;
                this.imageUrl = row.vdef10;
                this.isEdit = true;
                this.dialog = true;
            },
            deleteRow(index, row) {
                console.log(index, row);
                let scId = row[index].scId;
                this.$axios.delete("http://127.0.0.1:8001/study/school", {
                    params: {
                        scId: scId
                    }
                })
                    .then((res) => {
                        console.log(res);
                        let flag = res.data.msg;
                        if (flag === '执行成功') {
                            row.splice(index, 1);
                        }
                    });
            },
            handleClose(done) {     //提交学校表单
                if (this.loading) {
                    return;
                }


                this.formData = new FormData();
                this.$refs.uploadimg.submit();
                this.formData.append('scId', this.form.scId);
                this.formData.append('scName', this.form.scName);
                this.formData.append('vdef1', this.form.vdef1);
                this.formData.append('vdef2', this.form.vdef2);
                this.formData.append('vdef3', this.form.vdef3);
                this.formData.append('vdef4', this.form.vdef4);
                this.formData.append('vdef5', this.form.vdef5);
                this.formData.append('vdef6', this.form.vdef6);
                this.formData.append('vdef7', this.form.vdef7);
                this.formData.append('vdef8', this.form.vdef8);
                this.formData.append('vdef9', this.form.vdef9);
                this.formData.append('scInfo', this.form.scInfo);
                this.formData.append('isEdit',this.isEdit);

                //遍历formData防止传给后台null字符串
                for (var key of this.formData.keys()) {
                        console.log("key:" + key + " value:" + this.formData.get(key));
                        let val = this.formData.get(key);
                        if(val === null || val === 'null') {
                            val = '';
                            this.formData.set(key,val);
                        }
                }

                let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }
                this.$confirm('确定要提交表单吗？')
                    .then(_ => {
                        this.loading = true;
                        this.$axios.post("http://127.0.0.1:8001/study/school", this.formData, config)
                            .then((res) => {
                                console.log(res);
                                if (res.status == '200') {
                                    this.$refs.uploadimg.clearFiles();
                                    console.log("清除已上传文件！");
                                    this.imageUrl = res.data.fileName;
                                }
                            });
                        this.timer = setTimeout(() => {
                            done();
                            // 动画关闭需要一定的时间
                            setTimeout(() => {
                                this.loading = false;
                            }, 400);
                        }, 2000);
                    })
                    .catch(_ => { });
                // this.$refs.form.resetFields();

            },
            cancelForm() {
                this.loading = false;
                this.dialog = false;
                clearTimeout(this.timer);
            },
            schoolSearch() {

                let page = this.pageInfo;
                let school = this.school;
                if (this.school.scName === '') {
                    this.school.scName = null;
                }

                let data = { page, school };
                this.$axios.post("http://127.0.0.1:8001/study/school/schoolVo", data)
                    .then((res) => {
                        this.tableData = res.data.data.records;
                        this.pageInfo.size = res.data.data.size;
                        this.pageInfo.total = res.data.data.total;
                        this.pageInfo.current = res.data.data.current;

                    });
            }
        },
    };
</script>

<style scoped>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }

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