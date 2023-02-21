<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">강&nbsp;&nbsp;습
        </h1>
      </v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold'">|
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="8">
        <v-divider style="border-color:#053D68;"></v-divider><!--=hr-->
        <v-row>
          <v-col cols="7"></v-col>
          <v-col cols="5">
            <v-row>
              <v-col cols="9">
                <v-card flat>
                  <v-card-text>
                    <v-text-field :loading="loading" density="compact" variant="solo" label="검색"
                      append-inner-icon="mdi-magnify" single-line hide-details
                      @click:append-inner="onClick"></v-text-field>
                  </v-card-text>
                </v-card>
              </v-col>
              <v-col cols="3" class="pt-7">
                <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;" to="/lesson/write">글쓰기</v-btn>
              </v-col>
            </v-row>
          </v-col>
        </v-row>

          <v-table fixed-header height="400px">
            <thead>
              <tr>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  순번
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  제목
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  구분
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  강습일
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  게시일
                </th>
              </tr>
            </thead>
            <tbody>
              <tr class="text-center" v-for="item in desserts" :key="item.name">
                <td>{{ item.no }}</td>
                <td>{{ item.title }}</td>
                <td>{{ item.category }}</td>
                <td>{{ item.lessonDate }}</td>
                <td>{{ item.date }}</td>
              </tr>
            </tbody>
          </v-table>

          <div class="album py-5 bg-light">
            <div class="container">
              <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <div class="col" v-for="(item, idx) in state.items" :key="idx">
                  <card :item="item"> </card>
                </div>
              </div>
            </div>
          </div>

      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>
  
<script>
import axios from "axios";
import { reactive } from "@vue/reactivity";
export default {
  name: "LessonHome",
  setup(){
    const state = reactive({
      items: [],
    });
    axios.get("/api/lesson").then((res) => {
      state.items = res.data;
    });
  },
  data () {
      return {
        desserts: [
          {
            no: 10,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 9,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 8,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 7,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 6,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 5,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 4,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 3,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 2,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
          {
            no: 1,
            title: '스키 강습 합니다.',
            category: '스키',
            lessonDate: '2022-02-21',
            date: '2022-02-20'
          },
        ],
      }
    },

    methods: {
      onClick () {
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