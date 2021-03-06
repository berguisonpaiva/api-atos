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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoluntarioService {
    private final VoluntarioRepository repository;

    public void save(VoluntarioInputModel model) {
        final var voluntario = new VoluntarioE();
        voluntario.setNome(model.getNome());
        voluntario.setContato(model.getContato());


        repository.save(voluntario);
    }

    public void update(VoluntarioInputModel model) {
        final var voluntario = new VoluntarioE();
        final var volun = repository.findById(model.getId());
        voluntario.setId(model.getId());
        if (model.getNome() == null || model.getNome() == "") {
            voluntario.setNome(volun.get().getNome());
        } else {
            voluntario.setNome(model.getNome());
        }
        if (model.getContato() == null || model.getContato() == "") {
            voluntario.setContato(volun.get().getContato());
        } else {
            voluntario.setContato(model.getContato());
        }


        repository.save(voluntario);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<VoluntarioE> findALL() {
        return repository.findAll();
    }

    public Optional<VoluntarioE> findById(Long id) {
        return repository.findById(id);
    }
    public Optional<VoluntarioE> findByNome(String nome) {
        return repository.findByNome(nome);
    }
}
