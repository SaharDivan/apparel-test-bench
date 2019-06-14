package nacs.at.users.logic;

import lombok.RequiredArgsConstructor;
import nacs.at.users.persistence.domain.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminAuthoriser {

    private final String adminUser;
    private final String adminPassword;

    public Boolean isAdmin(UserDto userDto){
        return userDto.getUsername().equals(adminUser) &&
                userDto.getPassword().equals(adminPassword);

    }

}
