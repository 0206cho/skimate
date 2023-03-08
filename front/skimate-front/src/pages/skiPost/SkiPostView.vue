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
            공&nbsp;&nbsp;지&nbsp;&nbsp;사&nbsp;&nbsp;항
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
                  제목
                </v-card-text>
                <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                  작성자
                </v-card-text>
                <v-card-text class="mx-5 mt-7" style="font-size: medium; font-weight: bold; color:#053D68">
                  작성일
                </v-card-text>
                <v-card-text class="mx-5 my-5" style="font-size: medium; font-weight: bold; color:#053D68">
                  내용
                </v-card-text>
              </v-col>
  
              <v-col cols="10">
  
                <v-row class="my-9">
                    <div class="mx-10">{{ state.lesson.postTitle }}</div>
                </v-row>
                <v-row class="my-10">
                  <div class="mx-10 mt-4">{{ state.lesson.memberId }}</div>
                </v-row>
                <v-row class="my-11">
                  <div class="mx-10 mt-4">{{ state.lesson.date }}</div>
                </v-row>
                <v-row class="my-10">
                  <div class="mx-10 mt-1">{{ state.lesson.postContent }}</div>
                </v-row>
  
              </v-col>
  
            </v-row>
  
            <v-card-text class="end text-md-center">
              <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/skiPost">목록으로</v-btn>
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
  //import { useStore } from "vuex";
  import axios from "axios";
  import { reactive } from "@vue/reactivity";
  export default {
    name: "LessonHome",
    data(){
      return {
  
      }
    },
    mounted(){
      const store = useStore();
      const storeLessonDetail = computed(() => store.state.postDetail);
      this.detail(storeLessonDetail.value);
    },
  
  setup(){
  
    //const store = useStore();
    //const storeLessonDetail = computed(() => store.state.lessonDetail);
  
    //console.log("김민솔 : " + storeLessonDetail.value)
  
    const state = reactive({
        lesson: []
      });
  
  
    const detail = (storeLessonDetail) => {
        axios.get(`http://localhost:8080/post/detail/${storeLessonDetail}`, {
            headers: {
              'Authorization': 'Bearer ' + sessionStorage.getItem('id')
            }
          })
          .then((res) => {
            console.log("????")
            console.log(res.data)
            state.lesson = res.data;
            console.log(state.lesson)
          })
          .catch(() => {
          });
      }
  
      return {
        detail,
        state
        //storeLessonDetail
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
    },
  };
  </script>
  
  <style scoped></style>
  