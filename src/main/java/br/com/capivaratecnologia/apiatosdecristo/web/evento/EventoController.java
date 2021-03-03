package br.com.capivaratecnologia.apiatosdecristo.web.evento;

import br.com.capivaratecnologia.apiatosdecristo.services.EventoService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EventoInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/evento")
public class EventoController {
    private final EventoService service;

    @PostMapping(value = "/")
    public void save(@RequestBody EventoRequest request){
        final var input = new EventoInputModel(
                request.getTitulo(),
                request.getData(),
                request.getHora(),
                request.getImg(),
                request.getStatus()
        );
        service.save(input);
    }

    @GetMapping(value = "/")
    List<EventoResponse> findall(){
        final var eveto = service.findALL();
        return eveto.stream().map(EventoResponse::entityToResponse).collect(Collectors.toList());
    }
    @GetMapping(value = "/ativo")
    List<EventoResponse> findallStatus(){
        final var eveto = service.findALLStatus();
        return eveto.stream().map(EventoResponse::entityToResponse).collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}")
    EventoResponse findByid(@PathVariable(value = "id") Long id){
        final var eveto = service.findById(id);
        return EventoResponse.entityToResponse(eveto.get());
    }
}
