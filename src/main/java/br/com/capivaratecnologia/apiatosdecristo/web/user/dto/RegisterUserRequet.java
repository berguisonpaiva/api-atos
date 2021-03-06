package br.com.capivaratecnologia.apiatosdecristo.web.user.dto;

import lombok.Data;

@Data
public class RegisterUserRequet {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}
