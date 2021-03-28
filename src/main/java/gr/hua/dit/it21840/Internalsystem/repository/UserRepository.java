package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Child;
import gr.hua.dit.it21840.Internalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import java.util.List;

//@RepositoryRestResource(path="teachers")
public interface UserRepository extends CrudRepository<User, Integer> {

    @Transactional
    User getUserByUsername(String username);
    @Transactional
    void deleteByUsername(String username);

}