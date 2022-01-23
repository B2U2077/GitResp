<template>
    <div id="g-body">
        <UserInfoTop/>
        <UserClassList/>
    </div>
</template>

<script>
    import UserInfoTop from '@/components/userinfoComponents/UserInfoTop'
    import UserClassList from '@/components/userinfoComponents/UserClassList';

    export default {
        name: 'Userinfo',
        components: { UserInfoTop,UserClassList },
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
    #g-body {
        background: #fff;
        padding-bottom: 300px;
    }
</style>