package sc.example.ubiqum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UbiqumApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbiqumApplication.class, args);
	}

@Bean
public CommandLineRunner initData(StudentRepository studentRepository, MentorRepository mentorRepository, CourseRepository courseRepository, StudentCourseMentorRepository studentCourseMentorRepository) {
	return (args) -> {
	Student s1 = new Student("Bob", "Sponge", 15);
	Student s2 = new Student("Jean", "Valjean", 55);
	Student s3 = new Student("Jesus", "Christ", 33);
	Student s4 = new Student("Johnny", "Bravo", 24);
	Student s5 = new Student("Marilyn", "Monroe", 22);
	studentRepository.save(s1);studentRepository.save(s2);studentRepository.save(s3);studentRepository.save(s4);studentRepository.save(s5);

		Mentor m1 = new Mentor("Mr", "Bean", 54, "Java, Js");
		Mentor m2 = new Mentor("Master", "San", 45, "HTML, CSS");
		Mentor m3 = new Mentor("Mr", "Potatoe", 45, "Python, Vue");
		Mentor m4 = new Mentor("Pika", "Chu", 45, "Bootstap, Mern");
		m1.addPhoto("https://pbs.twimg.com/profile_images/537867024920113152/ENatnQMa.png");
		m2.addPhoto("https://www.drupal.org/files/images/master_joda.png");
		m3.addPhoto("https://pbs.twimg.com/profile_images/944655409528401920/rDWcUAlC_400x400.jpg");
		m4.addPhoto("https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png");
		mentorRepository.save(m1);mentorRepository.save(m2);mentorRepository.save(m3);mentorRepository.save(m4);

		Course java = new Course("Java Course", "Java", "5 months", m1);
		Course mern = new Course("Mern Course", "Mern", "3 months",m2);
		Course data = new Course("Data Course", "Data", "6 months",m3);

		courseRepository.save(java);courseRepository.save(mern);courseRepository.save(data);

		StudentCourseMentor c1 = new StudentCourseMentor(java, s1);
		StudentCourseMentor c2 = new StudentCourseMentor(java, s2);
		StudentCourseMentor c3 = new StudentCourseMentor(java, s3);
		StudentCourseMentor c4 = new StudentCourseMentor(java, s4);
		StudentCourseMentor c5 = new StudentCourseMentor(java, s5);

		StudentCourseMentor c6 = new StudentCourseMentor(mern, s5);
		StudentCourseMentor c7 = new StudentCourseMentor(mern, s2);

		StudentCourseMentor c8 = new StudentCourseMentor(data, s4);
		StudentCourseMentor c9 = new StudentCourseMentor(data, s5);
		StudentCourseMentor c10 = new StudentCourseMentor(data, s1);


		studentCourseMentorRepository.save(c1);studentCourseMentorRepository.save(c2);
		studentCourseMentorRepository.save(c3);studentCourseMentorRepository.save(c4);
		studentCourseMentorRepository.save(c5);studentCourseMentorRepository.save(c6);
		studentCourseMentorRepository.save(c7);studentCourseMentorRepository.save(c8);
		studentCourseMentorRepository.save(c9);studentCourseMentorRepository.save(c10);

//
		System.out.println(java.getMentor());

		System.out.println(m3.getCourses());
//		System.out.println(s1.getStudentCourseMentorHashSet().stream().map(a->a.getCourse().getMentor()).collect(Collectors.toList())); // mentor
//		System.out.println(java.getStudentCourseMentorHashSet().stream().map(s->s.getStudent()).collect(Collectors.toList())); // students

	};
};
};

