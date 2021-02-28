package br.com.capivaratecnologia.apiatosdecristo.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ministerio")
public class MinisterioE {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserE user;
    @ManyToMany()
    private List<VoluntarioE> voluntario;
}
