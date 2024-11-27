package fr.cacib.gestion_message.model;

import fr.cacib.gestion_message.model.enums.EDirection;
import fr.cacib.gestion_message.model.enums.EProcessedFlowType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String alias;
    private String type;
    private EDirection direction;
    private String application;
    private EProcessedFlowType processedFlowType;
    private String description;
}
