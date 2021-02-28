package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EventoRepository extends JpaRepository<EventoE,Long> {
}
