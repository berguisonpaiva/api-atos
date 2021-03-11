package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  EventoRepository extends JpaRepository<EventoE,Long> {
    List<EventoE> findByStatus(Sort nome, String status);
}
