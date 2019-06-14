package nacs.at.users.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUserDto {

    private String userUuid;
    private String username;
    private String password;
    private Authority authority;
    @Builder.Default
    private Set<String> authorities = new HashSet<>();
}
