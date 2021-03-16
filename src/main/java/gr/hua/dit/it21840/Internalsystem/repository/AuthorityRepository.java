package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Authorities;
import gr.hua.dit.it21840.Internalsystem.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="authorities")
public interface AuthorityRepository extends JpaRepository<Authorities, String> {



}
