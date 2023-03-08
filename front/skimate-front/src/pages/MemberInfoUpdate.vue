<template>
  <v-row>
    <v-col cols="2"></v-col>
    <v-col cols="1">
      <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
      </h1>
    </v-col>
    <v-col cols="6">
      <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">
        소셜 회원 추가 정보 입력
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
              <input type="text" class="form-control" id="floatingName" placeholder="name"
                v-model="state.form.memberName" />
              <label for="floatingName">이름</label>
            </div>
            <div class="form-floating">
              <input type="text" class="form-control" id="floatingPhone" placeholder="phone"
                v-model="state.form.memberPhone" />
              <label for="floatingPhone">핸드폰번호</label>
            </div>
            <br>
            <v-row>
              <v-col cols="3"></v-col>
              <v-col cols="6">
                <v-btn class="white--text" rounded="pill"
                  style="font-size: large; width:100%; height: 60px; background-color:#053D68; color: white;"
                  @click="submit()">회원가입</v-btn>
              </v-col>
              <v-col cols="3"></v-col>
            </v-row>
            <br>
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
import router from "@/scripts/router";
import axios from "axios";
export default {
  setup() {
    const state = reactive({
      form: {
        memberId: "",
        memberPw: "",
        memberName: "",
        memberPhone: "",
        memberAddress: ""
      },
    });

    const submit = () => {
      axios.post("http://localhost:8080/memberInfoUpdate", state.form, {
        headers: {
          "Authorization": "Bearer " + sessionStorage.getItem('id')
        }
      })
        .then((res) => {
          console.log(res.data);
          router.push({ path: "/ski" })
        })

    }

    return {
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