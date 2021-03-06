package br.com.capivaratecnologia.apiatosdecristo.web.user.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String name;
    private String email;
    private String role;

    public static LoginResponse entityToResponse(UserE user) {
        final var resp = new LoginResponse();
        resp.setId(user.getId());
        resp.setName(user.getName());
        resp.setEmail(user.getEmail());
        resp.setRole(user.getRole());
        return resp;

    }
}
