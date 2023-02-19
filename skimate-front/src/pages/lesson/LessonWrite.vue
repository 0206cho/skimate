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
            <v-expansion-panels class="mx-10 mb-5" multiple>
              <v-expansion-panel color="#BFDDF9" title="주의 사항"
                text="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."></v-expansion-panel>
            </v-expansion-panels>

          </v-row>

          <v-card-text class="end text-md-right">
            <v-btn class="mr-3 mb-3" color="#BFDDF9" to="/lesson/write">글쓰기</v-btn>
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
