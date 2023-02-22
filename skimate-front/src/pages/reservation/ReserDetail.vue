<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex;justify-content: center;color: #053d68;font-family: 'Title_bold';">|
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style=" display: flex;justify-content: center;color: #053d68;font-family: 'Title_bold';">
          결&nbsp;&nbsp;제
        </h1>
      </v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color: #053d68; font-family: 'Title_bold';">
          |
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row class="mb-0">
      <v-col cols="2"></v-col>
      <v-col cols="8" class="pb-0">
        <v-divider style="border-color: #053d68"></v-divider><!--=hr-->
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="6" class="mt-0 pt-0">
        <v-card class="mt-10" style="border-radius: 20px; border: 1px solid #053d68">
          <v-row>
            <v-col cols="3">
              <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                이용 일자
              </v-card-text>
              <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;원
              </v-card-text>
              <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                스&nbsp;키&nbsp;장
              </v-card-text>
              <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                장&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비
              </v-card-text>
            </v-col>

            <v-col cols="8">
              <v-row>
                <v-card-text class="mt-7" style="font-size: medium;">{{ $store.state.reserDate }}</v-card-text>
              </v-row>
              <v-row class="mt-10">
                <v-col cols="3">
                  <p>대인&nbsp;&nbsp;{{ $store.state.bigPerson }}&nbsp;인</p>
                </v-col>
                <v-col cols="3">
                  <p>소인&nbsp;&nbsp;{{ $store.state.smallPerson }}&nbsp;인</p>
                </v-col>
              </v-row>

              <v-row>
                <v-col cols="12" class="mt-2">
                  <p>{{ $store.state.skiRounge.skiName }}</p>
                </v-col>
              </v-row>

              <v-row class="my-5">
                <v-col cols="3">
                  <p>스키&nbsp;&nbsp;{{ $store.state.ski }}&nbsp;개</p>
                </v-col>
                <v-col cols="3">
                  <p>보드&nbsp;&nbsp;{{ $store.state.board }}&nbsp;개</p>
                </v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="3"></v-col>
    </v-row>

    <v-row>
      <v-col cols="4"></v-col>
      <v-col cols="3">
        <h3 class="text-right">{{ $store.state.tot }}  원</h3>
      </v-col>
      <v-col cols="3">
        <v-btn style="background-color:#053D68; color: white;" @click="PaymentBtn">결제</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import { computed } from "vue";
import { useStore } from "vuex";

//console.log(new Date().getTime());
const { IMP } = window;


export default {
  name: "ReserDetail",

  setup() {
    const store = useStore();
    const storeBigPerson = computed(() => store.state.bigPerson);
    const storeSmallPerson = computed(() => store.state.smallPerson);
    const storeSki = computed(() => store.state.ski);
    const storeBoard = computed(() => store.state.board);
    const storeSkiId = computed(() => store.state.skiRounge.skiId);
    const storeTot = computed(() => store.state.tot);

    const states = reactive({
      form: {
        price: storeTot,
        bigPerson: storeBigPerson,
        smallPerson: storeSmallPerson,
        ski: storeSki,
        board: storeBoard,
        skiId: storeSkiId,
      },
    });


    const submit = () => {
      axios.post("http://localhost:8080/api/cash/reservation", states.form, {
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
      states,
      submit,
    };

  },
  data() {
    return {
      //price: this.$store.state.tot
      //price: ,
    };
  },
  methods: {
    PaymentBtn: function () {
      IMP.init("imp77524147");

      IMP.request_pay(
        {
          // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: "merchant_" + new Date().getTime(),
          name: "예약 결제",
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
