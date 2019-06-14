package nacs.at.users.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpManager {

    private final CostumerRepository repository;
    private final FormatValidationManager formatValidationManager;

    public Costumer signUp(Costumer costumer) {
        if (!isFormatValid(costumer)) {
            throw new IllegalArgumentException("Unappropriated username or password format");
        } else {

            Costumer costumer1 = repository.save(costumer);
            return costumer1;
        }
    }

    public Costumer getLast() {
        Costumer newUser = repository.findTopByOrderByIdDesc().get();
        return newUser;

    }

    private boolean isFormatValid(Costumer costumer) {
        return true;
    }


}
