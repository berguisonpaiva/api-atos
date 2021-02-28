package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class EventoE {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_evento")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "data_evento")
    private String data;
    @Column(name = "hora_evento")
    private String hora;
}
