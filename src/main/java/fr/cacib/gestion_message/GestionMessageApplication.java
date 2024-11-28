package fr.cacib.gestion_message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionMessageApplication.class, args);
	}

}
