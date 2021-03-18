package br.com.capivaratecnologia.apiatosdecristo.web.evento.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaResponse;
import lombok.Data;

@Data
public class EscalaEventoResponse {
    private Long id;
    private String ministerio;
    private String  voluntario;



    public static EscalaEventoResponse entityToResponse(EscalaE escalaE){
        final var resp = new EscalaEventoResponse();
        resp.setId(escalaE.getId());
        resp.setMinisterio(escalaE.getMinisterio());
        resp.setVoluntario(escalaE.getVoluntario().getNome());

        return resp;
    }
}
