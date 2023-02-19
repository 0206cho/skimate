<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">|
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">강습
        </h1>
      </v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">|
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="8">
        <v-divider style="border-color:#053D68;"></v-divider><!--=hr-->
        <v-col col="2"></v-col>
        <v-col col="3">
          <v-text-field placeholder="검색" type="text"  prepend-inner-icon="fa-search" color="#008037"></v-text-field>
        </v-col>
        <v-col col="3"></v-col>
        
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

  </v-container>
</template>
  
<script>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";
export default {
  setup() {
    const state = reactive({
      form: {
        email: "",
        password: "",
      },
    });

    const submit = () => {
      axios
        .post("/api/account/login", state.form)
        .then((res) => {
          store.commit("setAccount", res.data);
          sessionStorage.setItem("id", res.data);
          console.log(res.data);
          router.push({ path: "/" });
          window.alert("login");
        })
        .catch(() => {
          window.alert("로그인 정보가 처리되지 않았습니다.");
        });
    };

    return {
      state,
      submit,
    };
  },
};
</script>
  
<style scoped>
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
