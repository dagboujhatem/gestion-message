package fr.cacib.gestion_message.config;

import fr.cacib.gestion_message.services.MessageService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableJms
@Slf4j
@Data
public class MessageListener {
    private final MessageService messageService;
    private final IBMMQProperties mqProperties;
    private final JmsTemplate jmsTemplate;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @JmsListener(destination = "${ibm.mq.queue}")
    public void receiveMessage(String message) {
        // Process the message
        log.info("Message reçu : {}" , message);
        messageService.receiveMessage(message);
    }

    @Scheduled(fixedRate = 60000) // Chaque minute
    public void sendMessage() {
        String date = dateFormat.format(new Date());
        //log.info("The time is now {}", date);
        String message = """ 
The time is now : %s""".formatted(date);
        log.info("Envoie du message ( {} ) dans : {}" , message ,mqProperties.getQueue());
        jmsTemplate.convertAndSend(mqProperties.getQueue(), message);
    }
}
