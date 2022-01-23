<template>
    <div>
        <div id="div1">
            <el-row>
                <el-col :span="4">
                    <!-- 学校 -->
                    <SchoolView/>
                </el-col>
                <el-col :span="16">
                    <!-- 轮播图 -->
                    <CarouselView />
                </el-col>
                <el-col :span="4">
                    <!-- 时钟 -->
                    <ClockView />
                </el-col>
            </el-row>
        </div>

        <div id="div2">
            <ClassIntroduction />
        </div>
    </div>
</template>

<script>
    import CarouselView from '@/components/CarouselView'
    import SchoolView from '@/components/SchoolView'
    import ClockView from '@/components/ClockView'
    import ClassIntroduction from '@/components/ClassIntroduction'

    export default {
        name: 'IndexView',
        components: { CarouselView ,SchoolView , ClockView, ClassIntroduction},
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

    #div1 {
        height: 360px;
        width: 1200px;
        margin: 0 auto;
    }

</style>