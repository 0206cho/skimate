<template>
    <div>

    </div>
</template>

<script>
import router from '@/scripts/router';
import store from '@/scripts/store';
export default {
    created() {
        const token = this.$route.query.token

        if(token){
            store.commit('setAccesToken', token);
            sessionStorage.setItem('id', token);
            window.alert('login');
            router.push({path:'/ski'})
        }else{
            window.alert("login fail")
            router.push({path:'/login'})
        }
    }
}
</script>

<style>

</style>