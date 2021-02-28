package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.EventoRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EventoInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository eventoRepository;

    public void save(EventoInputModel model){
        final var evento = new EventoE();
        evento.setTitulo(model.getTitulo());
        evento.setData(model.getData());
        evento.setHora(model.getHora());
     eventoRepository.save(evento);
    }

    public List<EventoE> findALL(){
        return eventoRepository.findAll();
    }

    public Optional<EventoE> findById(Long id){
        return eventoRepository.findById(id);
    }


}
