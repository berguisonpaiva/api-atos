package br.com.capivaratecnologia.apiatosdecristo.web.escala;

import br.com.capivaratecnologia.apiatosdecristo.services.EscalaService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.EscalaInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.escala.dto.EscalaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
