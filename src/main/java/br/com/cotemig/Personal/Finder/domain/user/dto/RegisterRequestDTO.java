package br.com.cotemig.Personal.Finder.domain.user.dto;

import br.com.cotemig.Personal.Finder.domain.user.enums.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;
    private String email;
    private String password;
    private TypeUser typeUser;

}
