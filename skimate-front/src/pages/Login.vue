<template>
  <v-row>
    <v-col cols="2"></v-col>
    <v-col cols="1">
      <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
      </h1>
    </v-col>
    <v-col cols="6">
      <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">
        로그인
      </h1>
    </v-col>
    <v-col cols="1">
      <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
      </h1>
    </v-col>
    <v-col cols="2"></v-col>
  </v-row>

  <v-row>
    <v-col cols="2"></v-col>
    <v-col cols="8" class="center">
      <v-divider style="border-color:#053D68;"></v-divider><!--=hr-->
      <v-row>
        <v-col cols="3"></v-col>
        <v-col cols="6">
          <div class="form-signin cetner ml-4" style="min-width: 600px; padding:0px;">
            <div class="form-floating">
              <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com"
                v-model="state.form.memberId"/>
              <label for="floatingInput">사용자 ID</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                v-model="state.form.memberPw" />
              <label for="floatingPassword">비밀번호</label>
            </div>
            <v-row>
              <v-col cols="6">
                <v-btn class="white--text" rounded="pill" style="font-size: large; width:100%; height: 60px; background-color:#053D68; color: white;" @click="submit()">로그인</v-btn>
              </v-col>
              <v-col cols="6">
                <v-btn class="white--text" rounded="pill" style="font-size: large; width:100%; height: 60px; background-color:#053D68; color: white;" @click="joinForm()">회원가입</v-btn>
              </v-col>
            </v-row>
            <br>
            <v-row>
              <v-col cols="3"></v-col>
              <v-col cols="7" class="ml-4">
                <a :href="naverurl">
                  <img src="/img/naver.png" class="sociaLogin mr-8" style="width: 20%;">
                </a>
                <a :href="kakaourl">
                  <img src="/img/kakao.png" class="sociaLogin  mr-8" style="width: 20%;">
                </a>
                <a :href="googleUrl">
                  <img src="/img/google.png" class="sociaLogin" style="width: 20%;">
                </a>
              </v-col>
            </v-row>
            <div>
            </div>
          </div>
        </v-col>
        <v-col cols="3"></v-col>
      </v-row>
    </v-col>
    <v-col cols="1"></v-col>
  </v-row>
  <div style="height: 140px;"></div>
</template>

<script>
import { reactive } from "@vue/reactivity";
import { ref } from "vue";
import axios from "axios";
import router from "@/scripts/router";
import store from "@/scripts/store";
export default {
  setup() {
    const state = reactive({
      form: {
        memberId: "",
        memberPw: "",
      },
    });

    const joinForm = () => {
      router.push({ path: "/join" });
    }

    const submit = () => {
      axios
        .post("http://localhost:8080/login", state.form)
        .then((res) => {
          store.commit("setAccesToken", res.data);
          sessionStorage.setItem("id", res.data);
          console.log(res.data);
          router.push({ path: "/ski" });
          window.alert("login");
        })
        .catch(() => {
          window.alert("로그인 정보가 처리되지 않았습니다.");
        });
    };



    const naverurl = ref("http://localhost:8080/oauth2/authorization/naver?redirect_url=http://localhost:3000/oauth/redirect");
    const kakaourl = ref("http://localhost:8080/oauth2/authorization/kakao?redirect_url=http://localhost:3000/oauth/redirect");
    const googleUrl = ref("http://localhost:8080/oauth2/authorization/google?redirect_url=http://localhost:3000/oauth/redirect");


    return {
      state,
      submit,
      naverurl,
      kakaourl,
      googleUrl,
      joinForm
    };
  },

};
</script>

<style scoped>
.sociaLogin {
  max-width: 250px;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
