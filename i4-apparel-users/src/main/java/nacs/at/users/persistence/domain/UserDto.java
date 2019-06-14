package nacs.at.users.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private String username;

    private String password;
    private String matchingPassword;

    private String email;

    private String address;
}
