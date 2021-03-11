package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.EventoE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.EventoRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EventoInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private  EventoRepository eventoRepository;

    public void save(EventoInputModel model) {
        final var evento = new EventoE();
        evento.setTitulo(model.getTitulo());
        evento.setData(model.getData());
        evento.setHora(model.getHora());
        evento.setImg(model.getImg());
        evento.setStatus("ATIVO");
        eventoRepository.save(evento);
    }

    public void update(EventoInputModel model) {
        final var atu = eventoRepository.findById(model.getId());
        final var evento = new EventoE();
        evento.setId(model.getId());
        if (model.getTitulo() == null || model.getTitulo() == "") {
            evento.setTitulo(atu.get().getTitulo());
        } else {
            evento.setTitulo(model.getTitulo());
        }

        if (model.getHora() == null || model.getHora() == "") {
            evento.setHora(atu.get().getHora());
        } else {
            evento.setHora(model.getHora());
        }
        if (model.getData() == null || model.getData() == "") {
            evento.setData(atu.get().getData());
        } else {
            evento.setData(model.getData());
        }
        if (model.getImg() == null || model.getImg() == "") {
            evento.setImg(atu.get().getImg());
        } else {
            evento.setImg(model.getImg());
        }
        if (model.getStatus() == null || model.getStatus() == "") {
            evento.setStatus(atu.get().getStatus());
        } else {
            evento.setStatus(model.getStatus());
        }

        eventoRepository.save(evento);
    }

    public List<EventoE> findALL() {
        return eventoRepository.findAll(Sort.by("data"));
    }

    public List<EventoE> findALLStatus() {
        return eventoRepository.findByStatus(Sort.by("data"),"ATIVO");
    }

    public Optional<EventoE> findById(Long id) {
        return eventoRepository.findById(id);
    }

    public void delete(Long id) {
        final var evento = eventoRepository.findById(id);
        eventoRepository.delete(evento.get());
    }

}
