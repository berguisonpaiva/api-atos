package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinVolunE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MinVolunRepository extends JpaRepository<MinVolunE,Long> {
    Optional<MinVolunE> findByVoluntarioId(Long voluntario);

}
