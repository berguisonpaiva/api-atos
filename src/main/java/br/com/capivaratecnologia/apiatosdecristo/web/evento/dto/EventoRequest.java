package br.com.capivaratecnologia.apiatosdecristo.web.evento.dto;

import lombok.Data;

@Data
public class EventoRequest {
    private Long id;
    private String titulo;
    private String data;
    private String hora;
    private String img;
    private String status;
}
