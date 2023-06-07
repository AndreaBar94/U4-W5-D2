package andrea.GestionePrenotazioni.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.Postazione;
import andrea.GestionePrenotazioni.entities.Prenotazione;
import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.repositories.PostazioniRepository;
import andrea.GestionePrenotazioni.repositories.PrenotazioniRepository;


@Service
public class PrenotazioniService {
	

	@Autowired
	private PrenotazioniRepository prenotazioniRepo;

	public Prenotazione create(Prenotazione prenotazione) {
		return prenotazioniRepo.save(prenotazione);
	}
	
	public Page<Prenotazione> find(int page, int size, String sortedBy){
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortedBy));
		
		return prenotazioniRepo.findAll(pageable);
	}
	
	public Prenotazione findById(UUID id) throws Exception{
		return prenotazioniRepo.findById(id).orElseThrow(()-> new Exception("Prenotazione non trovata"));
	}
	
	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione p) throws Exception {
		Prenotazione found = this.findById(id);
	
		found.setDataPrenotata(p.getDataPrenotata());
		found.setDataPrenotazione(p.getDataPrenotazione());
		found.setPostazione(p.getPostazione());
		found.setUser(p.getUser());
		return prenotazioniRepo.save(found);
	}
	
	public void findByIdAndDelete(UUID id) throws Exception {
		Prenotazione found = this.findById(id);
		prenotazioniRepo.delete(found);
	}
	
}
