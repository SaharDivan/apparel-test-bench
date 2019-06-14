package nacs.at.users.logic;

import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserLoginManagerTest {

    @Autowired
    UserLoginManager userLoginManager;

    @MockBean
    CostumerRepository costumerRepository;

    @Autowired
    Costumer costumer;

    @Test
    void loginInValid() {
        Mockito.when(costumerRepository.findByUserName(costumer.getUserName()))
                .thenReturn(Optional.of(costumer));
        Costumer actual = userLoginManager.loginIn(costumer.getUserName());

        Assertions.assertThat(actual).isEqualTo(costumer);
    }

//    @Test
//    void loginInUnValid() {
//        Mockito.when(costumerRepository.findByUserNameAndPassword(costumer.getUserName(),costumer.getPassword()))
//                .thenReturn(Optional.empty());
//        Costumer actual = userLoginManager.loginIn(costumer);
//
//        assertThrows(IllegalArgumentException.class,()-> {});
//
//    }
}