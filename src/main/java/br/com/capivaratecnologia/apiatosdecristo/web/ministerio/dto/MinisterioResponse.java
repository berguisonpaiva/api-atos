package br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import lombok.Data;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
public class MinisterioResponse {
    private Long id;
    private String nome;
    private String lider;
    private List<VoluntaResponse> voluntarios;

    public static MinisterioResponse entityToResponse(MinisterioE ministerioE) {
        final var minist = new MinisterioResponse();
        minist.setId(ministerioE.getId());
        minist.setNome(ministerioE.getNome());
        if (ministerioE.getUser() != null) {
            final var user = LiderResponse.entityToResponse(ministerioE.getUser());
            minist.setLider(user.getNome());
        } else {
            minist.setLider("lider não cadastrado");
        }
        final var volun = ministerioE.getVoluntario().stream().map(VoluntaResponse::entityToResponse)
                .collect(Collectors.toList());
        minist.setVoluntarios(volun);

        return minist;
    }
}
