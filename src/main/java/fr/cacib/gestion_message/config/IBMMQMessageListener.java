package fr.cacib.gestion_message.config;

import fr.cacib.gestion_message.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.jms.*;

@Component
@Slf4j
public class IBMMQMessageListener {
    @Autowired
    private MessageService messageService;

    public void listenToQueue(ConnectionFactory connectionFactory, String queueName) {
        Connection connection = null;
        Session session = null;

        try {
            // Create a JMS connection
            connection = connectionFactory.createConnection();

            // Start the connection
            connection.start();

            // Create a JMS session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create a queue
            Queue queue = session.createQueue(queueName);

            // Create a consumer for the queue
            MessageConsumer consumer = session.createConsumer(queue);

            log.info("Listening for messages on queue: {}" , queueName);

            // Set a listener for incoming messages
            consumer.setMessageListener(message -> {
                if (message instanceof TextMessage) {
                    try {
                        String text = ((TextMessage) message).getText();
                        log.info("Received message: {}" , text);
                        messageService.receiveMessage(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else {
                    log.info("Received non-text message: {}" , message);
                }
            });

            // Keep the listener active (or manage lifecycle as needed)
            Thread.sleep(100000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (session != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

