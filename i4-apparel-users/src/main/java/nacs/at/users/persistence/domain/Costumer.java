package nacs.at.users.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Costumer {

    private String id;


    private String uuId;

    private Authority authority;


    private String userName;


    private String password;


    private String emailAddress;

    private String address;

}
