package br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import lombok.Data;

@Data
public class VoluntaResponse {
    private Long id;
    private String nome;
    private String contato;

    public static VoluntaResponse entityToResponse(VoluntarioE voluntarioE) {
        final var volunta = new VoluntaResponse();
        volunta.setId(voluntarioE.getId());
        volunta.setNome(voluntarioE.getNome());
        volunta.setContato(voluntarioE.getContato());
        return volunta;
    }

}
