<template>
    <div class="home text-center" style="background-color: #BFDDF9;">
      <img :src="img" alt="" >
      <div class="album py-5 bg-light">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div class="col" v-for="(item, idx) in state.items" :key="idx">
              <card :item="item"> </card>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  <script>
  import Card from "@/components/Card.vue";
  import axios from "axios";
  import { reactive } from "@vue/reactivity";
  export default {
    components: { Card },
  
    name: "Home",
    setup() {
      

      const state = reactive({
        items: [],
      });
      
      axios.get("http://localhost:8080/api/skiRounge").then((res) => {
        console.log(res.data);
        state.items = res.data;
      });
  
      return { state };
    },

    data : ()=>({
    img : require('../../public/img/menulog.png')
  })
  };
  </script>
  
  <style></style>
  