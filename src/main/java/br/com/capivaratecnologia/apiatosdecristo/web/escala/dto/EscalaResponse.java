package br.com.capivaratecnologia.apiatosdecristo.web.escala.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoResponse;
import lombok.Data;

@Data
public class EscalaResponse {
    private Long id;
    private String ministerio;
    private String  voluntario;
    private Long  evento;
    private Long  user;

    public static EscalaResponse entityToResponse(EscalaE escalaE){
        final var resp = new EscalaResponse();
        resp.setId(escalaE.getId());
       resp.setMinisterio(escalaE.getMinisterio());
        resp.setVoluntario(escalaE.getVoluntario().getNome());
        resp.setEvento(escalaE.getEvento().getId());
        resp.setUser(escalaE.getUser().getId());
        return resp;
    }

}
