package br.com.capivaratecnologia.apiatosdecristo.web.escala.dto;

import lombok.Data;

@Data
public class EscalaRequest {
    private Long id;
    private Long evento;
    private Long voluntario;
    private String ministerio;
    private Long user;
}
