package br.com.capivaratecnologia.apiatosdecristo.web.evento.dto;

import lombok.Data;

@Data
public class EventoRequest {
    private String titulo;
    private String data;
    private String hora;
}