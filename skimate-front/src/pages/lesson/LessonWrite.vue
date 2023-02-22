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
          강&nbsp;&nbsp;습
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
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 일자
              </v-card-text>
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 종류
              </v-card-text>
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 비용
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용
              </v-card-text>
            </v-col>
            <v-col cols="10">
              <v-row>
                <v-col cols="5.5">
                  <v-text-field class="mt-5 ml-7" variant="outlined"
                    type="date" v-model="state.form.startDate"></v-text-field>
                </v-col>
                <v-col cols="1" class="mt-8 text-md-center" style="margin:aoto">
                  <v-catd-text style="font-size: larger;">~</v-catd-text>
                </v-col>
                <v-col cols="5.5">
                  <v-text-field class="mt-5 mr-7" variant="outlined" type="date" v-model="state.form.endDate"></v-text-field>
                </v-col>
              </v-row>
              <v-radio-group inline class="mb-3 ml-4" v-model="state.form.category">
                <v-radio label="스키" value="스키" color="indigo-darken-3" class="mr-5"></v-radio>
                <v-radio label="보드" value="보드" color="indigo-darken-3"></v-radio>
              </v-radio-group>
              <v-text-field class="mx-7" v-model="state.form.price" variant="outlined" type="number"
                suffix="원"></v-text-field>
              <v-text-field class="mx-7" v-model="state.form.title" variant="outlined" type="text"></v-text-field>
              <v-textarea class="mx-7" v-model="state.form.content" auto-grow variant="outlined" rows="3"
                row-height="25" rounded="true"></v-textarea>
            </v-col>

            <div class="accordion accordion-flush mx-10 mb-5" id="accordionFlushExample" style="width:100%;">
              <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne"
                    style="background-color: #BFDDF9; font-weight: bold; color: #053D68;">
                    주의사항
                  </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                  data-bs-parent="#accordionFlushExample">
                  <div class="accordion-body">
                    [개인정보 보호법] 제15조 및 제17조에 따라 아래의 내용으로 개인정보를 수집, 이용 및 제공하는데 동의합니다.<br><br>
                    □ 개인정보의 수집 및 이용에 관한 사항<br>
                    - 수집하는 개인정보 항목 : 성명, 전화번호<br>
                    - 개인정보의 이용 목적 : 수집된 개인정보를 강습 시 멘티에게 제공합니다. <br><br>
                    □ 개인정보의 보관 및 이용 기간<br>
                    - 귀하의 개인정보를 다음과 같이 보관하며, 수집, 이용 및 제공목적이 달성된 경우
                  </div>
                </div>
              </div>
            </div>
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
export default {
  name: "LessonHome",
  setup() {
    const state = reactive({
      form: {
        title: "",
        price: "",
        content: "",
        category: "",
        startDate: "",
        endDate: ""
      },
    });

    const submit = () => {
      axios
        .post("http://localhost:8080/api/lesson/write", state.form, {
          headers: {
            'Authorization': 'Bearer ' + sessionStorage.getItem('id')
          }
        })
        .then((res) => {
          console.log(">>>> form : " + state.form.title)
          console.log(">>>> res : " + res)
          router.push({ path: "/lesson" });
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