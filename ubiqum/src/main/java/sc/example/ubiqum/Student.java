package sc.example.ubiqum;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName;
    private String lastName;
    private Integer age;

    @OneToMany(mappedBy="student", fetch=FetchType.EAGER)
    Set<StudentCourseMentor> studentCourseMentorHashSet = new HashSet<>();



    public Student() { }

    public Student(String first, String last, Integer age) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;

    }


    public Set<StudentCourseMentor> getStudentCourseMentorHashSet() {
        return studentCourseMentorHashSet;
    }
    public void addStudentCourseMentor(StudentCourseMentor studentCourseMentor){ this.studentCourseMentorHashSet.add(studentCourseMentor); }



    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
