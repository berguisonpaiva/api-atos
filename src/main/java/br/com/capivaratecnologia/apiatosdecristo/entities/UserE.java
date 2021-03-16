package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class UserE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;
    @NotBlank
    @Column(name = "nome")
    private String name;
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String password;
    @Column(name = "role")
    private String role;


}