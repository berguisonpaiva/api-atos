package br.com.capivaratecnologia.apiatosdecristo.web.user;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.UserNotFoundException;
import br.com.capivaratecnologia.apiatosdecristo.services.UserService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.ministerio.dto.MinisterioResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.LoginRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.LoginResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.RegisterUserRequet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //login
    @PostMapping(value = "/auth")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {

        try {
            final var user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(LoginResponse.entityToResponse(user.get()));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }

    //Salvar
    @PostMapping(value = "/")
    public ResponseEntity resgiter(@RequestBody RegisterUserRequet requet) {
        final var user = userService.findByEmail(requet.getEmail());
        final var inputModel = new UserRegisterInputModel(
                requet.getId(),
                requet.getName(),
                requet.getEmail(),
                requet.getPassword(),
                requet.getRole()

        );
        if (user.isEmpty()) {
            userService.register(inputModel);
            return ResponseEntity.ok("Salvo com sucesso");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    //Atualizar
    @PutMapping(value = "/")
    public ResponseEntity updateUser(@RequestBody RegisterUserRequet requet) {
        final var user = userService.findById(requet.getId());
        final var userEmail = userService.findByEmail(requet.getEmail());

        final var inputModel = new UserRegisterInputModel(
                requet.getId(),
                requet.getName(),
                requet.getEmail(),
                requet.getPassword(),
                requet.getRole()

        );

        if (user.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        userService.update(inputModel);
        return ResponseEntity.ok("Atualizado com sucesso");


    }


    //Deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        final var user = userService.findById(id);
        if (user.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        userService.deliteUser(id);
        return ResponseEntity.ok("Deletado com sucesso");
    }

    //listar ById
    @GetMapping(value = "/{id}")
    List<LoginResponse> findByid(@PathVariable("id") Long id) {
        final var user = userService.findById(id);
        return user.stream().map(LoginResponse::entityToResponse).collect(Collectors.toList());
    }

    //listar Todos
    @GetMapping(value = "/")
    List<LoginResponse> findALL() {
        final var user = userService.findAll();
        return user.stream().map(LoginResponse::entityToResponse).collect(Collectors.toList());
    }
}
