package nacs.at.users.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Costumer {

    @Id
    @GeneratedValue
    private Long id;


    @Column(unique = true)
    private String uuId;

    private Authority authority;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @Valid
    private String emailAddress;

    private String address;

}
