import { createStore } from "vuex";

const store = createStore({


  state() {
    return {
      account: {
        id: 0,
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
    setAccount(state, payload) {
      state.account.id = payload;
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
});

export default store;
