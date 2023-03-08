<template>
  <footer class="text-muted py-5 mt-12" style="background-color: #BFDDF9; height: 400px;">
    <div class="container">
      <p class="float-end mb-1">
      </p>
      <v-row>
        <v-col cols="3"></v-col>
        <v-col cols="2" class="mt-8">
          <img :src="img" alt="logo" style="height:100px;"/>
        </v-col>
        <v-col cols="5">
          <div class="mt-5 text-center" style="font-size: larger; font-family: 'Title_bold'; color: black;">
            [ 스키장 플랫폼 ] &nbsp;&nbsp; SKIMATE
          </div>
          <div class="mt-4 text-center" style="line-height:210%; font-size: large; font-family: 'Title_bold'; color: #053D68;">
            김민솔 &nbsp; | &nbsp; 김종하 &nbsp; |  &nbsp; 정훈희 <br>
            https://github.com/skimate<br>
            
          </div>
        </v-col>
        <v-col cols="1"></v-col>
        <v-col cols="2"></v-col>
      </v-row>
      
      
    </div>
  </footer>
</template>

<script>
export default {
  name: "Footer",
  data : ()=>({
    img : require('../../public/img/footer.png')
  })
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
