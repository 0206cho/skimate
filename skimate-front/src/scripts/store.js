import { createStore } from "vuex";
import createPersistedState from 'vuex-persistedstate'

const store = createStore({


  state() {
    return {
      account: {
        memberId : ""
      },
      skiRounge: {
        skiName : ""
      },
      bigPerson: 0,
      smallPerson: 0,
      board: 0,
      ski: 0,
      tot: 0
    };
  },
  // state: {
  //   name: '',
  //   job: ''
  // },

  mutations: {
    setAccesToken(state, payload) {
      state.account.memberId = payload;
    },
    setSkiRoungeName(state, skiName) {
      state.skiRounge.skiName = skiName;
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
    setTotal(state, tot){
      state.tot = tot;
    }
  },
  plugins:[
    createPersistedState({
      
    })
  ]
});

export default store;
