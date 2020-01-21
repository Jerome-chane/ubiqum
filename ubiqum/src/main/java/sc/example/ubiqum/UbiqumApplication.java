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
	Student s1 = new Student("Bob", "Sponge", "bob.sponge@sea.com",  15);
	Student s2 = new Student("Jean", "Valjean", "revolution@fr", 55);
	Student s3 = new Student("Jesus", "Christ", "amen.com", 33);
	Student s4 = new Student("Johnny", "Bravo", "johnny.b@matcho.com", 24);
	Student s5 = new Student("Marilyn", "Monroe", "MM.com",22);
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

		Course java = new Course("Web Development with Java", "92% of the students on the Web Development with Java program get a job as a web developer within 2 months after finishing the coding bootcamp.","5 months", m1);
		Course mern = new Course("Web Development JavaScript", "The Web Development with JavaScript coding bootcamp program is ideal for those who, without any prior knowledge, want to acquire a solid base of front and back-end programming that allows them to develop both web and mobile web applications.", "3 months",m2);
		Course data = new Course("Data Analytics Course & Machine Learning", "On our Data Analytics program, in just 5 months, you'll learn to execute all the phases of a complex data analysis. With our coding bootcamp program you'll learn how to extract, analyse, and visualise large amounts of data", "6 months",m3);


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

////
//		System.out.println(s1.getStudentCourseMentorHashSet().stream().map(a->a.getCourse()).collect(Collectors.toList()));
//

//		System.out.println(s1.getStudentCourseMentorHashSet().stream().map(a->a.getCourse().getMentor()).collect(Collectors.toList())); // mentor
//		System.out.println(java.getStudentCourseMentorHashSet().stream().map(s->s.getStudent()).collect(Collectors.toList())); // students

	};
};
};

