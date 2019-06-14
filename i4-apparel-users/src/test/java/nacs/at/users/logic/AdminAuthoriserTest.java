package nacs.at.users.logic;

import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdminAuthoriserTest {

    @Autowired
    AdminAuthoriser adminAuthoriser;

    @Autowired
    String adminUser;
    @Autowired
    String adminPassword;

    @Autowired
    UserDto userDto;

    @org.junit.jupiter.api.Test
    void isAdmin() {

        Boolean actual = adminAuthoriser.isAdmin(userDto);
        Assertions.assertThat(actual).isFalse();
    }
}