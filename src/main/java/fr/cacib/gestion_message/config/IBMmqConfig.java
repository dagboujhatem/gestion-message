package fr.cacib.gestion_message.config;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class IBMmqConfig {
    private final IbmMqProperties mqProperties;

    public IBMmqConfig(IbmMqProperties mqProperties) {
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
        System.out.println("Queue Manager: " + mqProperties.getQueueManager());
        System.out.println("Channel: " + mqProperties.getChannel());
        System.out.println("Connection Name: " + mqProperties.getConnName());
        System.out.println("User: " + mqProperties.getUser());
        System.out.println("Password: " + mqProperties.getPassword());
        System.out.println("Queue: " + mqProperties.getQueue());
    }
}

