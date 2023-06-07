package andrea.GestionePrenotazioni.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrea.GestionePrenotazioni.entities.Postazione;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID>{

}
