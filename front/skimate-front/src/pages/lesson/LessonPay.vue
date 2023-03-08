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
                  <div class="mx-10">2023-02-17</div>
                  <div class="mx-10">~</div>
                  <div class="mx-10">2023-02-17</div>
              </v-row>
              <v-row class="my-10">
                <div class="mx-10 mt-1">스키</div>
              </v-row>
              <v-row class="my-10">
                <div class="mx-10 mt-4">1000원</div>
              </v-row>
              <v-row class="my-11">
                <div class="mx-10 mt-4">초급 코스만 가능하며, 11시부터 16시까지만 강습 진행 예정입니다.</div>
              </v-row>
              
            </v-col>

          </v-row>

          <v-card-text class="end text-md-center">
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">목록으로</v-btn>
            <!--작성자만 표기-->
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">수정</v-btn>
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson">삭제</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>
  
<script>
export default {
  name: "LessonHome",
  methods: {
    onClick() {
      this.loading = true

      setTimeout(() => {
        this.loading = false
        this.loaded = true
      }, 2000)
    },
  },
};
</script>
  
<style scoped></style>
