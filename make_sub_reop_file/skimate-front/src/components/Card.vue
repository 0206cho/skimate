<template>
  <div class="card shadow-sm" @click="clickPage()">
    <img :src="item.skiImgUrl" alt="" class="img" />
    <div class="card-body">
      <p class="card-text" style="font-family:'Title_bold'; color: #053D68;">
        {{ item.skiName }}
      </p>
        <small class="card-text">
          {{ item.skiAddress }}
        </small>
    </div>
  </div>
</template>

<script>
import store from '@/scripts/store';
import router from '@/scripts/router';
export default {
  name: "Card",
  props: {
    item: Object,
  },
  setup(props) {
    const clickPage = () =>{
      store.commit('setSkiRoungeName', props.item)
      router.push({
        path : "/ski"
      })

    }

    return {clickPage}
  },
};
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}
</style>
