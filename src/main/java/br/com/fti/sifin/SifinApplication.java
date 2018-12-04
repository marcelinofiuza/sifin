package br.com.fti.sifin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.fti.sifin.configuration.SifinApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(SifinApiProperty.class)
public class SifinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SifinApplication.class, args);
	}
}
