package br.com.capivaratecnologia.apiatosdecristo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
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

}
