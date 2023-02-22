<template>
    <div class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">소셜 회원 추가 정보 입력</h1>

    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="floatingName"
        placeholder="name"
        v-model="state.form.memberName"
      />
      <label for="floatingName">이름</label>
    </div>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="floatingPhone"
        placeholder="phone"
        v-model="state.form.memberPhone"
      />
      <label for="floatingPhone">핸드폰번호</label>
    </div>

    <div>
      <button class="w-100 btn btn-lg btn-primary" @click="submit()">
        회원가입
      </button>
    </div>
  </div>
</template>

<script>
import { reactive } from "@vue/reactivity";
import router from "@/scripts/router";
import axios from "axios";
export default {
    setup() {
    const state = reactive({
      form: {
        memberId: "",
        memberPw: "",
        memberName : "",
        memberPhone : "",
        memberAddress : ""
      },
    });

    const submit = () => {
        axios.post("http://localhost:8080/memberInfoUpdate",state.form,{
          headers : {
            "Authorization" : "Bearer " + sessionStorage.getItem('id') 
          }
        })
        .then((res)=>{
            console.log(res.data);
            router.push({path : "/ski"})
        })

    }

    return{
        state,
        submit
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