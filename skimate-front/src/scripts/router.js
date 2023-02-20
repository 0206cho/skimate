import { createRouter, createWebHistory } from "vue-router";
import Home from "@/pages/Home";
import Login from "@/pages/Login";
import LessonHome from '../pages/lesson/LessonHome.vue';
import LessonWrite from '../pages/lesson/LessonWrite.vue';

import LessonDetail from '../pages/lesson/LessonDetail.vue';
import ReserHome from '../pages/reservation/ReserHome.vue';
import ReserDetail from '../pages/reservation/ReserDetail.vue';
import ReserDetail2 from '../pages/reservation/ReserDetail2.vue';


const routes = [
  { path: "/", component: Home },
  { path: "/login", component: Login },
  // 강습 메인페이지
  { path: "/lesson", component: LessonHome},
  // 강습 작성페이지
  { path: "/lesson/write", component: LessonWrite},
  // 강습 상세페이지
  { path: "/lesson/detail", component: LessonDetail},
  // 예약 메인페이지
  { path: "/reservation", component: ReserHome},
  // 예약 상세페이지
  { path: "/reservation/detail", component: ReserDetail, name: 'ReserDetail'},
  { path: "/reservation/detail2", component: ReserDetail2}
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
