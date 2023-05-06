package br.com.cotemig.Personal.Finder.domain.user.repository;

import br.com.cotemig.Personal.Finder.domain.user.User;
import br.com.cotemig.Personal.Finder.domain.user.enums.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findAllByTypeUserIs(TypeUser typeUser);

}
