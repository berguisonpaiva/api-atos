package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class EventoE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_evento")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "data_evento")
    private String data;
    @Column(name = "hora_evento")
    private String hora;
    @Column(name = "image_evento")
    private String img;
    @Column(name = "status_evento")
    private String status;
}
