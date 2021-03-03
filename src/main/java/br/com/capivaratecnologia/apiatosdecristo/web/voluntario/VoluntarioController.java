package br.com.capivaratecnologia.apiatosdecristo.web.voluntario;

import br.com.capivaratecnologia.apiatosdecristo.services.VoluntarioService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.VoluntarioInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.VoluntaResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.RegisterUserRequet;
import br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto.VoluntarioRequet;
import br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto.VoluntarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/voluntario")
public class VoluntarioController {
    private final VoluntarioService service;




    @PostMapping(value = "/")
    private void save(@RequestBody VoluntarioRequet requet){
        final var inputModel = new VoluntarioInputModel(
                requet.getNome(),
                requet.getContato()

        );
        service.save(inputModel);
    }
    @GetMapping(value = "/")
    List<VoluntarioResponse> minis(){
        final var ministerio = service.findALL();
        return ministerio.stream().map(VoluntarioResponse::entityToResponse).collect(Collectors.toList());}
}
