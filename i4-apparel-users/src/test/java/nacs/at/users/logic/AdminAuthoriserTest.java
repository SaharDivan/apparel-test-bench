package nacs.at.users.logic;

import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

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

    @Test
    void isAdmin() {
        Boolean actual = adminAuthoriser.isAdmin(userDto);
        Assertions.assertThat(actual).isFalse();
    }
}