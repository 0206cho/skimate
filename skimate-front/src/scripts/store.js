import { createStore } from "vuex";

const store = createStore({


  state() {
    return {
      account: {
        id: 0,
      },
      Name: "홍길동",
      state: {
        name: '',
        job: ''
      },
    };
  },

  mutations: {
    setAccount(state, payload) {
      state.account.id = payload;
    },
    setName(state, data){
      state.name = data;
    }
  },
});

export default store;
