<template>
    <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
      <!--제목-->
      <v-row>
        <v-col cols="2"></v-col>
        <v-col cols="1">
          <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
          </h1>
        </v-col>
        <v-col cols="6">
          <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">
            공지 사항
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
        <v-col cols="8">
          <v-divider style="border-color:#053D68;"></v-divider><!--=hr-->
  
          <v-card class="form-floating mt-10" style="border-radius:20px; border: 1px solid #053D68">
            <v-row>
              <v-col cols="2">
                <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                  제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
                </v-card-text>
                <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                  내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용
                </v-card-text>
              </v-col>
              <v-col cols="10">
                <v-text-field class="mx-7 mt-7" v-model="state.form.postTitle" variant="outlined" type="text"></v-text-field>
                <v-textarea class="mx-7 mt-2" v-model="state.form.postContent" auto-grow variant="outlined" rows="3"
                  row-height="25" rounded="true"></v-textarea>
              </v-col>
            </v-row>
  
            <v-card-text class="end text-md-right">
              <v-btn type="submit" class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;"
                @click="submit()">글쓰기</v-btn>
            </v-card-text>
          </v-card>
        </v-col>
        <v-col cols="2"></v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import { reactive } from "@vue/reactivity";
  import axios from "axios";
  import router from "@/scripts/router";
  import { computed } from "vue";
  import { useStore } from "vuex";
  
  export default {
    name: "PostWrite",
    setup() {
      // store 사용 시
      const store = useStore();
      const storeSkiId = computed(() => store.state.skiRounge.skiId);
      console.log("스키 아이디 : "+ storeSkiId.value);
      const state = reactive({
        form: {
            postTitle: "",
            postContent: "",
            skiNum: storeSkiId,
    
        },
      });
  
      const submit = () => {
        axios
          .post("http://localhost:8080/skiPostWirte", state.form, {
            headers: {
              'Authorization': 'Bearer ' + sessionStorage.getItem('id')
            }
          })
          .then(() => {
            router.push({ path: "/ski" });
            window.alert("등록되었습니다.");
          })
          .catch(() => {
            window.alert("다시 입력해주시길 바랍니다.");
          });
      };
  
      return {
        state,
        submit,
      };
    },
  };
  </script>
  <style scoped></style>
  
