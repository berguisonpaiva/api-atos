package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "escala")
public class EscalaE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_escala")
    private Long id;
    @Column(name = "ministerio")
    private String ministerio;
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private EventoE evento;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserE user;
    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private VoluntarioE voluntario;

}
