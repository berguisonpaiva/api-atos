package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.VoluntarioRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.VoluntarioInputModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoluntarioService {
    private final VoluntarioRepository repository;

    public  void save(VoluntarioInputModel model){
        final var voluntario = new VoluntarioE();
        voluntario.setNome(model.getNome());
        voluntario.setContato(model.getContato());


        repository.save(voluntario);
    }

    public List<VoluntarioE> findALL(){
        return repository.findAll();
    }
}
