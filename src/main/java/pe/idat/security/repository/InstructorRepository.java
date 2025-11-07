package pe.idat.security.repository;

import org.springframework.data.repository.CrudRepository;
import pe.idat.security.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
}
