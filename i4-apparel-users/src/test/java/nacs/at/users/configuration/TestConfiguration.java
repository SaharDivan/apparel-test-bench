package nacs.at.users.configuration;

import nacs.at.users.persistence.domain.Authority;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.RegisteredUserDto;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;

@Configuration
public class TestConfiguration {


    @Bean
    Costumer costumer() {
        return Costumer.builder()
                .uuId("2345")
                .userName("sahar")
                .password("sahar")
                .emailAddress("sahar@gmail.com")
                .authority(Authority.USER)
                .build();
    }

    @Bean
    UserDto userDto() {
        return UserDto.builder()
                .username("sahar")
                .password("sahar1234")
                .email("sahar@gmail.com")
                .address("")
                .build();
    }

    @Bean
    RegisteredUserDto registeredUserDto() {
        return RegisteredUserDto.builder()
                .authority(Authority.USER)
                .userUuid("2345")
                .username("sahar")
                .password("sahar1234")
                .authorities(new HashSet<>())
                .build();
    }
}
