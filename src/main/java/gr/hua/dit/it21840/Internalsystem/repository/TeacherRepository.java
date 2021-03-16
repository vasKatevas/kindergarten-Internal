package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="teachers")
public interface TeacherRepository extends CrudRepository<Teacher, String> {
    Teacher getTeacherByUsername(String username);
}
