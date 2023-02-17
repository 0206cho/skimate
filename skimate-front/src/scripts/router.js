import { createRouter, createWebHistory } from "vue-router";
import Home from "@/pages/Home";
import Login from "@/pages/Login";
import LessonHome from '../pages/lesson/Home.vue';
import reserHome from '../pages/reservation/reser.vue';

const routes = [
  { path: "/", component: Home },
  { path: "/login", component: Login },
  // 강습 메인페이지
  { path: "/lesson", component: LessonHome},
  // 예약 메인페이지
  { path: "/reservation", component: reserHome}
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
