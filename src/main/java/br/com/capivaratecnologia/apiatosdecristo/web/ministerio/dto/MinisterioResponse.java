package br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MinisterioResponse {
    private Long id;
    private String nome;
    private List<VoluntaResponse> voluntarios;

    public static MinisterioResponse entityToResponse(MinisterioE ministerioE){
        final  var minist = new MinisterioResponse();
        minist.setId(ministerioE.getId());
        minist.setNome(ministerioE.getNome());
        final var volun = ministerioE.getVoluntario().stream().map(VoluntaResponse::entityToResponse)
                .collect(Collectors.toList());
        minist.setVoluntarios(volun);
        return minist;
    }
}
