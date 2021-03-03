package br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.VoluntaResponse;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class VoluntarioResponse {
    private Long id;
    private String nome;
    private String contato;


    public static VoluntarioResponse entityToResponse(VoluntarioE voluntarioE){
        final var volunta = new VoluntarioResponse();
        volunta.setId(voluntarioE.getId());
        volunta.setNome(voluntarioE.getNome());
        volunta.setContato(voluntarioE.getContato());

        return  volunta;
    }

}
