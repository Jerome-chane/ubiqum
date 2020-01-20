package sc.example.ubiqum;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        dto.put("Students", course.getStudentCourseMentorHashSet().stream().map(s-> StudentsDTO(s.getStudent())));
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

    private Map<String, Object> StudentsDTO(Student student) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("firstname", student.getFirstName());
        dto.put("lastname", student.getLastName());
        dto.put("age", student.getAge());
        return dto;
    }
}

//
//    public Map<String, Object> getGames(Authentication authentication) {
//        Map<String, Object> dto = new LinkedHashMap<String, Object>();
//        if (isGuest(authentication)) {
//            dto.put("player", null);
//        } else {
//            dto.put("player", loginDTO(authentication));
//        }
//        dto.put("games", gameRepository.findAll().stream().map(game -> GameDTO(game)).collect(Collectors.toList()));
//        return dto;
//    }