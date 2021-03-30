package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;

@RepositoryRestResource(path="teachers")
@PostAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_TEACHER')")
public interface TeacherRepository extends CrudRepository<Teacher, String> {
    @RestResource(exported = false)
    Teacher getTeacherByUsername(String username);
}
