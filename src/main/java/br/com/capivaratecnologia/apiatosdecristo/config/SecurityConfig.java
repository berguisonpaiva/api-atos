package br.com.capivaratecnologia.apiatosdecristo.config;


import br.com.capivaratecnologia.apiatosdecristo.services.UsuarioSeviceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  UsuarioSeviceImpl usuarioSevice;


    @Bean
    public PasswordEncoder passwordEncoder() {
         return  new BCryptPasswordEncoder();

          }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth
               .userDetailsService(usuarioSevice)
               .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/evento/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/evento/ativo").hasAnyRole("USER", "ADMIN")
                .antMatchers("/escala/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/ministerio/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/ministerio/volun").hasAnyRole("USER", "ADMIN")
                .antMatchers("/voluntario/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/user/**")
                .permitAll()
                .anyRequest().authenticated()
        .and().httpBasic();
    }
}
