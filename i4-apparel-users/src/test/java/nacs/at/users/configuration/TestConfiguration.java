package nacs.at.users.configuration;

import lombok.Getter;
import lombok.Setter;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("test")
public class TestConfiguration {

    @Getter
    @Setter
    private Costumer costumer;

    @Getter
    @Setter
    private UserDto userDto;


    @Bean
    Costumer costumer() {
        return costumer;
    }

    @Bean
    UserDto userDto() {
        return userDto;
    }
}
