package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MinisterioRepository extends JpaRepository<MinisterioE,Long> {
    List<MinisterioE> findByUserId(Long userId);
    Optional<MinisterioE> findByNome(String nome);
}
