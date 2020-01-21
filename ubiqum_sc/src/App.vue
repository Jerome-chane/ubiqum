<template>
  <div id="app">
    <!-- <Home></Home> -->
    <div id="nav">
      <router-link to="/">Home</router-link>|
      <router-link to="/courses">Courses</router-link>|
      <router-link to="/mentors">Mentors</router-link>|
      <router-link to="/students">Students</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import Home from "./components/Home.vue";
export default {
  components: { Home }
};
</script>
<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
