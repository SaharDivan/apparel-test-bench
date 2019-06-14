package nacs.at.users.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginManager {

    private final CostumerRepository repository;


    public Costumer loginIn(String  username) {
        Optional<Costumer> optionalCostumer = repository.findByUserName(username);

        if (optionalCostumer.isEmpty()) {
            throw new IllegalArgumentException("Invalid user!");
        }
        return optionalCostumer.get();
    }

}
