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
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">
          강&nbsp;&nbsp;습
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

        <v-card class="mt-10" style="border-radius:20px; border: 1px solid #053D68">
          <v-row>
            <v-col cols="2">
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 일자
              </v-card-text>
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 종류
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 비용
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                기타 사항
              </v-card-text>
            </v-col>

            <v-col cols="10">

              <v-row class="my-9">
                  <div class="mx-10">{{ state.lesson.lesson_lsdate }}</div>
              </v-row>
              <v-row class="my-10">
                <div class="mx-10 mt-1">{{ state.lesson.lesson_category }}</div>
              </v-row>
              <v-row class="my-10">
                <div class="mx-10 mt-4">{{ state.lesson.lesson_price }}</div>
              </v-row>
              <v-row class="my-11">
                <div class="mx-10 mt-4">{{ state.lesson.lesson_content }}</div>
              </v-row>

            </v-col>

          </v-row>

          <v-card-text class="end text-md-center">
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">목록으로</v-btn>
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" @click="PaymentBtn">신청하기</v-btn> <!--결제 api-->
            <!--작성자만 표기-->
            <!-- <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">수정하기</v-btn>
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">삭제하기</v-btn> -->
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";
import router from "@/scripts/router";
import axios from "axios";
import { reactive } from "@vue/reactivity";
const { IMP } = window;
export default {
  name: "LessonHome",
  data(){
    return {

    }
  },
  mounted(){
    const store = useStore();
    const storeLessonDetail = computed(() => store.state.lessonDetail);
    this.detail(storeLessonDetail.value);
  },

setup(){

  //const store = useStore();
  //const storeLessonDetail = computed(() => store.state.lessonDetail);

  //console.log("김민솔 : " + storeLessonDetail.value)

  //const store = useStore();
  const lesson_price = computed(() => state.lesson.lesson_price);
  const lessonId = computed(() => state.lesson.lessonId);

  const state = reactive({
      lesson: [],
      form: {
                 price: lesson_price,
                 lessonId: lessonId,
              },
    });


  const detail = (storeLessonDetail) => {
      axios.get(`http://localhost:8080/api/lesson/detail/${storeLessonDetail}`, {
          headers: {
            'Authorization': 'Bearer ' + sessionStorage.getItem('id')
          }
        })
        .then((res) => {
          state.lesson = res.data;
        })
        .catch(() => {
        });
    }

    const submit = () => {
            axios.post("http://localhost:8080/api/cash/lesson", state.form, {
                headers: {
                  Authorization: "Bearer " + sessionStorage.getItem("id"),
                },
              })
              .then((res) => {
                console.log("res : " + res);
              })
              .catch(() => {
                window.alert("로그인 정보가 처리되지 않았습니다.");
              });
              };

    return {
      detail,
      state,
      submit
    }
},

  methods: {
    onClick() {
      this.loading = true

      setTimeout(() => {
        this.loading = false
        this.loaded = true
      }, 2000)
    },

    PaymentBtn: function () {
      IMP.init("imp77524147");
      IMP.request_pay(
        {
          // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "merchant_" + new Date().getTime(),
          name: "스키메이트 결제",
          //amount: this.price,
          amount: 300,
          buyer_email: "funidea_woo@naver.com",
          buyer_name: "테스터",
          buyer_tel: "010-8832-4280",
          buyer_addr: "서울특별시 영등포구 당산동",
          buyer_postcode: "07222",
        },
        (rsp) => {
          // callback
          console.log(rsp);
          var msg = "";
          if (rsp.success) {
            msg = "결제가 완료되었습니다.\n";
            msg += "고유ID : " + rsp.imp_uid;
            msg += "\n상점 거래ID : " + rsp.merchant_uid;
            msg += "\n결제 금액 : " + rsp.paid_amount;
            msg += "\n카드 승인번호 : " + rsp.apply_num;
            console.log("결제 성공");
            router.push({ path: `/lesson` });
            this.submit()

          } else {
            msg = "결제에 실패하였습니다.";
            msg += "\n실패 내용 : " + rsp.error_msg;
            console.log("결제 실패");
          }
          alert(msg);
        }
      );
    },


  },
};
</script>

<style scoped></style>
