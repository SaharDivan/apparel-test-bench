package nacs.at.users.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfiguration {

    @Value("${admin.user}")
    @Getter
    @Setter
    private String adminUserName;

    @Value("${admin.password}")
    @Getter
    @Setter
    private String adminPassword;

    @Bean
    String adminUser(){
        return adminUserName;
    }

    @Bean
    String adminPassword(){
        return adminPassword;
    }
}
