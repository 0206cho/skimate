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
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                강습 비용
              </v-card-text>
              <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                기타 사항
              </v-card-text>
            </v-col>
            <v-col cols="10">
              <v-row>
                <v-col cols="5.5">
                  <v-text-field class="mt-5 ml-7" variant="outlined" type="date"></v-text-field>
                </v-col>
                <v-col cols="1" class="mt-8 text-md-center" style="margin:aoto">
                  <v-catd-text style="font-size: larger;">~</v-catd-text>
                </v-col>
                <v-col cols="5.5">
                  <v-text-field class="mt-5 mr-7" variant="outlined" type="date"></v-text-field>
                </v-col>
              </v-row>
              <v-text-field class="mx-7" variant="outlined" type="number" suffix="원"></v-text-field>
              <v-textarea class="mx-7" auto-grow variant="outlined" rows="3" row-height="25" rounded="true"></v-textarea>
            </v-col>

            <div class="accordion accordion-flush mx-10 mb-5" id="accordionFlushExample" style="width:100%;">
              <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne"
                    style="background-color: #BFDDF9;">
                    주의사항
                  </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
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
            <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;"
              to="/lesson/write">글쓰기</v-btn>
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
