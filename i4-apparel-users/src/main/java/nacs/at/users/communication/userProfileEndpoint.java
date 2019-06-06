package nacs.at.users.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.users.logic.ModelTranslator;
import nacs.at.users.logic.UserManager;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class userProfileEndpoint {

    private final UserManager userManager;
    private final ModelTranslator modelTranslator;

    @PostMapping("/signup")
    Costumer signUP(@RequestBody UserDto userDto){
      Costumer costumer = modelTranslator.TranslateToCostumer(userDto);
      return userManager.signUp(costumer);
    }

    @PostMapping("/login")
    Costumer login(@RequestBody UserDto userDto){
        Costumer costumer = modelTranslator.TranslateToCostumer(userDto);
        return userManager.loginIn(costumer);
    }
}
