package br.com.cotemig.Personal.Finder.domain.user.exception;

public class InvalidPassException extends RuntimeException {
    public InvalidPassException() {
        super("Senha inválida");
    }
}
