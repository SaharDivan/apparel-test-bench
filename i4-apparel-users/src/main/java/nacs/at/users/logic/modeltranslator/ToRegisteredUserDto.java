package nacs.at.users.logic.modeltranslator;

import lombok.RequiredArgsConstructor;
import nacs.at.users.persistence.domain.Authority;
import nacs.at.users.persistence.domain.Costumer;
import nacs.at.users.persistence.domain.RegisteredUserDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ToRegisteredUserDto {


    public RegisteredUserDto translate(Costumer costumer) {

        return RegisteredUserDto.builder()
                .userUuid(costumer.getUuId())
                .username(costumer.getUserName())
                .password(costumer.getPassword())
                .authority(costumer.getAuthority())
                .authorities(listAllRoles())
                .build();
    }

    private Set<String> listAllRoles() {
        Set<String> authorityList = new HashSet<>();
        authorityList.add(Authority.USER.toString());
        authorityList.add(Authority.ADMIN.toString());
        return authorityList;

    }
}
