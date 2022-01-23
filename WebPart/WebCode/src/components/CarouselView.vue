<template>
    <div>
        <el-carousel height="360px" class="carouselEl">
            <el-carousel-item v-for="(imgItem,index) in imgList" :key="index">
              <el-image :src='imgItem'>
                <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline"></i>
                </div>
              </el-image>
            </el-carousel-item>
          </el-carousel>
    </div>
</template>

<script>
export default {
    name: 'Carouselview',
    data() {
        return {
            imgList: [require('@/assets/img/Carousel1.jpg'),
                require('@/assets/img/Carousel2.jpg'),
                require('@/assets/img/Carousel3.png'),
                require('@/assets/img/Carousel4.png'),
                require('@/assets/img/Carousel5.png')]
        };
    },
    mounted() {
        
    },
    methods: {
        
    },
};
</script>

<style scoped>

    .carouselEl {
        width: 776px;
    }
</style>