package br.com.capivaratecnologia.apiatosdecristo.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EscalaInputModel {
    private Long id;
    private Long evento;
    private Long voluntario;
    private String ministerio;
    private Long user;

}
