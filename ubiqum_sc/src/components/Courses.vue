<template>
  <div class="container">
    <img src="../assets/u.png" />
    <img class="B" src="../assets/B.png" />
    <div v-if="courses">
      <div v-for="(course, i) in courses.courses" :key="i">
        <h4>
          {{course.name}}
          <img
            class="logo"
            v-if="course.name == 'Web Development JavaScript'"
            src="../assets/js.png"
          />
          <img
            class="logo"
            v-if="course.name == 'Web Development with Java'"
            src="../assets/java.png"
          />
          <img
            class="logo"
            v-if="course.name == 'Data Analytics Course & Machine Learning'"
            src="../assets/data.jpg"
          />
        </h4>

        <br />
        <h6>{{course.content}}</h6>
        <p>Duration {{course.duration}}</p>
        <p>Mentor:</p>
        <img class="avatar" :src="course.mentor.photo" />
        <p>{{course.mentor.firstname}} {{course.mentor.lastname}}</p>

        <p @click="setShow">
          <b>Enrolled Students</b>
        </p>
        <div v-if="show">
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <!-- <th>Action</th> -->
              </tr>
              <tr v-for="(s, i) in course.Students" :key="i">
                <td>{{s.firstName}}</td>
                <td>{{s.lastName}}</td>
                <td>{{s.age}}</td>
                <!-- <td>
                  <span @click="remove(s.id)">Remove</span>
                </td>-->
              </tr>
            </thead>
          </table>
          <p @click="setHide">hide</p>
        </div>
        <button class="btn btn-warning" @click="showEditMode">Edit</button>
        <div v-if="edit">
          <br />
          <!-- <div>
            <p @click="addStudent">Add Student</p>
            <div></div>
          </div>-->

          <p>Change Mentor</p>
        </div>
        <hr />
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data: () => {
    return {
      show: false,
      edit: false
    };
  },
  computed: {
    ...mapGetters(["courses", "students"])
  },
  methods: {
    remove(student) {
      console.log(student);
      this.$store.dispatch("removeStudent", student);
    },
    addStudent() {},
    showEditMode() {
      this.edit = true;
    },
    hideEditMode() {
      this.edit = false;
    },
    setHide() {
      this.show = false;
    },
    setShow() {
      this.show = true;
    }
  },
  created() {
    setTimeout(this.$store.dispatch("get", "courses"), 100);
    setTimeout(this.$store.dispatch("get", "students"), 100);
  }
};
</script>

<style>
img.B {
  max-width: 715px;
}
img.avatar {
  max-height: 100px;
  margin: 15px;
}
img.logo {
  height: 100px;
}
</style>