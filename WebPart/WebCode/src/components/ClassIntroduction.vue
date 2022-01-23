<template>
    <div class="dW-cE">
        <a class="_1BnFd">
            精品课程推荐
        </a>
        <div class="_3Vnvu">
            <span class="_2Mqyi">好课推荐</span>
        </div>
        <div class="_15K5J">
            <div class="_2mbYw" v-for="(item,index) in classList" :key="index">
                <div class="_3KiL7">
                    <el-link @click="to(item.suId,item.suName,item.vdef10)">
                        <el-image class="_3hfsT" :src="item.vdef10"></el-image>
                        <div class="_3L4SC">
                            <div class="_3flBx">
                                <span class="H_ce0" style="background: rgb(203, 162, 101);">
                                    国家精品
                                </span>
                            </div>
                        </div>
                    </el-link>
                    <el-link @click="to(item.suId,item.suName,item.vdef10)">
                        <div class="_1Bfx4">
                            <div class="WFpCn">
                                <h3 class="_3EwZv _1VDzh">
                                    {{item.suName}}
                                </h3>
                                <p class="_2lZi3">
                                    {{item.scName}}
                                </p>
                                <div class="_1Zkj9">
                                    赛博教育
                                </div>
                            </div>
                        </div>
                    </el-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Classintroduction',
        data() {
            return {
                imgUrl: '',
                classList: [],

            };
        },
        mounted() {
            this.showClassList();
        },
        methods: {
            showClassList() {
                let url = 'http://127.0.0.1:8001/study/userClass/getAllList';
                this.$axios.post(url, {})
                    .then((res) => {
                        console.log(res);
                        this.classList = res.data;
                    });
            },
            to(id,name,imgUrl) {
                localStorage.setItem("suName",name);
                localStorage.setItem("suId",id);
                localStorage.setItem("imgUrl",imgUrl);
                this.$router.push('/classComponents/ClassInfoView/${id}');
            }
        },
    };
</script>

<style>
    .dW-cE {
        min-height: 395px;
        margin: 0 auto;
        margin-top: 50px;
        margin-bottom: 32px;
        width: 1200px;
        text-align: left;
    }

    ._1BnFd {
        color: #333;
        font-size: 24px;
        font-weight: 500;
        margin-bottom: 20px;
    }

    ._3Vnvu {
        line-height: 28px;
        margin-top: 15px;
        border-bottom: 1px solid #E6E6E6;
    }

    ._3Vnvu span._2Mqyi {
        color: #00C758;
        border-bottom: 2px solid #00C758;
    }

    ._15K5J {
        min-height: 200px;
        overflow: hidden;
        padding-top: 24px;
    }

    ._15K5J {
        min-height: 200px;
        overflow: hidden;
        padding-top: 24px;
    }

    ._2mbYw {
        cursor: pointer;
        float: left;
        margin: 0 20px 20px 0;
        border-radius: 4px;
        -webkit-transition: all ease-in 0.2s;
        -o-transition: all ease-in 0.2s;
        transition: all ease-in 0.2s;
        line-height: 0;
    }

    ._2mbYw>div {
        overflow: hidden;
    }

    ._3KiL7 {
        cursor: pointer;
        position: relative;
        display: inline-block;
        width: 224px;
        height: 252px;
        border-radius: 4px;
        background: #fff;
        font-family: PingFangSC-Regular, PingFang SC;
        font-size: 0;
        overflow: hidden;
        -webkit-transition: all ease-in 0.2s;
        -o-transition: all ease-in 0.2s;
        transition: all ease-in 0.2s;
    }

    ._3KiL7 ._3hfsT {
        width: 100%;
        max-height: 126px;
        overflow: hidden;
        vertical-align: middle;
        border-style: none;
    }

    ._3KiL7 ._3L4SC {
        position: absolute;
        top: 8px;
        left: 8px;
    }

    ._3flBx {
        font-size: 0;
        font-family: PingFangSC-Regular, PingFangSC;
    }

    ._3flBx .H_ce0 {
        display: inline-block;
        height: 20px;
        line-height: 20px;
        font-size: 12px;
        padding: 0 6px;
        margin: 0 4px 8px 0;
        color: #fff;
        background: rgba(0, 0, 0, 0.5);
        border-radius: 3px;
    }

    ._3KiL7 ._1Bfx4 {
        position: relative;
        padding: 10px 12px;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        height: 126px;
    }

    ._3KiL7 ._3EwZv {
        max-height: 36px;
        font-size: 14px;
        font-weight: 500;
        color: #333;
        font-weight: bold;
        font-family: PingFangSC-Medium, PingFangSC;
        line-height: 18px;
        overflow: hidden;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

    ._3KiL7 ._2lZi3 {
        height: 12px;
        line-height: 12px;
        font-size: 12px;
        margin-top: 8px;
        color: #666;
        overflow: hidden;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    ._3KiL7 ._1Zkj9 {
        width: 100%;
        height: 17px;
        line-height: 17px;
        margin: 8px 0 0 0;
        font-size: 12px;
        color: #999;
        overflow: hidden;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
</style>