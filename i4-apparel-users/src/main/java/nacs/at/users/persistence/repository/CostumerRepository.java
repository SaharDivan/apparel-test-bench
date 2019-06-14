package nacs.at.users.persistence.repository;

import nacs.at.users.persistence.domain.Costumer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CostumerRepository extends MongoRepository<Costumer, String> {

    Optional<Costumer> findByUserName(String username);
    Optional<Costumer> findTopByOrderByIdDesc();

}
