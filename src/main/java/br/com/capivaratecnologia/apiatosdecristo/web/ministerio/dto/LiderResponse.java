package br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import lombok.Data;

@Data
public class LiderResponse {
    private String nome;

    public static LiderResponse entityToResponse(UserE userE) {
        final var user = new LiderResponse();

        user.setNome(userE.getName());

        return user;
    }
}
