package br.com.capivaratecnologia.apiatosdecristo.services;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSeviceImpl implements UserDetailsService {

    @Autowired
    private  PasswordEncoder encoder;
    private  UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserE usuario = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        final var roles = usuario.getRole() ;


        return User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(roles)
                .build();
    }
    }

