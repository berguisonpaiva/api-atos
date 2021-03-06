package br.com.capivaratecnologia.apiatosdecristo.exeception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha inválida");
    }
}
