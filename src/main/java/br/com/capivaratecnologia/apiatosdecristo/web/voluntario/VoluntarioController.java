package br.com.capivaratecnologia.apiatosdecristo.web.voluntario;

import br.com.capivaratecnologia.apiatosdecristo.services.VoluntarioService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.VoluntarioInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.RegisterUserRequet;
import br.com.capivaratecnologia.apiatosdecristo.web.voluntario.dto.VoluntarioRequet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
