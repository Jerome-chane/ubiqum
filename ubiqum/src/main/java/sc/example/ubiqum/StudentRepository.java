package sc.example.ubiqum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(@Param("email") String email);

}

