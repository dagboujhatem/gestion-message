package fr.cacib.gestion_message.controllers;

import fr.cacib.gestion_message.model.Partenaire;
import fr.cacib.gestion_message.services.PartenaireService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/partenaires")
@Data
public class PartenaireController {

    private final PartenaireService partenaireService;

    @GetMapping
    public Page<Partenaire> getAllPartenaires(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return partenaireService.getAllPartenaires(pageable);
    }
    @PostMapping
    public Partenaire createPartenaire(@RequestBody Partenaire partenaire) {
        return partenaireService.createPartenaire(partenaire);
    }
    @GetMapping("/{id}")
    public Partenaire getPartenaireById(@PathVariable Long id) {
        return partenaireService.getPartenaireById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePartenaire(@PathVariable Long id) {
        partenaireService.deletePartenaire(id);
    }
}
