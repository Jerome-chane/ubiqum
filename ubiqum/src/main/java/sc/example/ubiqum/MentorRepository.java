package sc.example.ubiqum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface MentorRepository extends JpaRepository<Mentor, Long> {

}