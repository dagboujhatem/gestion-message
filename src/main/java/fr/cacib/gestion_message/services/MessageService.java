package fr.cacib.gestion_message.services;

import fr.cacib.gestion_message.model.Message;
import fr.cacib.gestion_message.model.enums.EStatutMessage;
import fr.cacib.gestion_message.repositories.MessageRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Data
@Slf4j
public class MessageService {

    //private final JmsTemplate jmsTemplate;
    private final MessageRepository messageRepository;

    //@JmsListener(destination = "TEST.QUEUE")
    public void receiveMessage(String messageContent) {
        Message message = new Message();
        message.setContent(messageContent);
        message.setStatus(EStatutMessage.RECU);
        message.setReceivedAt(LocalDateTime.now());
        messageRepository.save(message);
        log.info("Le message ({}) a été bien reçu.", messageContent);
    }

    public Page<Message> getMessages(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message non trouvé avec id: " + id));
    }
}

