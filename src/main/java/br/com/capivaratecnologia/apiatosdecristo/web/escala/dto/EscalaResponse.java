package br.com.capivaratecnologia.apiatosdecristo.web.escala.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoResponse;
import lombok.Data;

@Data
public class EscalaResponse {
    private String ministerio;
    private String  voluntario;

    public static EscalaResponse entityToResponse(EscalaE escalaE){
        final var resp = new EscalaResponse();
       resp.setMinisterio(escalaE.getMinisterio());
        resp.setVoluntario(escalaE.getVoluntario().getNome());

        return resp;
    }

}
