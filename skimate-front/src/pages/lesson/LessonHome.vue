<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:Title_bold;">|
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
        <v-row>
          <v-col cols="7"></v-col>
          <v-col cols="5">
            <v-row>
              <v-col cols="9">
                <v-card flat>
                  <v-card-text>
                  </v-card-text>
                </v-card>
              </v-col>
              <v-col cols="3" class="pt-7">
                <v-btn class="white--text mr-3 mb-3" style="background-color:#053D68; color: white;"
                  to="/lesson/write">글쓰기</v-btn>
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
              <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                상세보기
              </th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-center" v-for="(item, idx) in state.lesson" :key="idx">
              <td>{{ item.lessonId }}</td>
              <td>{{ item.lesson_title }}</td>
              <td>{{ item.lesson_category }}</td>
              <td>{{ item.lesson_lsdate }}</td>
              <td>{{ item.lesson_date }}</td>
              <td><v-btn class="white--text" style="background-color:#053D68; color: white;"
                  @click="detail (item.lessonId)">더보기</v-btn></td>
            </tr>
          </tbody>
        </v-table>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>

<script>
import { useStore } from "vuex";
import axios from "axios";
import { reactive } from "@vue/reactivity";
import router from "@/scripts/router";
export default {
  name: "LessonHome",
  setup() {

    const store = useStore();
    //store.commit("setLessonDetail",1);


    const state = reactive({
      lesson: [],
    });

    axios.get("http://localhost:8080/api/lesson/list", {
      headers: {
        'Authorization': 'Bearer ' + sessionStorage.getItem('id')
      }
    }).then((res) => {
      state.lesson = res.data;
    });

    // const remove = (lessonId) => {
    //   axios.delete(`http://localhost:8080/api/lesson/delete/${lessonId}`).then(() => {
    //     // load();
    //   })
    // }


    const detail = (lessonId) => {
      store.commit("setLessonDetail",lessonId);
      router.push({ path: `/lesson/detail` });
    }
    return {
      state,
      detail,
      //inc
      // remove
    }
  },
  data() {
    return {

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