<template>
    <div>

    </div>
</template>

<script>
import router from '@/scripts/router';
import axios from "axios";
export default {
    created() {
        axios.get(`http://localhost:8080/userRole`, {
            headers: {
              'Authorization': 'Bearer ' + sessionStorage.getItem('id')
            }
          }).then((res) =>{
            sessionStorage.setItem("memberRole" ,res.data)
            router.push({path:'/ski'})
          })
    }
}
</script>

<style>

</style>