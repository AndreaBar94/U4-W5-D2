package andrea.GestionePrenotazioni.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import andrea.GestionePrenotazioni.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID>{
	
}
