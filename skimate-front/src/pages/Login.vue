<template>
  <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">로그인</h1>

    <div class="form-floating">
      <input
        type="email"
        class="form-control"
        id="floatingInput"
        placeholder="name@example.com"
        v-model="state.form.memberId"
      />
      <label for="floatingInput">사용자 ID</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="Password"
        v-model="state.form.memberPw"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div>
      <button class="w-100 btn btn-lg btn-primary" @click="submit()">
        로그인
      </button>
    </div>

    <div>
      <button class="w-100 btn btn-lg btn-primary">회원가입</button>
    </div>
  </div>
</template>

<script>
import { reactive } from "@vue/reactivity";
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

    const submit = () => {
      axios
        .post("http://localhost:8080/login", state.form)
        .then((res) => {
          store.commit("setAccesToken", res.data);
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
