package br.com.capivaratecnologia.apiatosdecristo.web.escala;

import br.com.capivaratecnologia.apiatosdecristo.entities.EscalaE;
import br.com.capivaratecnologia.apiatosdecristo.services.EscalaService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EscalaInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/escala")
public class EscalaController {
    private final EscalaService service;

    @PostMapping(value = "/")
    public void save(@RequestBody EscalaRequest request){
        final  var escala = new EscalaInputModel(
                request.getEvento(),
                request.getVoluntario(),
                request.getMinisterio(),
                request.getUser()
        );
        service.save(escala);
    }
    @GetMapping(value = "/{eventoId}")
    List<EscalaResponse> escala(@PathVariable("eventoId")Long eventoId){
        final var escala = service.findEvento(eventoId);
        return escala.stream().map(EscalaResponse::entityToResponse).collect(Collectors.toList());
    }
}
