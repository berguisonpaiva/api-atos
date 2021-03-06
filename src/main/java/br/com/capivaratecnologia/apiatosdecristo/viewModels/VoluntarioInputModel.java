package br.com.capivaratecnologia.apiatosdecristo.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class VoluntarioInputModel {
    private Long id;
    private String nome;
    private String contato;
}
