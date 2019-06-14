package nacs.at.users.logic;

import nacs.at.users.configuration.AdminConfiguration;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.repository.CostumerRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserSignUpManagerTest {

    @Autowired
    UserSignUpManager userSignUpManager;

    @Autowired
    Costumer costumer;


    @MockBean
    CostumerRepository costumerRepository;
    @MockBean
    AdminConfiguration configuration;

    @MockBean
    AdminAuthoriser adminAuthoriser;

    @Before
    void before() {
        costumerRepository.deleteAll();
    }


// need fix
//    @Test
//    void signUp(Costumer costumer) {
//        when(costumerRepository.save(costumer)).thenReturn(costumer);
//        Costumer actual = userManager.signUp(costumer);
//
//        Assertions.assertThat(actual).isNotNull();
//    }

//    @Test
//    void loginIn() {
//        when(costumerRepository.findByUserNameAndPassword(costumer.getUserName(), costumer.getPassword()))
//                .thenReturn(Optional.ofNullable(costumer));
//        Costumer actual = userSignUpManager.loginIn(costumer);
//
//        Assertions.assertThat(actual).isNotNull();
//    }
}