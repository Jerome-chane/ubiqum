<template>
  <div>
    <!-- <h1>Welcome to Ubiqum Academy</h1> -->
    <img src="../assets/u.png" />
    <img class="thumb" src="../assets/A.png" />
    <button @click="goTo" class="btn ubiqum">
      <b>Explore our Programs >>></b>
    </button>
  </div>
</template>

<script>
export default {
  methods: {
    goTo() {
      if (this.$router.currentRoute.name != "Courses") {
        this.$router.push("/courses");
      }
    }
  }
};
</script>

<style>
img.thumb {
  /* padding-top: 80px; */
  max-width: fit-content;
  width: 100%;
  bottom: 0;
  top: 0;
  margin: 0;
}
button.ubiqum {
  background: #f44336;
  color: #fff;
  position: relative;
  bottom: 29px;
  left: 15px;
  right: 15px;
  width: calc(100% - 30px);
  border-radius: 37px;
  height: 53px;
}
</style>