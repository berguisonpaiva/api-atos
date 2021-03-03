package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ministerio_voluntario")
public class MinVolunE {
    @Id
    @SequenceGenerator(
            name = "ministerio_voluntario_sequence",
            sequenceName = "ministerio_voluntario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ministerioe_id_ministerio")
    private MinisterioE ministerio;
    @ManyToOne
    @JoinColumn(name = "voluntario_id_voluntario")
    private VoluntarioE voluntario;
}
