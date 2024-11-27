package fr.cacib.gestion_message.model.enums;

public enum EStatutMessage {
    RECU, // Le message a été écrit avec succès dans la file d'attente entrante.
    TRAITE, // Le message a été traité avec succès.
    SUPPRIME, // Le message a été supprimé de la file d'attente.
    ERREUR // Le traitement du message a échoué du fait de problèmes de validation
}
