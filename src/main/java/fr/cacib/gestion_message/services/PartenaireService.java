package fr.cacib.gestion_message.services;

import fr.cacib.gestion_message.model.Partenaire;
import fr.cacib.gestion_message.repositories.PartenaireRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class PartenaireService {

    private final PartenaireRepository partenaireRepository;

    public Page<Partenaire> getAllPartenaires(Pageable pageable) {
        return partenaireRepository.findAll(pageable);
    }

    public Partenaire getPartenaireById(Long id) {
        return partenaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partenaire non trouvé avec id: " + id));
    }

    public Partenaire createPartenaire(Partenaire partenaire) {
        return partenaireRepository.save(partenaire);
    }

    public void deletePartenaire(Long id) {
        partenaireRepository.deleteById(id);
    }
}
