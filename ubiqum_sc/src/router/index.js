import Vue from "vue";
import VueRouter from "vue-router";
import Hello from "../views/Home.vue";
import Home from "../components/Home.vue";
import Library from "../components/Library.vue";
import Mentors from "../components/Mentors.vue";
import Courses from "../components/Courses.vue";
import Students from "../components/Students.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/hello",
    name: "Hello",
    component: Hello
  },
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/courses",
    name: "Courses",
    component: Courses
  },
  {
    path: "/library",
    name: "Library",
    component: Library
  },
  {
    path: "/students",
    name: "Students",
    component: Students
  },
  {
    path: "/mentors",
    name: "Mentors",
    component: Mentors
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
