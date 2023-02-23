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
        const role = this.$route.query.role

        if(token && role=="GUEST"){
            store.commit('setAccesToken', token);
            sessionStorage.setItem('id', token);
            router.push({path:'/memberInfoUdate'})
        }else if((token && role=="USER") || (token && role=="ADMIN")){
            store.commit('setAccesToken', token);
            sessionStorage.setItem('id', token);
            router.push({path:'/setMemberRole'})
        }else{
            window.alert("login fail")
            router.push({path:'/login'})
        }
    }
}
</script>

<style>

</style>