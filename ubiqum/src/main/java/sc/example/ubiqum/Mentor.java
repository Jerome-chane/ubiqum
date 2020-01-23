package sc.example.ubiqum;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName;
    private String lastName;
    private String speciality;
    private Integer age;
    private String photo;
private String email;


    @OneToMany(mappedBy="mentor", fetch=FetchType.EAGER)
    Set<Course> courses = new HashSet<>();



    public Mentor() { }

    public Mentor(String first, String last, String email, Integer age, String speciality) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;
        this.speciality = speciality;
        this.email = email;
    }

    public void addPhoto(String link){
        this.photo = link;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){ this.courses.add(course); }


    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
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

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
//                ", age=" + age +
//                ", courses=" + courses +
                '}';
    }
}