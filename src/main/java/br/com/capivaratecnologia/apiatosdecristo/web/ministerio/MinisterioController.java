package br.com.capivaratecnologia.apiatosdecristo.web.ministerio;

import br.com.capivaratecnologia.apiatosdecristo.entities.MinisterioE;
import br.com.capivaratecnologia.apiatosdecristo.services.MinisterioService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinVolunInputModel;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.MinisterioInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinVolunRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ministerio")
@RequiredArgsConstructor
public class MinisterioController {
    private final MinisterioService service;

    @GetMapping(value = "/")
    List<MinisterioResponse> minis(){
        final var ministerio = service.findALL();
        return ministerio.stream().map(MinisterioResponse::entityToResponse).collect(Collectors.toList());
}
    @GetMapping(value = "/{userId}")
    List<MinisterioResponse> findmy(@PathVariable("userId")Long userId){
        final var menus = service.findMyVoluntarios(userId);
        return menus.stream().map(MinisterioResponse::entityToResponse).collect(Collectors.toList());
    }
    @PostMapping(value = "/")
    public void save(@RequestBody MinisterioRequest request){
        final var input = new MinisterioInputModel(
                request.getNome()
        );
        service.save(input);
    }
    @PostMapping(value = "/volun")
    public void saveVoluntario(@RequestBody MinVolunRequest request){
        final var input = new MinVolunInputModel(
               request.getIdMinisterio(),
                request.getIdVoluntario()
        );
        service.saveVoluntario(input);
    }
}
