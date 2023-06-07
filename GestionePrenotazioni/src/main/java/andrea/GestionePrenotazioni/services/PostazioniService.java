package andrea.GestionePrenotazioni.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.Postazione;
import andrea.GestionePrenotazioni.repositories.PostazioniRepository;


@Service
public class PostazioniService {
	
	@Autowired
	private PostazioniRepository postazioniRepo;

	public Postazione create(Postazione p) {
		return postazioniRepo.save(p);
	}
	
	public Page<Postazione> find(int page, int size, String sortedBy){
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortedBy));
		
		return postazioniRepo.findAll(pageable);
	}
	
	public Postazione findById(UUID id) throws Exception{
		return postazioniRepo.findById(id).orElseThrow(()-> new Exception("Postazione non trovata"));
	}
	
	public Postazione findByIdAndUpdate(UUID id, Postazione p) throws Exception {
		Postazione found = this.findById(id);
	
		found.setCodice(p.getCodice());
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setNumeroMassimoOccupanti(p.getNumeroMassimoOccupanti());
		return postazioniRepo.save(found);
	}
	
	public void findByIdAndDelete(UUID id) throws Exception {
		Postazione found = this.findById(id);
		postazioniRepo.delete(found);
	}
}
