package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ministerio")
public class MinisterioE {
    @Id
    @SequenceGenerator(
            name = "ministerio_sequence",
            sequenceName = "ministerio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_ministerio")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserE user;
    @ManyToMany()
    private List<VoluntarioE> voluntario;
}
