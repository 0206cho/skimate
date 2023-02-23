import { createStore } from "vuex";
import createPersistedState from 'vuex-persistedstate'
const store = createStore({


  state() {
    return {
      account: {
        memberId : ""
      },
      skiRounge: {
        skiName : "",
        skiId : 0
      },
      bigPerson: 0,
      smallPerson: 0,
      board: 0,
      ski: 0,
      tot: 0,
      reserDate: "",
      lessonDetail: 0,
      postDetail:0
    };
  },
  mutations: {
    setAccesToken(state, payload) {
      state.account.memberId = payload;
    },
    setSkiRoungeName(state, item) {
      state.skiRounge.skiName = item.skiName;
      state.skiRounge.skiId = item.skiNum;
    },
    setName(state, big){
      state.bigPerson = big;
    },
    setSmall(state, small){
      state.smallPerson = small;
    },
    setBoard(state, board){
      state.board = board;
    },
    setSki(state, ski){
      state.ski = ski;
    },
    setReserDate(state, date){
      state.reserDate = date;
    },
    setTotal(state, tot){
      state.tot = tot;
    },
    setLessonDetail(state, detail){
      state.lessonDetail = detail;
    },
    setPostDetail(state, detail){
      state.postDetail = detail;
    }
  },
  plugins:[
    createPersistedState({

    })
  ]
});

export default store;
