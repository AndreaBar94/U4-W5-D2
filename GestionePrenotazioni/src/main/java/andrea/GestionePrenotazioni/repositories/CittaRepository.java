package andrea.GestionePrenotazioni.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrea.GestionePrenotazioni.entities.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, UUID>{

}

