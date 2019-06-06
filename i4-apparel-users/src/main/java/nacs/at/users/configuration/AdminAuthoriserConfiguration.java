package nacs.at.users.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminAuthoriserConfiguration {

    @Value("${admin.user}")
    @Getter
    private String adminUserName;

    @Value("${admin.password}")
    @Getter
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
