package sc.example.ubiqum;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String duration;
    private String content;



    @OneToMany(mappedBy="course", fetch=FetchType.EAGER)
    Set<StudentCourseMentor> studentCourseMentorHashSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mentor_id")
    private Mentor mentor;


    public Set<StudentCourseMentor> getStudentCourseMentorHashSet() {
        return studentCourseMentorHashSet;
    }

    public Course() { }


    public Course(String name, String content, String duration, Mentor mentor) {
        this.name = name;
        this.content = content;
        this.duration = duration;
        this.mentor = mentor;
        mentor.addCourse(this);

    }


    public void addStudentCourseMentor(StudentCourseMentor studentCourseMentor){ this.studentCourseMentorHashSet.add(studentCourseMentor); }

    public Mentor getMentor() {
        return mentor;
    }

    public long getId() {
        return id;
    }


    public String getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", lastName='" + content + '\'' +
                '}';
    }
}
