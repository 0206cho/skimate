<template>
  <v-container
    style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;"
  >
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          |
        </h1>
      </v-col>
      <v-col cols="6">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          결제
        </h1>
      </v-col>
      <v-col cols="1">
        <h1
          class="pt-12 px-0"
          style="
            display: flex;
            justify-content: center;
            color: #053d68;
            font-family: 'Title_bold';
          "
        >
          |
        </h1>
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>

    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="8">
        <v-divider style="border-color: #053d68"></v-divider
        ><!--=hr-->


        <div class="product_view">
							<h2>
							</h2>
							<table>
								<!--
								<caption>
									<details class="hide">
										<summary>상품정보</summary>
										판매가, 상품코드, 옵션 및 결제금액 안내
									</details>
								</caption>
								-->
								<colgroup>
									<col style="width: 173px;">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<th>판매가</th>
										<td class="price"></td>
									</tr>
									<!--
									<tr>
										<th>상품코드</th>
										<td>C004843</td>
									</tr>
									-->
									<tr>
										<th>브랜드</th>
										<td></td>
									</tr>
									<tr>
										<th>사이즈</th>
										<td></td>
									</tr>
									<!--
									<tr>
										<th>사이즈</th>
										<td>
											<div class="length">
												<input type="number" min="1" value="1"> <a href="#a">증가</a>
												<a href="#a">감소</a>
											</div>
										</td>
									</tr>
									-->
									<tr>
										<th>판매자</th>
										<td></td>
									</tr>
									<tr>
										<th>판매상태</th>
										<td></td>
									</tr>
									<!--
									<tr>
										<th>옵션선택</th>
										<td><select>
												<option>기본(+0)</option>
										</select></td>
									</tr>
									-->

									<tr>
										<th>등록날짜</th>
										<td></td>
									</tr>

									<tr>
										<th>결제금액</th>
										<td class="total"><b></b>원</td>
									</tr>
								</tbody>
							</table>



						</div>




      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "LessonHome",
  methods: {
    onClick() {
      this.loading = true;

      setTimeout(() => {
        this.loading = false;
        this.loaded = true;
      }, 2000);
    },
  },
};
</script>

<style scoped>

</style>
