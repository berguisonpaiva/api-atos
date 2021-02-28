package br.com.capivaratecnologia.apiatosdecristo.services;


import br.com.capivaratecnologia.apiatosdecristo.entities.MinVolunE;
import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.RegraNegocioException;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.MinVolunRepository;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.MinisterioRepository;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.VoluntarioRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinVolunInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinisterioInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinisterioService {
    private final MinisterioRepository repository;
    private final VoluntarioRepository voluntarioRepository;
    private  final MinVolunRepository minVolunRepository;

    public List<MinisterioE> findALL(){
        return repository.findAll();
    }

    public  List<MinisterioE> findMyVoluntarios(Long userId){
        return  repository.findByUserId(userId);
    }

    public void save(MinisterioInputModel model){
       final var ministerio = new MinisterioE();
       ministerio.setNome(model.getNome());


       repository.save(ministerio);
    }
    public void saveVoluntario(MinVolunInputModel model){

        final var minVolunE = new MinVolunE();
        final var min = repository.findById(model.getIdMinisterio());
        final var volun = voluntarioRepository.findById(model.getIdVoluntario());
        minVolunE.setMinisterio(min.get());
        minVolunE.setVoluntario(volun.get());



        minVolunRepository.save(minVolunE);


    }
}
