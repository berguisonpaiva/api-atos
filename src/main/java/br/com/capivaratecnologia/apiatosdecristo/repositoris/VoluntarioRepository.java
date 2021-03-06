package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoluntarioRepository extends JpaRepository<VoluntarioE, Long> {
    Optional<VoluntarioE> findByNome(String nome);
}
