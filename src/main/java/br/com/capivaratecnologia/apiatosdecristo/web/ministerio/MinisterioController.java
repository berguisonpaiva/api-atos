package br.com.capivaratecnologia.apiatosdecristo.web.ministerio;

import br.com.capivaratecnologia.apiatosdecristo.services.MinisterioService;
import br.com.capivaratecnologia.apiatosdecristo.services.UserService;
import br.com.capivaratecnologia.apiatosdecristo.services.VoluntarioService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinVolunInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinisterioInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinVolunRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ministerio")
public class MinisterioController {
    @Autowired
    private  MinisterioService service;
    @Autowired
    private  VoluntarioService voluntarioService;

    //Listar todos
    @GetMapping(value = "/")
    List<MinisterioResponse> findAll() {
        final var ministerio = service.findALL();

        return ministerio.stream().map(MinisterioResponse::entityToResponse).collect(Collectors.toList());
    }

    //Listar todos por Usuario
    @GetMapping(value = "/user/{userId}")
    List<MinisterioResponse> findByUser(@PathVariable("userId") Long userId) {
        final var ministerio = service.findMyVoluntarios(userId);
        return ministerio.stream().map(MinisterioResponse::entityToResponse).collect(Collectors.toList());
    }

    //Listar por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity findByid(@PathVariable("id") Long id) {
        final var ministerio = service.findByid(id);
        if (ministerio.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.ok(ministerio.stream().map(MinisterioResponse::entityToResponse)
                .collect(Collectors.toList()));
    }

    // Adicionar Ministerio
    @PostMapping(value = "/")
    public ResponseEntity save(@Valid  @RequestBody MinisterioRequest request) {
        final var resp = service.findByNome(request.getNome());
        final var input = new MinisterioInputModel(
                request.getId(),
                request.getNome(),
                request.getUser()
        );
        if (resp.isEmpty()) {
            service.save(input);
            return ResponseEntity.ok("Salvo com sucesso");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // Atualizae Ministerio
    @PutMapping(value = "/")
    public ResponseEntity update(@Valid @RequestBody MinisterioRequest request) {
        final var resp = service.findByid(request.getId());
        final var input = new MinisterioInputModel(
                request.getId(),
                request.getNome(),
                request.getUser()
        );
        if (resp.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        service.update(input);
        return ResponseEntity.ok("Atualizado com sucesso");
    }

    //Deletar Ministerio
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMinisterio(@PathVariable(value = "id") Long id) {
        final var mini = service.findByid(id);

        if (mini.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.deliteMinisterio(mini.get().getId());
        return ResponseEntity.ok("Deletado com sucesso");
    }

    //Adicionar Voluntario ao Ministerio
    @PostMapping(value = "/volun")
    public ResponseEntity saveVoluntario(@RequestBody MinVolunRequest request) {
        final var volun = voluntarioService.findById(request.getIdVoluntario());
        final var minit = service.findByid(request.getIdMinisterio());

        final var input = new MinVolunInputModel(
                request.getIdMinisterio(),
                request.getIdVoluntario()

        );
        if (volun.isEmpty() || minit.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.saveVoluntario(input);
        return ResponseEntity.ok("Salvo com sucesso");
    }

    //Deletar Voluntario ao Ministerio
    @DeleteMapping(value = "/volun/{id}")
    public ResponseEntity deleteVolutarioMinisterio(@PathVariable(value = "id") Long id) {
        final var volun = service.findVoluntarios(id);

        if (volun.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        service.deliteVoluntarioByministerio(volun.get().getId());
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
