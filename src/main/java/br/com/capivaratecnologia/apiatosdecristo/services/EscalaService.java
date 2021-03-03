package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.*;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EscalaInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EscalaService {
    private final EscalaRepository escalaRepository;
    private final VoluntarioRepository voluntarioRepository;
    private final EventoRepository eventoRepository;
    private final UserRepository userRepository;

    public void save(EscalaInputModel model){
       final var escala = new EscalaE();
       final var evento = eventoRepository.findById(model.getEvento());
        final var voluntario = voluntarioRepository.findById(model.getVoluntario());
        final var user = userRepository.findById(model.getUser());
       escala.setEvento(evento.get());
        escala.setVoluntario(voluntario.get());
        escala.setMinisterio(model.getMinisterio());
        escala.setUser(user.get());

       escalaRepository.save(escala);
    }

    public List<EscalaE> findALL(){
        return escalaRepository.findAll();
    }
    public List<EscalaE> findEvento(Long eventoId){
        return escalaRepository.findByEventoId(eventoId);
    }
}
