package br.com.capivaratecnologia.apiatosdecristo.web.evento.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.VoluntaResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class EventoResponse {
    private Long id;
    private String titulo;
    private String data;
    private String hora;
    private String img;
    private String status;
    private List<EscalaEventoResponse> escala;

    public static EventoResponse entityToResponse(EventoE eventoE){
        final var resp = new EventoResponse();
        resp.setId(eventoE.getId());
        resp.setTitulo(eventoE.getTitulo());
        resp.setData(eventoE.getData());
        resp.setHora(eventoE.getHora());
        resp.setImg(eventoE.getImg());
        resp.setStatus(eventoE.getStatus());

        final var escaladata = eventoE.getEscala().stream().map(EscalaEventoResponse::entityToResponse)
                .collect(Collectors.toList());
resp.setEscala(escaladata);
        return resp;
    }
}
