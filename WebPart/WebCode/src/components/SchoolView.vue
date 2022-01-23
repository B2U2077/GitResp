<template>
    <div id="divSchool">
        <div class="_3fkJI">
            <span class="_2KM6p">
                国家精品
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">计算机</a></span>
            <span class="_3PG4Q">
                <a href="#">大数据与人工智能</a>
                <span> / </span>
                <a href="#">软件工程</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">外语</a></span>
            <span class="_3PG4Q">
                <a href="#">听力</a>
                <span> / </span>
                <a href="#">口语</a>
                <span> / </span>
                <a href="#">写作</a>
                <span> / </span>
                <a href="#">翻译</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">理学</a></span>
            <span class="_3PG4Q">
                <a href="#">数学</a>
                <span> / </span>
                <a href="#">物理</a>
                <span> / </span>
                <a href="#">化学</a>
                <span> / </span>
                <a href="#">天文</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">工学</a></span>
            <span class="_3PG4Q">
                <a href="#">力学</a>
                <span> / </span>
                <a href="#">材料</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">21/22考研</a></span>
            <span class="_3PG4Q">
                <a href="#">数学</a>
                <span> / </span>
                <a href="#">名师英语</a>
                <span> / </span>
                <a href="#">芜湖起飞</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">期末不挂科</a></span>
            <span class="_3PG4Q">
                <a href="#">数学不挂科</a>
                <span> / </span>
                <a href="#">物理不挂科</a>
                <span> / </span>
                <a href="#">芜湖起飞</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">应试英语</a></span>
            <span class="_3PG4Q">
                <a href="#">帆哥四六级</a>
                <span> / </span>
                <a href="#">帅帆</a>
                <span> / </span>
                <a href="#">芜湖起飞</a>
            </span>
        </div>
        <div class="_3fkJI">
            <span class="_2KM6p"><a href="#">实用英语</a></span>
            <span class="_3PG4Q">
                <a href="#">万词班</a>
                <span> / </span>
                <a href="#">新概念</a>
                <span> / </span>
                <a href="#">芜湖起飞</a>
            </span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Schoolview',
    data() {
        return {
            
        };
    },
    mounted() {
        
    },
    methods: {
        
    },
};
</script>

<style>

    #divSchool {
        width: 200px;
        height: 360px;
        padding: 0;
        background-color: rgb(255, 255, 255);
    }

    
    ._3fkJI {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        width: 200px;
        height: 34px;
        padding: 0 12px;
        line-height: 34px;
        white-space: nowrap;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        overflow: hidden;
        color: rgb(153, 153, 153);
        outline: none;
        text-align: left;
    }

    ._3fkJI ._2KM6p {
        margin-right: 8px;
        font-size: 14px;
        font-weight: 500;
        color: rgb(51, 51, 51);
    }

    ._3fkJI ._3PG4Q {
        line-height: 17px;
        font-size: 12px;
        font-weight: 400;
    }

    ._2KM6p > a {
        text-decoration:none;
        color: inherit;
    }

    ._3PG4Q > a {
        text-decoration:none;
        color: inherit;
    }
</style>