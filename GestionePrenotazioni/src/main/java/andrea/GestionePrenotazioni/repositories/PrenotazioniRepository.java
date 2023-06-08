package andrea.GestionePrenotazioni.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrea.GestionePrenotazioni.entities.Prenotazione;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {
    List<Prenotazione> findByUserEmail(String userEmail);
}

