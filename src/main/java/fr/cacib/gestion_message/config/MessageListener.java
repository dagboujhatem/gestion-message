package fr.cacib.gestion_message.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
@Slf4j
public class MessageListener {
    @JmsListener(destination = "${ibm.mq.queue}")
    public void receiveMessage(String message) {
        // Process the message
        log.info("Received message: {}" , message);
    }
}
