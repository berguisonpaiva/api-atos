package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "voluntario")
public class VoluntarioE {
    @Id
    @SequenceGenerator(
            name = "voluntario_sequence",
            sequenceName = "voluntario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_voluntario")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "contato")
    private String contato;



}
