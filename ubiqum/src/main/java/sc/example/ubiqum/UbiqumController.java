package sc.example.ubiqum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UbiqumController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    StudentCourseMentorRepository studentCourseMentorRepository;


    @RequestMapping("/api/courses")
    public Map<String, Object> getCourses() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("courses", courseRepository.findAll().stream().map(course -> CourseDTO(course)).collect(Collectors.toList()));
        return dto;
    }


    @RequestMapping("/api/mentors")
    public Map<String, Object> getMentors() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("mentors", mentorRepository.findAll().stream().map(mentor -> MentorsDTO(mentor)).collect(Collectors.toList()));
        return dto;
    }

    @RequestMapping("/api/students")
    public Map<String, Object> getStudent() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("student", studentRepository.findAll().stream().map(student -> StudentsDTO(student)).collect(Collectors.toList()));
        return dto;
    }

    private Map<String, Object> CourseDTO(Course course) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("_id", course.getId());
        dto.put("name", course.getName());
        dto.put("content", course.getContent());
        dto.put("duration", course.getDuration());
        dto.put("mentor", MentorsDTO(course.getMentor()));
        dto.put("Students", course.getStudentCourseMentorHashSet().stream().map(s -> StudentsCDTO(s.getStudent())));
        return dto;
    }

    private Map<String, Object> MentorsDTO(Mentor mentor) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("photo", mentor.getPhoto());
        dto.put("firstname", mentor.getFirstName());
        dto.put("lastname", mentor.getLastName());
        dto.put("age", mentor.getAge());
        dto.put("speciality", mentor.getSpeciality());

        return dto;
    }
    private Map<String, Object> StudentsCDTO(Student student) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", student.getId());
        dto.put("firstName", student.getFirstName());
        dto.put("lastName", student.getLastName());
        dto.put("age", student.getAge());
        dto.put("email", student.getEmail());
        return dto;
    }

    private Map<String, Object> StudentsDTO(Student student) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", student.getId());
        dto.put("firstName", student.getFirstName());
        dto.put("lastName", student.getLastName());
        dto.put("age", student.getAge());
        dto.put("email", student.getEmail());
        dto.put("course",student.getStudentCourseMentorHashSet().stream().map(a->CourseDTO(a.getCourse())));

        return dto;
    }

    private Map<String, Object> StudentCourseDTO(Course course) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("name", course.getName());
        dto.put("mentor", course.getMentor());
        dto.put("duration", course.getDuration());
        return dto;
    }



    @RequestMapping(value = "/api/deleteStudent", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> deleteStudent(@RequestBody Student student) {
        

        if ( studentRepository.findByEmail(student.getEmail()) == null) {
            return new ResponseEntity<>(makeMap("Error", "Not Found"), HttpStatus.CONFLICT);
        }

        studentRepository.deleteById(student.getId());
        return new ResponseEntity<>(makeMap("Success", "Student Successfully Deleted"), HttpStatus.ACCEPTED);
    }



    @RequestMapping(value = "/api/addStudent", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student) {
        Student s = studentRepository.findByEmail(student.getEmail());
        System.out.println(s);
        if (s != null) {
            System.out.println("Student found" + s);
            return new ResponseEntity<>(makeMap("error", "Student already exists"), HttpStatus.CONFLICT);
        }

        if (s == null) {
            Student newStudent = new Student(student.getFirstName(), student.getLastName(), student.getEmail(), student.getAge());
            studentRepository.save(newStudent);
            System.out.println("Player saved: " + newStudent);
        }
        return new ResponseEntity<>(makeMap("success", "Name Added"), HttpStatus.CREATED);
    }




//    @RequestMapping(value = "/api/addMentor", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> addMentor(@RequestBody Mentor mentor) {
//        Mentor m = mentorRepository.findByEmail(mentor.getEmail());
//        System.out.println(m);
//        if (m != null) {
//            System.out.println("Mentor found" + m);
//            return new ResponseEntity<>(makeMap("error", "Student already exists"), HttpStatus.CONFLICT);
//        }
//
//        if (m == null) {
//            Student newStudent = new Student(mentor.getFirstName(), mentor.getLastName(), mentor.getEmail(), mentor.getAge());
//            studentRepository.save(newStudent);
//            System.out.println("Player saved: " + newStudent);
//        }
//        return new ResponseEntity<>(makeMap("success", "Name Added"), HttpStatus.CREATED);
//    }
//



    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}