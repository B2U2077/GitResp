<template>
    <div>
        <div>
            <TopSpace />
        </div>
        <div style="margin-top:20px">
            <WebDataSpace />
        </div>
    </div>
</template>

<script>
    import TopSpace from '@/components/adminComponents/module/TopSpace'
    import WebDataSpace from '@/components/adminComponents/module/WebDataSpace'
    export default {
        name: 'Adminhomespace',
        components: { TopSpace, WebDataSpace },
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

<style scoped>

</style>