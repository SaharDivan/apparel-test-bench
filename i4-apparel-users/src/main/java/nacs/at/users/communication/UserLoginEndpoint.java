package nacs.at.users.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.users.logic.UserLoginManager;
import nacs.at.users.logic.modeltranslator.ToRegisteredUserDto;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.RegisteredUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserLoginEndpoint {

    private final UserLoginManager userLoginManager;
    private final ToRegisteredUserDto toRegisteredUserDto;


    @PostMapping("/login")
    RegisteredUserDto login(@RequestBody String username) {
        Costumer costumer = userLoginManager.loginIn(username);
       return toRegisteredUserDto.translate(costumer);
    }
}
