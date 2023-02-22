<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color: #053d68; font-family: 'Title_bold';">
          |
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color: #053d68; font-family: 'Title_bold';">
          예&nbsp;&nbsp;약
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

    <v-row class="mt-0">
      <v-col cols="3"></v-col>
      <v-col cols="6" class="mt-0 pt-0">
        <v-card class="mt-10" style="border-radius: 20px; border: 1px solid #053d68">
          <v-row>
            <v-col cols="12">
              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                  <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                    이용일자
                  </v-card-text>
                </v-col>
                <v-col cols="8">
                  <v-text-field class="mt-5" variant="outlined" type="date" v-model="reserDate"></v-text-field>
                </v-col>

              </v-row>
              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                  <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                    인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;원
                  </v-card-text>
                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px">
                  <v-catd-text style="font-size: larger">대인</v-catd-text>
                </v-col>
                <v-col cols="2.5" style="padding-left: 0px">
                  <v-text-field type="number" class="mt-5 ml-2" variant="outlined" v-model="num1"
                    suffix="인"></v-text-field>
                </v-col>
                <v-col cols="1"></v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px">
                  <v-catd-text style="font-size: larger">소인</v-catd-text>
                </v-col>
                <v-col cols="2.5" style="padding-left: 0px">
                  <v-text-field type="number" class="mt-5 ml-2" variant="outlined" v-model="num2"
                    suffix="인"></v-text-field>
                </v-col>
                <v-col cols="1"></v-col>
              </v-row>

              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                  <v-card-text class="mt-5 text-center" style="font-size: medium; font-weight: bold; color: #053d68">
                    장비 대여
                  </v-card-text>
                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px">
                  <v-catd-text style="font-size: larger">스키</v-catd-text>
                </v-col>
                <v-col cols="2.5" style="padding-left: 0px">
                  <v-text-field type="number" class="mt-5 ml-2" variant="outlined" v-model="num3"
                    suffix="개"></v-text-field>
                </v-col>
                <v-col cols="1"></v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px">
                  <v-catd-text style="font-size: larger">보드</v-catd-text>
                </v-col>
                <v-col cols="2.5" style="padding-left: 0px">
                  <v-text-field type="number" class="mt-5 ml-2" variant="outlined" v-model="num4"
                    suffix="개"></v-text-field>
                </v-col>
                <v-col cols="1"></v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-card>
        <br>
        <v-row>
          <v-col cols="4"></v-col>
          <v-col cols="3">
            <h3 class="text-right">총 {{ num1 * 25000 + num2 * 12000 + num3 * 15000 + num4 * 15000 }}  원</h3>
          </v-col>
          <v-col cols="3">
            <v-btn style="background-color:#053D68; color: white;" @click="onDetail()">예약</v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import { reactive } from "@vue/reactivity";
export default {
  name: "LessonHome",

  setup() {
    const state = reactive({
      items: [],
    });
    axios.get("http://localhost:8080/api/lesson/list", {
      headers: {
        'Authorization': 'Bearer ' + sessionStorage.getItem('id')
      }
    }).then((res) => {
      console.log(res.data);
      state.items = res.data;
    });
    return { state }
  },

  data() {
    return {
      num1: 0,
      num2: 0,
      num3: 0,
      num4: 0,
      tot: 0,
      reserDate: "this.$moment().format('YYYY-MM-DD')",
    };
  },

  methods: {
    onClick() {
      this.loading = true;

      setTimeout(() => {
        this.loading = false;
        this.loaded = true;
      }, 2000);
    },
    onDetail() {
      this.$store.commit("setReserDate", this.reserDate);
      this.$store.commit("setName", this.num1);
      this.$store.commit("setSmall", this.num2);
      this.$store.commit("setBoard", this.num3);
      this.$store.commit("setSki", this.num4);
      this.tot = this.num1 * 25000 + this.num2 * 12000 + this.num3 * 15000 + this.num4 * 15000;
      this.$store.commit("setTotal", this.tot);
      this.$router.push('/reservation/detail');
    },
    onTot() {

    },
  },
};
</script>

<style scoped></style>
