package fr.cacib.gestion_message.config;

//import com.ibm.mq.jms.MQConnectionFactory;
//import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.jms.ConnectionFactory;

@Configuration
@Slf4j
public class IBMMQConfig {
    private final IBMMQProperties mqProperties;

    public IBMMQConfig(IBMMQProperties mqProperties) {
        this.mqProperties = mqProperties;
    }

    @Bean
    public ConnectionFactory connectionFactory() throws Exception {
        this.printMqConfig();
        MQConnectionFactory connectionFactory = new MQConnectionFactory();
        try {
            // Set IBM MQ connection properties
            connectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
            connectionFactory.setQueueManager(mqProperties.getQueueManager());
            connectionFactory.setChannel(mqProperties.getChannel());
            connectionFactory.setConnectionNameList(mqProperties.getConnName());

            // Optional: Set user credentials if security is enabled
            if (mqProperties.getUser() != null && mqProperties.getPassword() != null) {
                connectionFactory.setStringProperty(WMQConstants.USERID, mqProperties.getUser());
                connectionFactory.setStringProperty(WMQConstants.PASSWORD, mqProperties.getPassword());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error configuring MQConnectionFactory", e);
        }
        return connectionFactory;
    }

    public void printMqConfig() {
        log.info("Queue Manager: {}" , mqProperties.getQueueManager());
        log.info("Channel: {}" ,  mqProperties.getChannel());
        log.info("Connection Name: {}" , mqProperties.getConnName());
        log.info("User: {}" , mqProperties.getUser());
        log.info("Password: {}" ,  mqProperties.getPassword());
        log.info("Queue: {}" ,  mqProperties.getQueue());
    }
}

