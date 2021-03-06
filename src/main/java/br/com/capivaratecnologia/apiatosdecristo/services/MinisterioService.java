package br.com.capivaratecnologia.apiatosdecristo.services;


import br.com.capivaratecnologia.apiatosdecristo.entities.MinVolunE;
import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.MinVolunRepository;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.MinisterioRepository;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.UserRepository;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.VoluntarioRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinVolunInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinisterioInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinisterioService {
    private final MinisterioRepository repository;
    private final VoluntarioRepository voluntarioRepository;
    private final MinVolunRepository minVolunRepository;
    private final UserRepository userRepository;

    public List<MinisterioE> findALL() {
        return repository.findAll();
    }

    public Optional<MinisterioE> findByid(Long id) {
        return repository.findById(id);
    }

    public List<MinisterioE> findMyVoluntarios(Long userId) {
        return repository.findByUserId(userId);
    }

    public Optional<MinVolunE> findVoluntarios(Long userId) {
        return minVolunRepository.findByVoluntarioId(userId);
    }

    public Optional<MinisterioE> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public void save(MinisterioInputModel model) {
        final var ministerio = new MinisterioE();
        final var user = userRepository.findById(model.getUser());
        ministerio.setNome(model.getNome());
        if (user.isEmpty()) {
            ministerio.setUser(null);
        } else {
            ministerio.setUser(user.get());
        }


        repository.save(ministerio);
    }

    public void update(MinisterioInputModel model) {
        final var ministerio = new MinisterioE();
        final var resp = repository.findById(model.getId());
        final var user = userRepository.findById(model.getUser());
        ministerio.setId(model.getId());
        if (model.getNome() == null || model.getNome() == "") {
            ministerio.setNome(resp.get().getNome());
        } else {
            ministerio.setNome(model.getNome());
        }
        if (model.getId() == null) {
            ministerio.setUser(resp.get().getUser());
        } else if (user.isEmpty()) {
            ministerio.setUser(null);
        } else {
            ministerio.setUser(user.get());
        }
        repository.save(ministerio);
    }


    public void deliteMinisterio(Long id) {

        repository.deleteById(id);

    }


    //Volutario x Ministerio


    public void saveVoluntario(MinVolunInputModel model) {

        final var minVolunE = new MinVolunE();
        final var min = repository.findById(model.getIdMinisterio());
        final var volun = voluntarioRepository.findById(model.getIdVoluntario());
        minVolunE.setMinisterio(min.get());
        minVolunE.setVoluntario(volun.get());


        minVolunRepository.save(minVolunE);


    }

    public void deliteVoluntarioByministerio(Long id) {

        minVolunRepository.deleteById(id);

    }

}
