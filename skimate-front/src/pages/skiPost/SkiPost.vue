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
                    @click="postWrite()">글쓰기</v-btn>
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
                  등록자
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  조회수
                </th>
                <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                  등록일
                </th>
              </tr>
            </thead>
            <tbody>
              <tr class="text-center" v-for="(item, idx) in state.lesson" :key="idx" @click="postView(item.postId)">
                <td>{{ idx+1 }}</td>
                <td>{{ item.postTitle }}</td>
                <td>{{ item.memberId }}</td>
                <td>{{ item.postClick }}</td>
                <td>{{ item.date }}</td>
              </tr>
            </tbody> 
          </v-table>
        </v-col>
        <v-col cols="2"></v-col>
      </v-row>
    </v-container>
  </template>
    
  <script>
  import axios from "axios";
  import { reactive } from "@vue/reactivity";
  import router from "@/scripts/router";
import store from '@/scripts/store';
  export default {
    name: "PostHome",
    setup() {
      const state = reactive({
        lesson: [],
      });
      
      
      axios.get(("http://localhost:8080/skiPost/"+store.state.skiRounge.skiId)).then((res) => {
        state.lesson = res.data;
      });

      const postWrite = () =>{
        if(!sessionStorage.getItem('id')){
            router.push({path:"/login"})
        }else{
            router.push({path:"/skiPostWrite"})
        }
      }

      const postView = (postId) =>{
        store.commit("setPostDetail", postId)
        router.push({path:"/skiPostView"})

      }
  
  
      return { 
        state,
        postWrite,
        postView 
        // remove 
      }
    }
  };
  </script>
    
  <style scoped></style>
