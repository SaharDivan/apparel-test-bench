package nacs.at.users.logic.modeltranslator;

import lombok.RequiredArgsConstructor;
import nacs.at.users.logic.AdminAuthoriser;
import nacs.at.users.persistence.domain.Authority;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToCostumerTranslator {

   private final AdminAuthoriser adminAuthoriser;

    public Costumer TranslateToCostumer(UserDto userDto) {
        return Costumer.builder()
                .uuId(String.valueOf(UUID.randomUUID()))
                .authority(assignAuthority(userDto))
                .userName(userDto.getUsername())
                .password(userDto.getPassword())
                .emailAddress(userDto.getEmail())
                .address(userDto.getAddress())
                .build();
    }

    private Authority assignAuthority(UserDto userDto) {
            if(adminAuthoriser.isAdmin(userDto)){
                return Authority.ADMIN;}
            else {
                return Authority.USER;}
    }
}
