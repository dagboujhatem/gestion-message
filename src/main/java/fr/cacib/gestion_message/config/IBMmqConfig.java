package fr.cacib.gestion_message.config;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
public class IBMmqConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws Exception {
        MQConnectionFactory factory = new MQConnectionFactory();
        factory.setHostName("hostname");  // Replace with your MQ hostname
        factory.setPort(1414);           // Replace with your MQ port
        factory.setQueueManager("QMGR_NAME"); // Replace with your Queue Manager name
        factory.setChannel("CHANNEL_NAME");  // Replace with your Channel name
        factory.setTransportType(WMQConstants.WMQ_CM_CLIENT); // Use CLIENT transport mode
        factory.setStringProperty(WMQConstants.USERID, "USERNAME"); // Optional
        factory.setStringProperty(WMQConstants.PASSWORD, "PASSWORD"); // Optional
        factory.setTransportType(1);  // MQJMS_TP_CLIENT_MQ_TCPIP
        return factory;
    }
}
