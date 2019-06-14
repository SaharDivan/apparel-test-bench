package nacs.at.users.communication;

import nacs.at.users.logic.UserLoginManager;
import nacs.at.users.logic.modeltranslator.ToRegisteredUserDto;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.RegisteredUserDto;
import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class userLoginEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserDto userDto;

    @Autowired
    RegisteredUserDto registeredUserDto;

    @Autowired
    Costumer costumer;

    @MockBean
    UserLoginManager userLoginManager;

    @MockBean
    ToRegisteredUserDto toRegisteredUserDto;


    @Test
    void login() {
        String url = "/user/login";

        Mockito.when(userLoginManager.loginIn("sahar")).thenReturn(costumer);
        Mockito.when(toRegisteredUserDto.translate(costumer)).thenReturn(registeredUserDto);

        RegisteredUserDto actual = testRestTemplate.postForObject(url, userDto, RegisteredUserDto.class);

        Assertions.assertThat(actual).isNotNull();
    }
}