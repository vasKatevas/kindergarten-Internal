package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Child;
import gr.hua.dit.it21840.Internalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path="children")
public interface ChildRepository extends CrudRepository<Child, Integer> {
    List<Child>  getChildByClassN(int classN);
}
