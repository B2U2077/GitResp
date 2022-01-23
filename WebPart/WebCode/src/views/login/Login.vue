<template>
    <div id="login">
        <div id="form_space">
            <div style="text-align:'center'">
                <h1>{{login_title}}</h1>
                <p>{{login_adress}}</p>
            </div>
            <div style="padding:20px">
                <el-form ref="login_form" :model="login_form" status-icon :rules="formRules">
                    <el-form-item prop="userName">
                        <el-input v-model="login_form.userName" prefix-icon="el-icon-user" placeholder="请输入账号"></el-input>
                    </el-form-item>
                    <el-form-item prop="userPassword">
                        <el-input v-model="login_form.userPassword" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password>
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="userIdentity">
                        <el-radio-group v-model="login_form.userIdentity">
                            <el-radio-button class="el-radio" v-model="login_form.userIdentity" label="学生" value="学生"></el-radio-button>
                            <el-radio-button class="el-radio" v-model="login_form.userIdentity" label="教师" value="教师"></el-radio-button>
                            <el-radio-button class="el-radio" v-model="login_form.userIdentity" label="管理员" value="管理员"></el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item>
                        <el-checkbox style="color: rgb(252 240 4);" v-model="remember_password">记住密码</el-checkbox>
                    </el-form-item>
                    <el-form-item style="text-align:'center'">
                        <el-button type="primary" icon="el-icon-right" @click="login()">登录</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-link type="danger" style="float:left" @click="to('/register')">注册</el-link>
                        <el-link type="primary" style="float:right" @click="to('/forget/password')">找回密码？</el-link>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            var checkAccount = (rule,value,callback) => {
                if(!value || value === '') {
                    callback(new Error('请输入您的帐号!'));
                } else {
                    callback();
                }
            }
            var checkPwd = (rule,value,callback) => {
                if(!value || value === '') {
                    callback(new Error('请输入您的密码！'));
                } else {
                    callback();
                }
            }
            var checkRole = (rule,value,callback) => {
                if(!value || value === '') {
                    callback(new Error('请选择您的身份！'));
                } else {
                    callback();
                }
            }
            return {
                formRules: {    //表单的验证规则
                    userName: [
                        {validator: checkAccount, trigger: 'blur'}
                    ],
                    userPassword: [
                        {validator: checkPwd,trigger: 'blur'}
                    ],
                    userIdentity: [
                        {validator: checkRole, trigger: 'blur'}
                    ]
                },
                login_title: "赛博在线教育平台",
                login_adress: "Wake UP ! Samurai",
                login_form: {
                    userName: "",   //账号 
                    userPassword: "",   //密码
                    userIdentity: "",   //身份
                },
                remember_password: false,
            };
        },
        methods: {
            login() {
                //调用表单验证方法
                this.$refs.login_form.validate((valid) => {
                    if(valid) {
                        let data = this.login_form;
                        this.$axios.post("http://127.0.0.1:8001/study/user",data)
                                    .then((response) => {
                                        let flag = response.data;
                                        console.log(response.data);
                                        if(flag) {
                                            let id = response.data.id;
                                            localStorage.setItem("userName", this.login_form.userName);
                                            localStorage.setItem("userPwd", this.login_form.userPassword);
                                            localStorage.setItem("character",this.login_form.userIdentity);
                                            localStorage.setItem("id",id);
                                            this.$message.success("登录成功");
                                            if(this.login_form.userIdentity === '管理员') {
                                                setTimeout(() => {
                                                    this.$router.push("/adminHome");
                                                }, 1500);
                                            } else {
                                                setTimeout(() => {
                                                    this.$router.push("/");
                                                }, 1500);
                                            }
                                        } else {
                                            this.$message.error('用户不存在或账号密码错误！');
                                        }
                                    }).catch((error) => {
                                        console.log(error);   
                                    });
                    } else {
                        return false;
                    }
                })
            },
            to(link) {
                this.$router.push(link)
            },
            // setting_web() {
            //     this.color_form = {
            //         aside_background_color: "#000000",
            //         aside_text_color: "#ffffff",
            //         aside_icon_color: "#ffffff",
            //         aside_active_text_color: "#67C23A",
            //         aside_title: "EuiAdmin",
            //         aside_small_title: "Eui",
            //         aside_width: 200,
            //         aside_small_width: 65,
            //         head_icon_color: "#606266",
            //         head_background_color: "#fff",
            //         head_text_color: "#606266",
            //         head_active_text_color: "#303133",
            //         head_height: 60,
            //         main_background_color: "#f2f6fc",
            //     };
            //     this.$cookies.set("setting", JSON.stringify(this.color_form));
            // },
        },
        mounted() {
            // if (this.$cookies.get("setting") == null) {
            //     this.setting_web();
            // }
        },
    };
</script>

<style scoped>
    h1 {
        color: rgb(252 240 4);
    }

    p {
        color: rgb(252 240 4);
    }

    #login {
        min-height: 100vh;
        background-image: url('../../assets/img/CyberLogin4.jpeg');
        zoom: 1;
        background-color: #ffff;
        background-repeat: no-repeat;
        background-position: center 0;
        background-size: cover;
        -webkit-background-size: cover;
        -o-background-size: cover;
    }

    #form_space {
        border-radius: 10px;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        height: 400px;
        width: 400px;
    }

</style>