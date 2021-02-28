package br.com.capivaratecnologia.apiatosdecristo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiAtosDeCristoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAtosDeCristoApplication.class, args);
	}

}
