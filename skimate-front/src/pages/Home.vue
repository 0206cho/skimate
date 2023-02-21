<template>
  <div class="home">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          
        </div>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  name: "Home",
  setup() {
    const state = reactive({
      items: [],
    });
    axios.get("/api/items").then((res) => {
      state.items = res.data;
    });
    return { state };
  },
};
</script>

<style></style>
