package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.exeception.SenhaInvalidaException;
import br.com.capivaratecnologia.apiatosdecristo.exeception.UserNotFoundException;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.UserRepository;
import br.com.capivaratecnologia.apiatosdecristo.viewModels.UserRegisterInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private  UserRepository repository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public Optional<UserE> login(String email, String password) throws UserNotFoundException{
        final var useropt = repository.findByEmail(email);
        boolean senhasBatem = passwordEncoder.matches( password, useropt.get().getPassword() );

        if(senhasBatem){
            return useropt;
        }

        throw new SenhaInvalidaException();
    }

    public  void register(UserRegisterInputModel model){
        final var password = passwordEncoder.encode(model.getPassword());
        final var user = new UserE();
        user.setEmail(model.getEmail());
        user.setName(model.getName());
        user.setPassword(password);
        user.setRole(model.getRole());

        repository.save(user);
    }

    public  void update(UserRegisterInputModel model){
        final var password = passwordEncoder.encode(model.getPassword());
        final var userResp = repository.findById(model.getId());
        final var user = new UserE();
        user.setId(model.getId());

        if(model.getName()==""||model.getName()==null){
            user.setName(userResp.get().getName());
        }else {
            user.setName(model.getName());
        }
        if(model.getEmail()==""||model.getEmail()==null){
            user.setEmail(userResp.get().getEmail());
        }else {
            user.setEmail(model.getEmail());
        }
        if(model.getPassword()==""||model.getPassword()==null){
            user.setPassword(userResp.get().getPassword());
        }else {
            user.setPassword(password);
        }
        if(model.getRole()==""||model.getRole()==null){
            user.setRole(userResp.get().getRole());
        }else {
            user.setRole(model.getRole());
        }





        repository.save(user);
    }


    public Optional<UserE> findByEmail(String email){
        return  repository.findByEmail(email);

    }
    public Optional<UserE> findById(Long id){
        return  repository.findById(id);

    }
    public List<UserE> findAll(){
        return  repository.findAll(Sort.by("name"));

    }

    public  void deliteUser(Long  id_user){

        repository.deleteById(id_user);

    }

}

