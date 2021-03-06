package br.com.capivaratecnologia.apiatosdecristo;

import br.com.capivaratecnologia.apiatosdecristo.entities.UserE;
import br.com.capivaratecnologia.apiatosdecristo.repositoris.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Optional;

@SpringBootApplication()
public class ApiAtosDeCristoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAtosDeCristoApplication.class, args);


	}

@Bean
 public Filter getChaset(){
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return encodingFilter;
 }
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};

	}
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		UserE admin = new UserE();
		admin.setName("Berguison");
		admin.setEmail("capivaratecnologia@gmail.com");
		admin.setPassword(passwordEncoder.encode("!@#qweasdzxc"));
		admin.setRole("ADMIN");

		Optional<UserE> find = userRepository.findByEmail("capivaratecnologia@gmail.com");
		if (find.isEmpty()) {
			userRepository.save(admin);
		}

	}

}
