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
          결제
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
                이용 일자
              </v-card-text>
              <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                인 원
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                장비 대여
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                스키장
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
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
                  <p></p>
                </v-col>
                <v-col cols="1">
                  <p>소인</p>
                </v-col>
                <v-col cols="5">
                  <p> </p>
                </v-col>
              </v-row>
              <v-row class="my-11">
                <v-col cols="1">
                  <p>스키</p>
                </v-col>
                <v-col cols="5">
                  <p></p>
                </v-col>
                <v-col cols="1">
                  <p>보드</p>
                </v-col>
                <v-col cols="5">
                  <p></p>
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
      <v-btn color="#BFDDF9" to="/lesson/write">결제</v-btn>

    </v-col>
      </v-row>
  </v-container>
</template>

<script>

export default {
  name: 'ReserDetail',
         setup() {
        }
  };
</script>

<style scoped></style>
