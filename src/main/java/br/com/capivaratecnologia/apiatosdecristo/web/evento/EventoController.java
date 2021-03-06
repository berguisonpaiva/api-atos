package br.com.capivaratecnologia.apiatosdecristo.web.evento;

import br.com.capivaratecnologia.apiatosdecristo.services.EventoService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EventoInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.evento.dto.EventoResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/evento")
public class EventoController {
    private final EventoService service;

    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody EventoRequest request) {

        final var input = new EventoInputModel(
                request.getId(),
                request.getTitulo(),
                request.getData(),
                request.getHora(),
                request.getImg(),
                request.getStatus()


        );
        service.save(input);
        return ResponseEntity.ok("Salvo com sucesso");

    }

    @PutMapping(value = "/")
    public ResponseEntity update(@RequestBody EventoRequest request) {
        final var evento = service.findById(request.getId());
        final var input = new EventoInputModel(
                request.getId(),
                request.getTitulo(),
                request.getData(),
                request.getHora(),
                request.getImg(),
                request.getStatus()


        );
        if(evento.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.update(input);
        return ResponseEntity.ok("Atualizado com sucesso");

    }

    @GetMapping(value = "/")
    List<EventoResponse> findall() {
        final var eveto = service.findALL();
        return eveto.stream().map(EventoResponse::entityToResponse).collect(Collectors.toList());
    }

    @GetMapping(value = "/ativo")
    List<EventoResponse> findallStatus() {
        final var eveto = service.findALLStatus();
        return eveto.stream().map(EventoResponse::entityToResponse).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findByid(@PathVariable(value = "id") Long id) {
        final var eveto = service.findById(id);
        if(eveto.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(EventoResponse.entityToResponse(eveto.get()));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delet(@PathVariable(value = "id") Long id) {
        final var eveto = service.findById(id);
        if(eveto.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.delete(eveto.get().getId());
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
