<template>
  <div>
    <div v-if="students">
      <div>
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Age</th>
              <!-- <th>Action</th> -->
              <th>Course</th>
            </tr>
            <tr v-for="(s, i) in students.student" :key="i">
              <td>{{s.firstName}}</td>
              <td>{{s.lastName}}</td>
              <td>{{s.age}}</td>
              <td>
                <p v-for="(c,e) in s.course" :key="e">{{c.name}}</p>
              </td>
              <!-- <td>
                <span @click="deleteStudent(s)">Remove</span>
              </td>-->
            </tr>
          </thead>
        </table>

        <button v-if="!show" @click="showForm">Add Student</button>
        <form v-if="show">
          <span>
            Firstname:
            <input
              placeholder="firstname..."
              v-model="student.firstName"
              required="required"
              minlength="3"
            />
          </span>
          <span>
            Lastname:
            <input
              placeholder="lastname..."
              v-model="student.lastName"
              required="required"
              minlength="3"
            />
          </span>
          <span>
            Age :
            <input
              placeholder="age..."
              type="number"
              v-model="student.age"
              required="required"
              minlength="1"
            />
          </span>

          <span>
            Email address:
            <input
              placeholder="email..."
              v-model="student.email"
              required="required"
              minlength="3"
            />
          </span>

          <input type="submit" value="Add new Student" @click="check" class="btn btn-warning" />
          <!-- <button @click="check" class="btn btn-warning">Create Account</button> -->
          <button @click="hideForm" class="btn btn-danger">Cancel</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      show: false,
      student: {
        firstName: "",
        lastName: "",
        age: "",
        email: ""
      }
    };
  },
  methods: {
    deleteStudent(s) {
      this.$store.dispatch("deleteStudent", s);
    },
    check(event) {
      if (
        this.student.firstName.length >= 3 &&
        this.student.lastName.length >= 3 &&
        this.student.email.length >= 3 &&
        this.student.age.length >= 1
      ) {
        event.preventDefault();
        this.$store.dispatch("addStudent", this.student);
      } else {
        console.log("denied");
      }
    },
    hideForm() {
      this.show = false;
    },
    showForm() {
      this.show = true;
    },
    addStudent() {}
  },
  computed: {
    ...mapGetters(["students"])
  },
  created() {
    setTimeout(this.$store.dispatch("get", "students"), 100);
  }
};
</script>

<style>
</style>