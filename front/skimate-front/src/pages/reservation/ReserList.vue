<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="font-family:Title_bold; display: flex; justify-content: center; color:#053D68;">|
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style="font-family:Title_bold; display: flex; justify-content: center; color:#053D68;">
          예약 내역
        </h1>
      </v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="font-family:Title_bold; display: flex; justify-content: center; color:#053D68;">|
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

    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="6">
        <v-table fixed-header height="400px">
          <thead>
            <tr>
              <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                순번
              </th>
              <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                예약 인원
              </th>
              <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                예약일
              </th>
              <th class="text-center" style="font-weight: bold; background-color: #BFDDF9;">
                등록일
              </th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-center" v-for="(item, idx) in state.reservation" :key="idx">
              <td>{{ idx + 1 }}</td>
              <td>{{ item.reservation_pnum}}인</td>
              <td>{{ item.reservation_date}}</td>
              <td>{{ item.reservation_stdate}}</td>
            </tr>
          </tbody>
        </v-table>
      </v-col>
      <v-col cols="3"></v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import { reactive } from "@vue/reactivity";
export default {
  name: "ReserList",
  setup() {
    const state = reactive({
      reservation: [],
    });

    axios.get("http://localhost:8080/api/reservation/list", {
      headers: {
        'Authorization': 'Bearer ' + sessionStorage.getItem('id')
      }
    }).then((res) => {
      state.reservation = res.data;
      console.log(state.reservation.reservation_date);
    });

    return {
      state,
      //inc
      // remove
    }
  },
  data() {
    return {

    }
  },
};
</script>

<style scoped></style>