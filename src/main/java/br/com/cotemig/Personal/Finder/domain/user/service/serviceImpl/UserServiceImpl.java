package br.com.cotemig.Personal.Finder.domain.user.service.serviceImpl;

import br.com.cotemig.Personal.Finder.config.JwtService;
import br.com.cotemig.Personal.Finder.domain.user.User;
import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationResponseDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.RegisterRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.enums.TypeUser;
import br.com.cotemig.Personal.Finder.domain.user.exception.InvalidPassException;
import br.com.cotemig.Personal.Finder.domain.user.repository.UserRepository;
import br.com.cotemig.Personal.Finder.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO register) {
        var user = User.builder()
                .email(register.getEmail())
                .name(register.getName())
                .password(passwordEncoder.encode(register.getPassword()))
                .typeUser(register.getTypeUser())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authentication) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentication.getEmail(),
                        authentication.getPassword()
                )
        );
        var user = userRepository.findByEmail(authentication.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public List<User> findAllPersonal() {
        return userRepository.findAllByTypeUserIs(TypeUser.PERSONAL);
    }

    @Override
    public List<User> findAllStudent() {
        return userRepository.findAllByTypeUserIs(TypeUser.STUDENT);
    }
}
