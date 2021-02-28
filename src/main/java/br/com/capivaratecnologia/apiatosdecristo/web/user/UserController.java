package br.com.capivaratecnologia.apiatosdecristo.web.user;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.UserNotFoundException;
import br.com.capivaratecnologia.apiatosdecristo.services.UserService;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.LoginRequest;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.LoginResponse;
import br.com.capivaratecnologia.apiatosdecristo.web.user.dto.RegisterUserRequet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/auth")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){

        try {
        final var user = userService.login(loginRequest.getEmail(),loginRequest.getPassword());
        return ResponseEntity.ok(LoginResponse.entityToResponse(user));
        } catch (UserNotFoundException e) {
           return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }

    @PostMapping(value = "/")
    private void resgiter(@RequestBody RegisterUserRequet requet){
        final var inputModel = new UserRegisterInputModel(
                requet.getName(),
                requet.getEmail(),
                requet.getPassword()
        );
        userService.register(inputModel);
    }
}
