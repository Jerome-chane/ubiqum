import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    courses: null,
    mentors: null,
    students: null
  },
  getters: {
    courses: state => state.courses,
    mentors: state => state.mentors,
    students: state => state.students
  },
  mutations: {
    setcourses: (state, payload) => (state.courses = payload),
    setmentors: (state, payload) => (state.mentors = payload),
    setstudents: (state, payload) => (state.students = payload)
  },
  actions: {
    get({ commit }, payload) {
      fetch(`/api/${payload}`)
        .then(data => data.json())

        .then(newData => {
          console.log(`${payload}`, newData);
          commit(`set${payload}`, newData);
        })
        .catch(error => console.log(error));
    }
  },
  modules: {}
});
