package nacs.at.users.communication;

import nacs.at.users.logic.UserSignUpManager;
import nacs.at.users.logic.modeltranslator.ToCostumerTranslator;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserSignUpEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UserSignUpManager userSignUpManager;

    @MockBean
    ToCostumerTranslator toCostumerTranslator;

    @Autowired
    UserDto userDto;

    @Autowired
    Costumer costumer;

    @Test
    void signUP() {
        String url = "/user/signup";
        Mockito.when(toCostumerTranslator.TranslateToCostumer(userDto)).thenReturn(costumer);
        Mockito.when(userSignUpManager.signUp(costumer)).thenReturn(costumer);
        Costumer actual = testRestTemplate.postForObject(url, userDto, Costumer.class);

        Assertions.assertThat(actual).isEqualTo(costumer);
    }

    @Test
    void getLastRegisteredCostumer(){
        String url = "/user/signup";
        Mockito.when(userSignUpManager.getLast()).thenReturn(costumer);
        Costumer actual = testRestTemplate.getForObject(url, Costumer.class);

        Assertions.assertThat(actual).isNotNull();

    }

}