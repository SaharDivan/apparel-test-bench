package nacs.at.users.communication;

import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class userProfileEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserDto userDto;

    @Test
    void signUP() {
        String url ="/user/signup";
        Costumer actual = testRestTemplate.patchForObject(url, userDto, Costumer.class);

        Assertions.assertThat(actual).isNull();
    }


    @Test
    void login() {
        String url ="/user/login";
        Costumer actual = testRestTemplate.patchForObject(url, userDto, Costumer.class);

        Assertions.assertThat(actual).isNull();
    }
}