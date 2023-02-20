<template>
  <header>
    <!-- Nav Bar 오른쪽 정렬 -->
    <nav class="navbar navbar-expand-sm navbar-light" style="background-color: #BFDDF9;">
      <div class="container">
        <v-row style="display: flex; justify-content: center;" class="py-5">
          <v-col cols="12" >
            <v-row justify="center" align="center" style="height: 100%;">
              <v-col cols="3">
                <a class="navbar-brand " href="/">
                  <img :src="img" alt="logo" style="height:30px;" /></a>
              </v-col>

              <v-col cols="6">
                <a class="navbar-brand pr-5" href="/" style="font-family: 'Title_bold'; color: #053D68;">비발디파크</a>
                <a class="navbar-brand px-5" href="/" style="font-family: 'Title_font'">예약</a>
                <a class="navbar-brand px-5" href="/lesson" style="font-family: 'Title_font'">강습</a>
                <a class="navbar-brand px-5" href="/" style="font-family: 'Title_font'">공지사항</a>
              </v-col>
              <v-col cols="3">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                  <ul class="navbar-nav">
                    <li class="nav-item">
                      <router-link to="/login" class="text-black" v-if="!$store.state.account.id" style="text-decoration: none;">
                        <v-icon dark size="40px">mdi-account</v-icon>
                      </router-link>
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
import store from "@/scripts/store";
import router from "@/scripts/router";
export default {
  name: "Header",
  setup() {
    const logout = () => {
      store.commit("setAccount", 0);
      sessionStorage.removeItem("id");
      router.push({ path: "/" });
    };

    return {
      logout,
    };
  },
  // 로고 이미지
  data : ()=>({
    img : require('../../public/img/menulog.png')
  })
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
