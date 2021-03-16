package gr.hua.dit.it21840.Internalsystem.repository;

import gr.hua.dit.it21840.Internalsystem.entity.Child;
import gr.hua.dit.it21840.Internalsystem.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {
}
