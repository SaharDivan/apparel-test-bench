package at.nacs.basket.persistance.repository;

import at.nacs.basket.persistance.domain.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket,String> {

    Optional<Basket> findByUserUuId(String userUuId);

}
