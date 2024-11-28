package fr.cacib.gestion_message.controllers;

import fr.cacib.gestion_message.model.Message;
import fr.cacib.gestion_message.services.MessageService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
@Data
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public Page<Message> getMessages(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageService.getMessages(pageable);
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }


}
