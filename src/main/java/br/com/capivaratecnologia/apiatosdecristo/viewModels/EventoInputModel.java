package br.com.capivaratecnologia.apiatosdecristo.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventoInputModel {
    private String titulo;
    private String data;
    private String hora;
    private String img;
    private String status;
}
