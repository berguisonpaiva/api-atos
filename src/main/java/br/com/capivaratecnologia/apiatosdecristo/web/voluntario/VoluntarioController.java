package br.com.capivaratecnologia.apiatosdecristo.web.voluntario;

import br.com.capivaratecnologia.apiatosdecristo.exeception.SenhaInvalidaException;
import br.com.capivaratecnologia.apiatosdecristo.services.VoluntarioService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.VoluntarioInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto.VoluntarioRequet;
import br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto.VoluntarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/voluntario")
public class VoluntarioController {
    private final VoluntarioService service;



    //Registrar Voluntario
    @PostMapping(value = "/")
    private ResponseEntity save(@RequestBody VoluntarioRequet requet){
        final var volu = service.findByNome(requet.getNome());
        final var inputModel = new VoluntarioInputModel(
                requet.getId(),
                requet.getNome(),
                requet.getContato()

        );
        if (volu.isEmpty()){
            service.save(inputModel);
            return ResponseEntity.ok("Salvo com sucesso");
        }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //Atualiza Voluntario
    @PutMapping(value = "/")
    private ResponseEntity update(@RequestBody VoluntarioRequet requet){
        final var volu = service.findById(requet.getId());
        final var inputModel = new VoluntarioInputModel(
                requet.getId(),
                requet.getNome(),
                requet.getContato()

        );
        if (volu.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        service.update(inputModel);
        return ResponseEntity.ok("Atualizado com sucesso");
    }

    //listar voluntarios
    @GetMapping(value = "/")
    List<VoluntarioResponse> minis(){
        final var ministerio = service.findALL();
        return ministerio.stream().map(VoluntarioResponse::entityToResponse).collect(Collectors.toList());}

    //Listtar voluntario por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity voluntario(@PathVariable("id")Long id){
        final var volun = service.findById(id);

        if(volun.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(VoluntarioResponse.entityToResponse(volun.get()));


    }

    //Deletar Volutario
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMinisterio(@PathVariable(value = "id") Long id) {
        final var volu = service.findById(id);

        if (volu.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.delete(volu.get().getId());
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
