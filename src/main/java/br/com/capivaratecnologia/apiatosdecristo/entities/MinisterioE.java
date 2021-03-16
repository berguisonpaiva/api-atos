package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ministerio")
public class MinisterioE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ministerio")
    private Long id;
    @NotBlank
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserE user;
    @ManyToMany()
    private List<VoluntarioE> voluntario;
}
