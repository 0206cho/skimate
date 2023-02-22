<template>
    <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">회원가입</h1>

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
  </div>
</template>

<script>
import { reactive } from "@vue/reactivity";
export default {
    setup() {
    const state = reactive({
      form: {
        memberId: "",
        memberPw: "",
      },
    });

    return{
        state
    }
    }

}
</script>

<style>
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