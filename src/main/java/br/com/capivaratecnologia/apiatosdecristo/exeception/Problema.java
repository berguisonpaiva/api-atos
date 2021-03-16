package br.com.capivaratecnologia.apiatosdecristo.exeception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problema {
    private Integer status;
    private LocalDateTime datHora;
    private String titulo;
    private List<Campo> campos;
    public static class Campo {

        private String nome;
        private String mensagem;

        public Campo(String nome, String mensagem) {
            super();
            this.nome = nome;
            this.mensagem = mensagem;
        }
    }
}
