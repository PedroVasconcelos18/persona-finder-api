package br.com.cotemig.Personal.Finder.domain.user.controller;

import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.AuthenticationResponseDTO;
import br.com.cotemig.Personal.Finder.domain.user.dto.RegisterRequestDTO;
import br.com.cotemig.Personal.Finder.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
       return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody AuthenticationRequestDTO auth) {
        return ResponseEntity.ok(userService.authenticate(auth));
    }



}
