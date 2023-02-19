<template>
  <v-container style="height=100%; width: 100%; padding-left: 50px; padding-right: 50px;">
    <!--제목-->
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="1">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">|
        </h1>
      </v-col>
      <v-col cols="6">
        <h1 class="pt-12 px-0" style="display: flex; justify-content: center; color:#053D68; font-family:'Title_bold';">강&nbsp;&nbsp;습
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
                    <v-text-field :loading="loading" density="compact" variant="solo" label="검색"
                      append-inner-icon="mdi-magnify" single-line hide-details
                      @click:append-inner="onClick"></v-text-field>
                  </v-card-text>
                </v-card>
              </v-col>
              <v-col cols="3" class="pt-7">
                <v-btn color="#BFDDF9" to="/lesson/write">글쓰기</v-btn>
              </v-col>
            </v-row>
          </v-col>
        </v-row>

        <v-data-table :headers="headers" :items="desserts" item-value="name" class="elevation-1">
          <template v-slot:item="{ item }">
            <tr>
              <td>{{ item.columns.name }}</td>
              <td>{{ item.columns.calories }}</td>
              <td>{{ item.columns.fat }}</td>
              <td>{{ item.columns.carbs }}</td>
              <td>{{ item.columns.protein }}</td>
              <td>{{ item.columns.iron }}</td>
            </tr>
          </template>
        </v-data-table>

      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
  </v-container>
</template>
  
<script>
export default {
  name: "LessonHome",
  data: () => ({
      loaded: false,
      loading: false,
      selected: [],
      headers: [
        {
          title: 'Dessert (100g serving)',
          align: 'start',
          sortable: false,
          key: 'name',
        },
        { title: 'Calories', key: 'calories' },
        { title: 'Fat (g)', key: 'fat' },
        { title: 'Carbs (g)', key: 'carbs' },
        { title: 'Protein (g)', key: 'protein' },
        { title: 'Iron (%)', key: 'iron' },
      ],
      desserts: [
        {
          name: 'Frozen Yogurt',
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: 1,
        },
        {
          name: 'Ice cream sandwich',
          calories: 237,
          fat: 9.0,
          carbs: 37,
          protein: 4.3,
          iron: 1,
        },
        {
          name: 'Eclair',
          calories: 262,
          fat: 16.0,
          carbs: 23,
          protein: 6.0,
          iron: 7,
        },
        {
          name: 'Cupcake',
          calories: 305,
          fat: 3.7,
          carbs: 67,
          protein: 4.3,
          iron: 8,
        },
        {
          name: 'Gingerbread',
          calories: 356,
          fat: 16.0,
          carbs: 49,
          protein: 3.9,
          iron: 16,
        },
        {
          name: 'Jelly bean',
          calories: 375,
          fat: 0.0,
          carbs: 94,
          protein: 0.0,
          iron: 0,
        },
        {
          name: 'Lollipop',
          calories: 392,
          fat: 0.2,
          carbs: 98,
          protein: 0,
          iron: 2,
        },
        {
          name: 'Honeycomb',
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          iron: 45,
        },
        {
          name: 'Donut',
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          iron: 22,
        },
        {
          name: 'KitKat',
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          iron: 6,
        },
      ],

    }),

    methods: {
      onClick () {
        this.loading = true

        setTimeout(() => {
          this.loading = false
          this.loaded = true
        }, 2000)
      },
    },
};
</script>
  
<style scoped></style>
