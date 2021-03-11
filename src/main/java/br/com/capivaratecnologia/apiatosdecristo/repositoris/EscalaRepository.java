package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.entities.MinVolunE;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EscalaRepository extends JpaRepository<EscalaE,Long> {
    List<EscalaE> findByEventoId(Sort data, Long eventoId);
    Optional<EscalaE> findByEventoIdAndVoluntarioId(Long eventoId, Long volunrioId);
}
