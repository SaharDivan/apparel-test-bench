package nacs.at.users.persistence.repository;

import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {

    Optional<Costumer> findByUserNameAndPassword(String username, String password);

   // @Override
  //  Costumer save(Costumer costumer);


}
