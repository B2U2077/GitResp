<template>
    <div class="m-learnbox" id="courseLearn-inner-box">
        <div>
            <div class="m-learnChapterList f-pr">
                
                <!-- 页面显示所有课件的下拉框 -->
                <div style="width: 500px;text-align: left;">
                    请选择视频：
                    <el-select v-model="value" @change="getPath">
                        <el-option
                            v-for="(item,index) in videoList" :key="index" :value="item.vpath" :label="item.vname">
                        </el-option>
                    </el-select>
                </div>
                <!-- 若老师没有发布内容则显示此条信息 -->
                <div class="empty j-empty" v-if="isEmpty">
                    <span class="f-ib">
                        老师还没有发布任何学习内容，请耐心等待
                    </span>
                </div>
                <div v-else>
                    <div id="mse"></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Player from 'xgplayer';

export default {
    name: 'Classvideoview',
    data() {
        return {
            player: null,     //西瓜播放器
            selectVal: '',
            isEmpty: false, //判断课件列表是否为空标志
            value: '',
            videoList: [],  //所有课件列表
            videoURL: '',   //视频路径
        };
    },
    mounted() {
        let suId = localStorage.getItem("suId");
        this.getList(suId);
        this.initPlayer('');
    },
    methods: {
        getPath(path) {
            console.log(path);
            this.videoURL = path;
            this.initPlayer(path);
        },
        getList(suId) {
            this.formData = new FormData();
            this.formData.append("suId",suId);

            let url = 'http://127.0.0.1:8001/study/videolist/getList';
            this.$axios.post(url,this.formData)
                .then((res) => {
                    console.log(res);
                    this.videoList = res.data;
                    if(res.data.length < 1) {
                        this.isEmpty = true;
                    } else {
                        this.isEmpty = false;
                    }
                });
            
        },
        initPlayer(url) {
            this.player = new Player({
                // el、url为必选配置，其它为可选配置
                el: document.querySelector('#mse'),
                url: url,
                width: '90%',
                height: '500px',
                volume: 0.6,    // 初始音量
                autoplay: false,  // 自动播放
                playbackRate: [0.5, 0.75, 1, 1.5, 2],   // 当前播放速度
                defaultPlaybackRate: 1,     // 播放速度设置为1
                playsinline: true,
            });
        }
    },
};
</script>

<style scoped>
    
    .m-learnbox {
        background: #fff;
        padding: 20px 40px;
        height: 600px;
    }

    #mse {
        margin-top: 30px;
    }

</style>