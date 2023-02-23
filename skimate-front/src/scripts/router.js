import { createRouter, createWebHistory } from "vue-router";
import Home from "@/pages/Home";
import Main from "@/pages/Main"
import Login from "@/pages/Login";
import LessonHome from '../pages/lesson/LessonHome.vue';
import LessonWrite from '../pages/lesson/LessonWrite.vue';
import SocialRedirect from '@/components/SocialRedirect.vue'
import LessonDetail from '../pages/lesson/LessonDetail.vue';
import LessonPay from '../pages/lesson/LessonPay.vue';
import Join from '../pages/Join.vue'
import ReserHome from '../pages/reservation/ReserHome.vue';
import ReserDetail from '../pages/reservation/ReserDetail.vue';
import InfoUpdate from "../pages/MemberInfoUpdate.vue";
import SkiPost from "../pages/skiPost/SkiPost.vue"
import SkiPostWriter from "../pages/skiPost/SkiPostWrite.vue"
import Calendar from '../pages/lesson/Calendar.vue';
import SkiPostView from '../pages/skiPost/SkiPostView.vue'
import SetMemberRole from '../components/SetMemberRole.vue'

const routes = [
  { path: "/", name : 'Main', component: Main},
  { path: "/oauth/redirect", component: SocialRedirect },
  { path: "/memberInfoUdate", component: InfoUpdate },
  { path: "/ski", name : 'ski' ,component: Home },
  { path: "/setMemberRole" ,component: SetMemberRole },
  { path: "/skiPost", name : 'skiPost' ,component: SkiPost },
  { path: "/skiPostWrite", name : 'skiPostWriter' ,component: SkiPostWriter },
  { path: "/skiPostView", name : 'skiPostView' ,component: SkiPostView },
  { path: "/login", component: Login },
  { path: "/join", component: Join },
  // 강습 메인페이지
  { path: "/lesson", component: LessonHome},
  // 강습 작성페이지
  { path: "/lesson/write", component: LessonWrite},
  // 강습 상세페이지
  { path: "/lesson/detail", component: LessonDetail},
  // 강습 결제페이지
  { path: "/lesson/pay", component: LessonPay},
  // 예약 메인페이지
  { path: "/reservation", component: ReserHome},
  // 예약 상세페이지
  { path: "/reservation/detail", component: ReserDetail, name: 'ReserDetail'},
  // 풀캘린더 테스트
  { path: "/calendar", component: Calendar},
];

const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
