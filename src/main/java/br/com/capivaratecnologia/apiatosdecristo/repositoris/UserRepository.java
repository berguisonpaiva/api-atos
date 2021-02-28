package br.com.capivaratecnologia.apiatosdecristo.repositoris;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserE, Long> {
    Optional<UserE> findByEmail(String email);
}
