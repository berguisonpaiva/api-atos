package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.UserNotFoundException;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.UserRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserE login(String email, String password) throws UserNotFoundException{
        final var useropt = repository.findByEmail(email);
        final var user =useropt.orElseThrow(()->new UserNotFoundException());
        final var isUserValid = new BCryptPasswordEncoder().matches(password,user.getPassword());
        if(!isUserValid){}
        return user;
    }

    public  void register(UserRegisterInputModel model){
        final var password = new BCryptPasswordEncoder().encode(model.getPassword());
        final var user = new UserE();
        user.setEmail(model.getEmail());
        user.setName(model.getName());
        user.setPassword(password);

        repository.save(user);
    }

}
