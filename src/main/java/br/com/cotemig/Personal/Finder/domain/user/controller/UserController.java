package br.com.cotemig.Personal.Finder.domain.user.controller;

import br.com.cotemig.Personal.Finder.domain.user.User;
import br.com.cotemig.Personal.Finder.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/personal")
    public List<User> findAllPersonal() {
        return userService.findAllPersonal();
    }

    @GetMapping("/student")
    public List<User> findAllStudent() {
        return userService.findAllStudent();
    }

}
