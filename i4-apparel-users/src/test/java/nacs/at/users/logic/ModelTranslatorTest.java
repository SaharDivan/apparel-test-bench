package nacs.at.users.logic;

import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class ModelTranslatorTest {

    @Autowired
    ModelTranslator translator;
    @Autowired
    UserDto userDto;

    @Test
    void translateToCostumer() {
        Costumer actual = translator.TranslateToCostumer(userDto);
        Assertions.assertThat(actual).isNotNull();
    }
}