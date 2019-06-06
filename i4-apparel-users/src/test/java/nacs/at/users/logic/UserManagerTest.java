package nacs.at.users.logic;

import nacs.at.users.configuration.AdminAuthoriserConfiguration;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class UserManagerTest {

    @Autowired
    UserManager userManager;

    @Autowired
    Costumer costumer;

    @MockBean
    CostumerRepository costumerRepository;
    @MockBean
    AdminAuthoriserConfiguration configuration;

    @MockBean
    AdminAuthoriser adminAuthoriser;


    @Test
    void signUp(Costumer costumer) {
        when(costumerRepository.save(costumer)).thenReturn(costumer);
        Costumer actual = userManager.signUp(costumer);

        assertThat(actual).isNotNull();
    }

    @Test
    void loginIn() {
        when(costumerRepository.findByUserNameAndPassword(costumer.getUserName(),costumer.getPassword()))
                .thenReturn(Optional.ofNullable(costumer));
        Costumer actual = userManager.loginIn(costumer);

        assertThat(actual).isNotNull();
    }
}