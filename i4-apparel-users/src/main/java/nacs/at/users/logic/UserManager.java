package nacs.at.users.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager {

    private final CostumerRepository repository;
  //  private final IllegibilityManager illegibilityManager;

    public Costumer signUp(Costumer costumer){
            if (!isIllegible(costumer)) {
                throw new IllegalArgumentException("Unappropriated userName or password format");
            }
            else {
              return   repository.save(costumer);}
    }

    public Costumer loginIn(Costumer costumer) {
        Optional<Costumer> optionalCostumer = repository.findByUserNameAndPassword(costumer.getUserName(), costumer.getPassword());

        if(optionalCostumer.isEmpty()){
            throw new IllegalArgumentException("Invalid user name or password!");
        }
        return optionalCostumer.get();
    }

    private boolean isIllegible(Costumer costumer) {
        return true;
    }

}
