package andrea.GestionePrenotazioni.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.Citta;
import andrea.GestionePrenotazioni.entities.Postazione;
import andrea.GestionePrenotazioni.exceptions.NotFoundException;
import andrea.GestionePrenotazioni.repositories.CittaRepository;

@Service
public class CittaService {
    @Autowired
    private CittaRepository cittaRepo;

    public Citta create(Citta c){
        return cittaRepo.save(c);
    }

    public Citta findById(UUID id) throws NotFoundException {
        return cittaRepo.findById(id).orElseThrow(() -> new NotFoundException("City not found"));
    }
    
	public void findByIdAndDelete(UUID id) throws Exception {
		Citta found = this.findById(id);
		cittaRepo.delete(found);
	}
}
