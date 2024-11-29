package fr.cacib.gestion_message.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ibm.mq")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IBMMQProperties {
    private String queueManager;
    private String channel;
    private String connName;
    private String user;
    private String password;
    private String queue;
}
