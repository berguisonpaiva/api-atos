package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.*;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EscalaInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscalaService {
    @Autowired
    private  EscalaRepository escalaRepository;
    @Autowired
    private  VoluntarioRepository voluntarioRepository;
    @Autowired
    private  EventoRepository eventoRepository;
    @Autowired
    private  UserRepository userRepository;

    public void save(EscalaInputModel model) {
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


    public void update(EscalaInputModel model) {
        final var escala = new EscalaE();
        final var escalaAtual = escalaRepository.findById(model.getId());
        final var evento = eventoRepository.findById(model.getEvento());
        final var voluntario = voluntarioRepository.findById(model.getVoluntario());
        final var user = userRepository.findById(model.getUser());
        escala.setId(model.getId());
        if (model.getEvento() == null) {
            escala.setEvento(escalaAtual.get().getEvento());
        } else {
            escala.setEvento(evento.get());
        }
        if (model.getVoluntario() == null) {
            escala.setVoluntario(escalaAtual.get().getVoluntario());
        } else {
            escala.setVoluntario(voluntario.get());
        }
        if (model.getMinisterio() == null) {
            escala.setMinisterio(escalaAtual.get().getMinisterio());
        } else {
            escala.setMinisterio(model.getMinisterio());
        }
        if (model.getUser() == null) {
            escala.setUser(escalaAtual.get().getUser());
        } else {
            escala.setUser(user.get());
        }


        escalaRepository.save(escala);
    }


    public Optional<EscalaE> findById(Long id) {
        return escalaRepository.findById(id);
    }

    public List<EscalaE> findALL() {
        return escalaRepository.findAll();
    }

    public Optional<EscalaE> findByEventoByvoluntario(Long eventoId, Long voluntarioId) {
        return escalaRepository.findByEventoIdAndVoluntarioId(eventoId, voluntarioId);
    }

    public List<EscalaE> findEvento(Long eventoId) {
        return escalaRepository.findByEventoId(eventoId);
    }

    public void delete(Long id) {

        escalaRepository.deleteById(id);
    }
}
