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
          세부예약
        </h1>
      </v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">|
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="6">
        <v-divider style="border-color:#053D68;"></v-divider><!--=hr-->

        <v-card class="mt-10" style="border-radius:20px; border: 1px solid #053D68">
          <v-row>
            <v-col cols="12">
              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                이용일자
              </v-card-text>
             </v-col>
                <v-col cols="2" style="padding-right: 0px">
                  <v-text-field class="mt-5 ml-7" variant="outlined" ></v-text-field>

                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="">
                  <v-catd-text style="font-size: larger;">년</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-right: 0px;padding-left:0px">
                  <v-text-field class="mt-5 ml-7" variant="outlined" ></v-text-field>

                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px;width:10px">
                  <v-catd-text style="font-size: larger;width:10px" >월</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-right: 0px">
                  <v-text-field class="mt-5 ml-7" variant="outlined" ></v-text-field>

                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="">
                  <v-catd-text style="font-size: larger;">일</v-catd-text>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                <v-card-text class="mx-5 mt-3" style="font-size: medium; font-weight: bold; color:#053D68">
                인 원
              </v-card-text>
               </v-col>
               <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px;">
                  <v-catd-text style="font-size: larger;">대인</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-left: 0px;" >
                  <v-text-field class="mt-5 ml-2" variant="outlined" ></v-text-field>

                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px;">
                  <v-catd-text style="font-size: larger;">소인</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-left: 0px;" >
                  <v-text-field class="mt-5 ml-2" variant="outlined" ></v-text-field>
                </v-col>

              </v-row>

              <v-row>
                <v-col cols="3" style="padding-right: 0px">
                <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                장비 대여
              </v-card-text>
             </v-col>
             <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px;">
                  <v-catd-text style="font-size: larger;">대인</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-left: 0px;" >
                  <v-text-field class="mt-5 ml-2" variant="outlined" ></v-text-field>

                </v-col>
                <v-col cols="1" class="mt-8 text-md-left" style="padding-right: 0px;">
                  <v-catd-text style="font-size: larger;">소인</v-catd-text>
                </v-col>
                <v-col cols="2" style="padding-left: 0px;" >
                  <v-text-field class="mt-5 ml-2" variant="outlined" ></v-text-field>
                </v-col>

              </v-row>
            </v-col>

          </v-row>
        </v-card>
        <v-row>
          <v-col cols="5"></v-col>
          <v-col cols="7">
            <v-row>
              <v-col cols="1" style="margin-top:13px">
                <h3>총</h3>
              </v-col>
              <v-col cols="3" style="margin-top:13px">
                <h3>230000</h3>
              </v-col>
              <v-col cols="5" style="margin-top:13px">
                <h3>원</h3>
              </v-col>
              <v-col cols="3" class="pt-7">
                <v-btn color="#BFDDF9" to="/lesson/write">예약</v-btn>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="3"></v-col>
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
