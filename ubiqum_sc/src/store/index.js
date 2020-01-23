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
    },
    addStudent({ commit, dispatch }, payload) {
      let ourData = {
        firstName: payload.firstName,
        lastName: payload.lastName,
        email: payload.email,
        age: payload.age
      };

      fetch(`/api/addStudent`, {
        credentials: "include",
        headers: {
          "Content-Type": "application/json"
        },
        method: "POST",

        body: JSON.stringify(ourData)
      })
        .then(newData => {
          // console.log("data sent: ", JSON.stringify(ourData));
          return newData.json();
        })
        .then(data => {
          if (data.hasOwnProperty("error")) {
            console.log(" error: ", data);
            // commit("setUserAlreadyExist", true);
          } else {
            // commit("setUserAlreadyExist", false);
            dispatch("get", "students");
          }
        })
        .catch(error => {
          console.log("Request failure: ", error);
        });
    },

    deleteStudent({ commit, dispatch }, payload) {
      let ourData = {
        firstName: payload.firstName,
        lastName: payload.lastName,
        email: payload.email,
        age: payload.age
      };
      console.log("delete", JSON.stringify(ourData));

      fetch(`/api/deleteStudent`, {
        credentials: "include",
        headers: {
          "Content-Type": "application/json"
        },
        method: "POST",

        body: JSON.stringify(ourData)
      })
        .then(newData => {
          // console.log("data sent: ", JSON.stringify(ourData));
          return newData.json();
        })
        .then(data => {
          console.log(data);

          if (data.hasOwnProperty("error")) {
            console.log(" error: ", data);
            // commit("setUserAlreadyExist", true);
          } else {
            dispatch("get", "students");
          }
        })
        .catch(error => {
          console.log("Request failure: ", error);
        });
    }

    // removeStudentFromCourse({ commit, dispatch }, payload) {
    //   let ourData = {
    //     firstName: payload.firstName,
    //     lastName: payload.lastName,
    //     email: payload.email,
    //     age: payload.age
    //   };

    //   fetch(`/api/removeStudentFromCourse`, {
    //     credentials: "include",
    //     headers: {
    //       "Content-Type": "application/json"
    //     },
    //     method: "POST",

    //     body: JSON.stringify(ourData)
    //   })
    //     .then(newData => {
    //       return newData.json();
    //     })
    //     .then(data => {
    //       if (data.hasOwnProperty("error")) {
    //         console.log(" error: ", data);
    //       } else {
    //         dispatch("get", "courses");
    //       }
    //     })
    //     .catch(error => {
    //       console.log("Request failure: ", error);
    //     });
    // },
  },
  modules: {}
});
