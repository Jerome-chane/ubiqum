<template>
  <div class="container">
    <p @click="getCourses" class="btn btn-warning">Courses</p>
    <div v-if="courses"></div>
    <p @click="getMentors" class="btn btn-warning">Mentors</p>
    <div v-if="mentors"></div>
    <p @click="getStudents" class="btn btn-warning">Students</p>
    <div v-if="students"></div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["courses", "mentors", "students"])
  },
  methods: {
    getCourses() {
      this.$store.dispatch("get", "courses");
    },
    getMentors() {
      this.$store.dispatch("get", "mentors");
    },
    getStudents() {
      this.$store.dispatch("get", "students");
    }
  }
};
</script>

<style>
</style>