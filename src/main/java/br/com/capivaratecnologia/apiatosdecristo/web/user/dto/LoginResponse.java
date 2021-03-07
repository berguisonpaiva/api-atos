package br.com.capivaratecnologia.apiatosdecristo.web.user.dto;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class LoginResponse {

    private Long id;
    private String name;
    private String token;
    private String email;
    private String role;


    public static LoginResponse entityToResponse(UserE user, String token) {
        final var resp = new LoginResponse();
        resp.setId(user.getId());
        resp.setName(user.getName());
        resp.setToken(token);
        resp.setEmail(user.getEmail());
        resp.setRole(user.getRole());
        return resp;

    }
}
