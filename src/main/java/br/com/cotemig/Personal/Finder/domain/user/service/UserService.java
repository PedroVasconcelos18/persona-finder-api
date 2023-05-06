package br.com.cotemig.Personal.Finder.domain.user.service;

import br.com.cotemig.Personal.Finder.domain.user.User;
import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationResponseDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.RegisterRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.enums.TypeUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    AuthenticationResponseDTO register(RegisterRequestDTO register);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authentication);
    List<User> findAllPersonal();
    List<User> findAllStudent();
}
