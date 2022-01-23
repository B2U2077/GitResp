<template>
    <div id="login">
        <div id="form_space">
            <div style="text-align:'center'">
                <h1>{{register_title}}</h1>
                <p>{{register_adress}}</p>
            </div>
            <div style="padding:20px">
                <el-form ref="user_form" status-icon :model="user_form" :rules="formRules">
                    <el-form-item prop="character">
                        <el-radio-group v-model="character">
                            <el-radio-button class="el-radio" v-model="character" label="学生" value="学生"></el-radio-button>
                            <el-radio-button class="el-radio" v-model="character" label="教师" value="教师"></el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item prop="stuName">
                        <el-input v-model="user_form.stuName" prefix-icon="el-icon-user"  autocomplete="off"
                            placeholder="请输入用户姓名"></el-input>
                    </el-form-item>
                    <el-form-item prop="stuGender">
                        <el-radio v-model="user_form.stuGender" label="男" border>男</el-radio>
                        <el-radio v-model="user_form.stuGender" label="女" border>女</el-radio>
                    </el-form-item>
                    <el-form-item prop="stuAccount">
                        <el-input v-model="user_form.stuAccount" prefix-icon="el-icon-user" 
                            placeholder="请输入账号">
                        </el-input>
                    </el-form-item>
                    
                    <el-form-item prop="stuPwd">
                        <el-input v-model="user_form.stuPwd" prefix-icon="el-icon-lock" show-password placeholder="请输入用户密码" ></el-input>
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="stu_password_verify">
                        <el-input v-model="user_form.stu_password_verify" prefix-icon="el-icon-lock" show-password 
                            placeholder="请再次输入用户密码"></el-input>
                    </el-form-item>
                    <el-form-item prop="stu_school_major">
                        <el-cascader v-model="user_form.stu_school_major" placeholder="请选择学校/学院/专业"  style="width: 100%;"
                            :options="selectOptions" @change="handelChange">
                        </el-cascader>
                    </el-form-item>
                    <el-form-item prop="stuMajor" v-if="character === '学生'">
                        <el-input prefix-icon="el-icon-user" v-model="user_form.stuMajor" 
                            placeholder="请输入专业"></el-input>
                    </el-form-item>
                    <el-form-item prop="stuGrade" v-if="character === '学生'">
                        <el-date-picker
                            v-model="user_form.stuGrade"
                            type="year"
                            placeholder="请选择年级" style="width: 100%;" value-format="yyyy">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item prop="stuClass" v-if="character === '学生'">
                        <el-input prefix-icon="el-icon-user" v-model="user_form.stuClass" 
                            placeholder="请输入班级"></el-input>
                    </el-form-item>
                    <el-form-item style="text-align:'center'">
                        <el-button type="success" icon="el-icon-back" @click="register('user_form')">注册</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-link type="primary" style="float:left" @click="to('/login')">登录</el-link>
                        <el-link type="danger" style="float:right" @click="to('/forget/password')">找回密码？</el-link>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            var checkMajor = (rule,value,callback) => {
                if(!value || value === '') {
                    callback(new Error('请输入专业！'));
                } else {
                    callback();
                }
            };
            var checkGender = (rule,value,callback) => {   //检验是否填写性别
                if(!value) {
                    return callback(new Error('请选择性别！'));
                } else {
                    if(this.character === '教师') {
                        this.teacherForm.tgender = value;
                    }
                    callback();
                }
            };

            var checkName = (rule,value,callback) => { //校验姓名
                if(!value || value === '') {
                    callback(new Error('请输入姓名！'));
                } else {
                    if(this.character === '教师') {
                        this.teacherForm.tname = value;
                    }
                    callback();
                }
            };

            var checkPwd = (rule,value,callback) => {  //检验密码
                if(!value || value === '') {
                    callback(new Error('请输入密码！'));
                } else {
                    var reg= /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,30}$/;
                    if(!(reg.test(value))) {
                        callback(new Error("请输入8位以上包含数字、字母、英文符号的密码！"))
                    } else {
                        if(this.character === '教师') {
                            this.teacherForm.tpwd = value;
                        }
                        callback();
                    }
                }
            };
            var checkPwd2 = (rule,value,callback) => {  //检验密码是否一致
                if(!value || value === '') {
                    callback(new Error('请重新输入密码'));
                } else if(value === this.user_form.stuPwd) {
                    callback();
                } else {
                    callback(new Error('两次密码不一致，请重新输入！'))
                }
            };
            var checkSchool = (rule,value,callback) => {     //检验院校
                if(!value || value.length === 0) {
                    callback(new Error('请选择您的院校与专业！'));
                } else {
                    //this.user_form.stuMajor = value[2];
                    this.user_form.stuSchool = value[0];    //学校
                    this.user_form.vdef2 = value[1];    //学院
                    if(this.character === '教师') {
                        this.teacherForm.tschool = value[0];
                        this.teacherForm.vdef2 = value[1];
                    }
                    callback();
                }
            };
            var checkGrade = (rule,value,callback) => {     //检验年级
                if(!value || value === '') {
                    callback(new Error('请选择您的年级！'));
                } else {
                    callback();
                }
            };
            var checkClazz = (rule,value,callback) => {     //检验班级
                if(!value || value === '') {
                    callback(new Error('请输入您的班级！'));
                } else {
                    callback();
                }
            }
            var checkAccount = (rule,value,callback) => {
                if(!value || value === '') {
                    callback(new Error('请输入您的账号！'));
                } else {
                    var reg = /^[a-zA-Z0-9]{8,20}$/;
                    if(!reg.test(value)) {
                        callback(new Error('请输入8位以上数字加字母组合的字符串！'));
                    } else {
                        this.user_form.vdef1 = value;
                        if(this.character === '教师') {
                            this.teacherForm.vdef1 = value;
                        }
                        callback();
                    }
                }
            }
            return {
                teacherForm: {  //教师
                    tgender: '',
                    tname: '',
                    tpwd: '',
                    tschool: '',
                    vdef1: '',  //账号
                    vdef2: '',  //学院
                },
                character: '学生',  //注册角色选择
                formRules: {   //表单规则
                    stuName: [
                        {validator: checkName,trigger: 'blur'}
                    ],
                    stuGender: [
                        {validator: checkGender,trigger: 'blur'}
                    ],
                    stuPwd: [
                        {validator: checkPwd,trigger: 'blur'}
                    ],
                    stu_password_verify: [
                        {validator: checkPwd2,trigger: 'blur'}
                    ],
                    stu_school_major: [
                        {validator: checkSchool,trigger: 'blur'}
                    ],
                    stuGrade: [
                        {validator: checkGrade,trigger: 'blur'}
                    ],
                    stuClass: [
                        {validator: checkClazz,trigger: 'blur'}
                    ],
                    stuAccount: [
                        {validator: checkAccount,trigger: 'blur'}
                    ]
                },
                register_title: "用户注册",
                register_adress: "加入我们，无限进步！",
                verify_button_data: {
                    button_title: "获取验证码",
                    button_state: false,
                },
                user_form: {
                    stuName: "",  //姓名
                    stuAccount: "",   //账号
                    stuPwd: "",  //密码
                    stu_password_verify: "",   //二次验证密码
                    stu_school_major: [],  //院校-专业 选择器
                    stuGrade: "",     //年级
                    stuClass: "",     //班级
                    stuGender: "男",   //默认性别
                    stuSchool: '',  //学校
                    stuMajor: '',   //专业
                    vdef1: '',  //账号
                    vdef2: '',  //学院
                },
                remember_password: false,
                selectOptions: [
                    {
                        value: '1',
                        label: '湖南工学院',
                        children: [
                            {
                                value: '计算机信息与科学学院',
                                label: '计算机信息与科学学院'
                            },{
                                value: '机械工程学院',
                                label: '机械工程学院'
                            }
                        ]
                    }
                ]

            };
        },
        methods: {
            register(formName) {    //注册
                
                //调用验证方法，若验证方法正确则使用
                this.$refs.user_form.validate((valid) => {
                    if(valid) {
                        this.$message.success("注册成功！");

                        let data = {};
                        let url = '';
                        let character = this.character;
                        if(character === '学生') {
                            url = "http://127.0.0.1:8001/study/student";
                            data = this.user_form;
                        } else {
                            url = "http://127.0.0.1:8001/study/teacher";
                            data = this.teacherForm;
                        }
                        // let data = this.user_form;
                        this.$axios.post(url,data)
                            .then((response) => {
                                if(response.status === 200) {
                                    setTimeout(() => {
                                        this.$router.push("/login");
                                    }, 1500);
                                }
                            }).catch((error) => {
                                console.log(error);
                            })
                    } else {
                        this.$message.error("注册失败！");
                        return false
                    }
                })
            },
            verify_code() {
                this.$message.success("验证码发送成功请您查看邮箱");
                this.verify_button_data.button_title = 60;
                this.verify_button_data.button_state = true;
                this.count_time_down();
            },
            count_time_down() {
                if (this.verify_button_data.button_title != 0) {
                    setTimeout(() => {
                        this.verify_button_data.button_title =
                            this.verify_button_data.button_title - 1;
                        this.count_time_down();
                    }, 1000);
                } else {
                    this.verify_button_data.button_title = "再次获取验";
                    this.verify_button_data.button_state = false;
                }
            },
            to(link) {
                this.$router.push(link);
            },
            handelChange(value) {   //测试
                console.log(value);
            }
        }
    };
</script>
<style scoped>
    h1 {
        color: #060018;
    }

    p {
        color: #060018;
    }

    .alertClass {
        height: 30px;
        font-size: 20px;
        line-height: 20px;
    }

    #login {
        min-height: 100vh;
        /* background-image: url('../../assets/img/CyberLogin3.jpeg'); */
        background: url(../../assets/img/CyberLogin3.jpeg) scroll 100% 100%;
            background-size: auto;
            background-repeat: repeat-y;
        zoom: 1;
        -webkit-background-size: cover;
        -o-background-size: cover;
        height: 1000px;
    }

    #form_space {
        border-radius: 10px;
        position: absolute;
        top: 20px;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        height: 600px;
        width: 400px;
    }
</style>