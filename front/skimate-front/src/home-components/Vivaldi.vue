<template>
<div>
    <div v-if="$store.state.skiRounge.skiId==1">
        <div class="text-center">
            <img class="imgA" src="/img/vivaldi_03.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/vivaldi_01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/vivaldi_02.png" alt="">
        </div>
    </div>


    <div v-if="$store.state.skiRounge.skiId==2">
        <div class="text-center">
            <img class="imgA" src="/img/hione_01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/hione_02.png" alt="">
        </div>
    </div>

    <div v-if="$store.state.skiRounge.skiId==3">
        <div class="text-center">
            <img class="imgA" src="/img/youngpeong01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/youngpeong02.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/youngpeong03.png" alt="">
        </div>
    </div>

    <div v-if="$store.state.skiRounge.skiId==4">
        <div class="text-center">
            <img class="imgA" src="/img/wilyhily_01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/wilyhily_02.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/wilyhily_03.png" alt="">
        </div>
    </div>

    <div v-if="$store.state.skiRounge.skiId==5">
        <div class="text-center">
            <img class="imgA" src="/img/muju_01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/muju_02.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/muju_03.png" alt="">
        </div>
    </div>

    <div v-if="$store.state.skiRounge.skiId==6">
        <div class="text-center">
            <img class="imgA" src="/img/gonjiam_01.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/gonjiam_02.png" alt="">
        </div>
        <div class="text-center">
            <img class="imgA" src="/img/gonjiam_03.png" alt="">
        </div>
    </div>
</div>
  
</template>

<script>
export default {

}
</script>

<style scope>
.imgA{
    
    width: 1000px;
    height: 700px;
}
</style>