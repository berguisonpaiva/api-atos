package br.com.capivaratecnologia.apiatosdecristo.web.evento.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import lombok.Data;

@Data
public class EventoResponse {
    private Long id;
    private String titulo;
    private String data;
    private String hora;
    private String img;
    private String status;

    public static EventoResponse entityToResponse(EventoE eventoE){
        final var resp = new EventoResponse();
        resp.setId(eventoE.getId());
        resp.setTitulo(eventoE.getTitulo());
        resp.setData(eventoE.getData());
        resp.setHora(eventoE.getHora());
        resp.setImg(eventoE.getImg());
        resp.setStatus(eventoE.getStatus());

        return resp;
    }
}
