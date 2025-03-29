package database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        // EntityManagerFactory für die Persistence Unit "require4testingPU" erstellen
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("require4testingPU");
        // EntityManager erstellen, um mit der Datenbank zu interagieren
        EntityManager em = emf.createEntityManager();

        try {
            // Transaktion starten
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Hier ein einfaches Testobjekt (Requirement) anlegen
            Requirement requirement = new Requirement();
            requirement.setTitle("Test Requirement");
            requirement.setDescription("This is a test requirement.");
            requirement.setCreatedDate(new java.util.Date());

            // Speichern des Test-Objekts in der Datenbank
            em.persist(requirement);

            // Transaktion committen
            transaction.commit();

            // Erfolgsmeldung
            System.out.println("Requirement gespeichert: " + requirement.getTitle());

        } catch (Exception e) {
            // Fehlerbehandlung
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback im Fehlerfall
            }
        } finally {
            // EntityManager und EntityManagerFactory schließen
            em.close();
            emf.close();
        }
    }
}
