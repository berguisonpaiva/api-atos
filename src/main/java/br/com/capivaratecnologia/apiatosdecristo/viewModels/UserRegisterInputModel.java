package br.com.capivaratecnologia.apiatosdecristo.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRegisterInputModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

}
