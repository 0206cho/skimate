<template>
  <header>
    <!-- Nav Bar 오른쪽 정렬 -->
    <nav class="navbar navbar-expand-sm navbar-light" style="background-color: #BFDDF9;">
      <div class="container">
        <v-row style="display: flex; justify-content: center;" class="pb-8">
          <v-col cols="12" >
            <v-row justify="center" align="center" style="height: 100%;">
              <v-col cols="4">
                <a class="navbar-brand " href="/"><img src="../../public/img/menulog.png"
                    style="height:30px;" /></a>
              </v-col>

              <v-col cols="4">
                <a class="navbar-brand" href="/" style="font-family: 'Title_font'">비발디파크</a>
                <a class="navbar-brand" href="/">예약</a>
                <a class="navbar-brand" href="/">강습</a>
                <a class="navbar-brand" href="/">공지사항</a>
              </v-col>
              <v-col cols="4">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                  <ul class="navbar-nav">
                    <li class="nav-item">
                      <router-link to="/login" class="text-white" v-if="!$store.state.account.id">Login</router-link>
                      <a to="/login" class="text-white" @click="logout()" v-else>Logout</a>
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
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
