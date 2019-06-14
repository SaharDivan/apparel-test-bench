package nacs.at.users.communication;

import lombok.RequiredArgsConstructor;
import nacs.at.users.logic.modeltranslator.ToCostumerTranslator;
import nacs.at.users.logic.UserSignUpManager;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserSignUpEndpoint {

    private final UserSignUpManager userSignUpManager;
    private final ToCostumerTranslator toCostumerTranslator;


    @PostMapping("/signup")
    Costumer signUP(@RequestBody UserDto userDto){
        Costumer costumer = toCostumerTranslator.TranslateToCostumer(userDto);
        return userSignUpManager.signUp(costumer);
    }

    @GetMapping("/signup")
    Costumer getLastRegisteredCostumer() {
        return userSignUpManager.getLast();
    }
}
