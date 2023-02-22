<template>
  <div class="card shadow-sm" @click="clickPage()">
    <img :src="item.skiImgUrl" alt="" class="img" />
    <div class="card-body">
      <p class="card-text">
        {{ item.skiName }}
      </p>
      <div class="d-flex justify-content-between align-items-center">
        <small class="text-muted">
          {{ item.skiAddress }}
        </small>
      </div>
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
