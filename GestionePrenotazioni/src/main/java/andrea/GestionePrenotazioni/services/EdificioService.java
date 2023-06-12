package andrea.GestionePrenotazioni.services;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.Edificio;
import andrea.GestionePrenotazioni.repositories.EdificioRepository;

@Service
public class EdificioService {
	
	@Autowired
	EdificioRepository edificioRepository;

	public Optional<Edificio> findById( UUID id) {
		return edificioRepository.findById(id);
	}

	public Edificio save(Edificio edificio) {
		return edificioRepository.save(edificio);
	}

	
	public void delete(UUID id) {
		edificioRepository.deleteById(id);
	}

}
