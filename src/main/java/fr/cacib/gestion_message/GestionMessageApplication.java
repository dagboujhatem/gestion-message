package fr.cacib.gestion_message;

import fr.cacib.gestion_message.config.IBMMQMessageListener;
import jakarta.jms.ConnectionFactory;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@EnableScheduling
@Data
public class GestionMessageApplication implements CommandLineRunner {

	private final ConnectionFactory connectionFactory;
	private final IBMMQMessageListener messageListener;

	public static void main(String[] args) {
		SpringApplication.run(GestionMessageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String queueName = "TEST.QUEUE"; // Replace with your queue name
		messageListener.listenToQueue(connectionFactory, queueName);
	}
}
