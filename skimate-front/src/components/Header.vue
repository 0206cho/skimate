<template>
  <header>
    <!-- Nav Bar 오른쪽 정렬 -->
    <nav class="navbar navbar-expand-sm navbar-light" style="background-color: #BFDDF9;">
      <div class="container">
        <v-row style="display: flex; justify-content: center;" class="py-5">
          <v-col cols="12" >
            <v-row justify="center" align="center" style="height: 100%;">
              <v-col cols="2">
                <a class="navbar-brand " href="/">
                  <img :src="img" alt="logo" style="height:30px;" /></a>
              </v-col>

              <v-col cols="7">
                <a class="navbar-brand pr-5" href="/ski" style="font-family: 'Title_bold'; color: #053D68;">{{ $store.state.skiRounge.skiName }}</a>
                <a class="navbar-brand px-5" href="/reservation" style="font-family: 'Title_font'">예약</a>
                <a class="navbar-brand px-5" href="/lesson" style="font-family: 'Title_font'">강습</a>
                <a class="navbar-brand px-5" href="/" style="font-family: 'Title_font'">공지사항</a>
                <a class="navbar-brand px-5" href="https://app.gather.town/app/0aIZT9Y78MUNGZ1L/skimate" style="font-family: 'Title_font'">커뮤니티</a>
                <a class="navbar-brand px-5" href="http://pf.kakao.com/_NaTexj" style="font-family: 'Title_font'">문의사항 </a>
              </v-col>
              <v-col cols="1">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                  <ul class="navbar-nav">
                    <li class="nav-item">
                      <router-link to="/login" class="text-black navbar-brand" v-if="!$store.state.account.memberId" style="font-family: 'Title_bold'; font-size: medium; text-decoration: none;">
                        로그인
                      </router-link>
                      <a class="navbar-brand" href="/" @click="logout()" v-else style="font-family: 'Title_bold'; font-size: medium;">로그아웃</a>
                    </li>
                  </ul>
                </div>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </div>
    </nav>
</header>
</template>

<script>
import { reactive } from "@vue/reactivity";
import store from '@/scripts/store';
import router from '@/scripts/router';
export default {
  name: "Header",

  setup(){
    const logout = () =>{
      store.commit('setAccesToken', "")
      sessionStorage.removeItem("id")
      router.push({path:"/"})
    }

    const state = reactive({
      loginId : sessionStorage.getItem('id')
    });



    return {logout, state}
  },
  // 로고 이미지
  data : ()=>({
    img : require('../../public/img/menulog.png')
  })
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
