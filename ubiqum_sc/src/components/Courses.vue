<template>
  <div class="container">
    <div v-if="courses">
      <div v-for="(course, i) in courses.courses" :key="i">
        <h4>{{course.name}}</h4>
        <p>Duration {{course.duration}}</p>
        <p>Mentor {{course.mentor.firstname}} {{course.mentor.lastname}}</p>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["courses"])
  },
  created() {
    setTimeout(this.$store.dispatch("get", "courses"), 100);
  }
};
</script>

<style>
</style>