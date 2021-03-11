package br.com.capivaratecnologia.apiatosdecristo.web.escala;

import br.com.capivaratecnologia.apiatosdecristo.entities.VoluntarioE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.ResourceNotFoudException;
import br.com.capivaratecnologia.apiatosdecristo.services.EscalaService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EscalaInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "/escala")
public class EscalaController {
    @Autowired
    private  EscalaService service;


    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody EscalaRequest request){
      final var resut = service.findByEventoByvoluntario(request.getEvento(), request.getVoluntario());
        final  var escala = new EscalaInputModel(
                request.getId(),
                request.getEvento(),
                request.getVoluntario(),
                request.getMinisterio(),
                request.getUser()
        );

        if(resut.isEmpty()){
            service.save(escala);
        return ResponseEntity.ok("Salvo com sucesso");}
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @PutMapping (value = "/")
    public ResponseEntity update(@RequestBody EscalaRequest request){
        final var resut = service.findById(request.getId());
        final  var escala = new EscalaInputModel(
                request.getId(),
                request.getEvento(),
                request.getVoluntario(),
                request.getMinisterio(),
                request.getUser()
        );

        if(resut.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
        service.update(escala);
        return ResponseEntity.ok("Atualizado com sucesso");


    }

    @GetMapping(value = "/{eventoId}")
    public ResponseEntity escala(@PathVariable("eventoId")Long eventoId){
        final var escala = service.findEvento(eventoId);

        if(escala.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(escala.stream().map(EscalaResponse::entityToResponse).collect(Collectors.toList()));
    }
    @GetMapping(value = "/")
    public ResponseEntity findall(){
        final var escala = service.findALL();

        if(escala.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(escala.stream().map(EscalaResponse::entityToResponse).collect(Collectors.toList()));
    }

    @DeleteMapping(value = "/{escalaId}")
    public ResponseEntity delete(@PathVariable("escalaId")Long escalaId){
        final var escala = service.findById(escalaId);

        if(escala.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        service.delete(escalaId);
        return ResponseEntity.ok("Deletado com sucesso");
    }

}
