<template>
  <div class="container">
    <img src="../assets/u.png" />
    <div v-if="mentors">
      <div v-for="(mentor, i) in mentors.mentors" :key="i">
        <h4>{{mentor.firstname}} {{mentor.lastname}}</h4>
        <img class="img" :src="mentor.photo" />
        <p>Age {{mentor.age}}</p>
        <p>Expert in {{mentor.speciality}}</p>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["mentors"])
  },
  created() {
    setTimeout(this.$store.dispatch("get", "mentors"), 100);
  }
};
</script>

<style scoped>
.container img {
  max-height: 100px;
}
</style>