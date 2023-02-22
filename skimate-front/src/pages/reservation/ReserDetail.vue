<template>
  <v-container
    style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;"
  >
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          |
        </h1>
      </v-col>
      <v-col cols="6">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          결제
        </h1>
      </v-col>
      <v-col cols="1">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          |
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="8">
        <v-divider style="border-color: #053d68"></v-divider
        ><!--=hr-->

        <v-card
          class="mt-10"
          style="border-radius: 20px; border: 1px solid #053d68"
        >
          <v-row>
            <v-col cols="2">
              <v-card-text
                class="mx-5 my-5"
                style="font-size: medium; font-weight: bold; color: #053d68"
              >
                이용 일자
              </v-card-text>
              <v-card-text
                class="mx-5 my-5"
                style="font-size: medium; font-weight: bold; color: #053d68"
              >
                인 원
              </v-card-text>
              <v-card-text
                class="mx-5 mt-7"
                style="font-size: medium; font-weight: bold; color: #053d68"
              >
                장비 대여
              </v-card-text>
              <v-card-text
                class="mx-5 mt-7"
                style="font-size: medium; font-weight: bold; color: #053d68"
              >
                스키장
              </v-card-text>
              <v-card-text
                class="mx-5 mt-7"
                style="font-size: medium; font-weight: bold; color: #053d68"
              >
                장비
              </v-card-text>
            </v-col>

            <v-col cols="10">
              <v-row class="my-9">
                <div class="mx-10">2023 년 02 월 17 일</div>
              </v-row>
              <v-row class="my-10">
                <v-col cols="1">
                  <p>대인</p>
                </v-col>
                <v-col cols="5">
                  <p>{{ $store.state.bigPerson }}</p>
                </v-col>
                <v-col cols="1">
                  <p>소인</p>
                </v-col>
                <v-col cols="5">
                  <p>{{ $store.state.smallPerson }}</p>
                </v-col>
              </v-row>
              <v-row class="my-11">
                <v-col cols="1">
                  <p>스키</p>
                </v-col>
                <v-col cols="5">
                  <p>{{ $store.state.ski }}</p>
                </v-col>
                <v-col cols="1">
                  <p>보드</p>
                </v-col>
                <v-col cols="5">
                  <p>{{ $store.state.board }}</p>
                </v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="9"></v-col>
      <v-col cols="3">
        <h3>
          {{ storeTot }}
        </h3>
        <v-btn color="#BFDDF9" @click="submit">결제</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import { computed } from "vue";
import { useStore } from "vuex";
const { IMP } = window;
console.log(new Date().getTime());
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
    console.log("스키 아이디 : "+ storeSkiId.value);
    const states = reactive({
      form: {
        price: storeTot,
        bigPerson: storeBigPerson,
        smallPerson : storeSmallPerson,
        ski: storeSki,
        board: storeBoard,
        skiId: storeSkiId

      },
    });

    const submit = () => {
      axios.post("http://localhost:8080/api/cash/reservation", states.form, {
          headers: {
            Authorization: "Bearer " + sessionStorage.getItem("id"),
          },
        })
        .then((res) => {
          console.log("res : " + res)
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
          amount: this.price,
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
          } else {
            msg = "결제에 실패하였습니다.";
            msg += "\n에러내용 : " + rsp.error_msg;
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
