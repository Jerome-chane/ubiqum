package sc.example.ubiqum;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
public class StudentCourseMentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course course;

    public StudentCourseMentor(){}

    public StudentCourseMentor(Course course, Student student){

        this.course = course;
        this.student = student;
        student.addStudentCourseMentor(this);
        course.addStudentCourseMentor(this);

    }



    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }


    public void setStudent(Student student) {
        this.student = student;
    }


    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "StudentCourseMentor{" +
                "id=" + id +
//                ", date=" + date +
//                ", student=" + student +
                ", course=" + course +
                '}';
    }
}