<template>
  <div class="card shadow-sm">
    <img :src="item.imgPath" alt="" />
    <div class="card-body">
      <p class="card-text">
        {{ item.name }}
      </p>
      <div class="d-flex justify-content-between align-items-center">
        <button class="btn btn-primary">Buy</button>
        <small class="text-muted">
          {{ item.price }}
        </small>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Card",
  props: {
    item: Object,
  },
};
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
}
</style>
