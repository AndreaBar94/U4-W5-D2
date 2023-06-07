package andrea.GestionePrenotazioni;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import andrea.GestionePrenotazioni.entities.Postazione;
import andrea.GestionePrenotazioni.entities.TipoPostazione;
import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.services.PostazioniService;
import andrea.GestionePrenotazioni.services.UsersService;

@Component
public class PostazioniRunner implements CommandLineRunner {
	
	@Autowired
	PostazioniService postazioniService;
	@Autowired
	UsersService usersService;
	
	@Override
	public void run(String... args) throws Exception {
		
		
//		
//		Postazione pos1 = new Postazione();
//		pos1.setCodice("codice1");
//		pos1.setDescrizione("descrizione1");
//		pos1.setNumeroMassimoOccupanti(10);
//		pos1.setTipo(TipoPostazione.OPENSPACE);
//		pos1.setUser(usersService.findById(UUID.fromString("051c8cb2-fadb-4609-856d-46a81c0f2289")));	
//		
//		postazioniService.create(pos1);
//		
//		
//		Postazione pos2 = new Postazione();
//		pos2.setCodice("codice2");
//		pos2.setDescrizione("descrizione2");
//		pos2.setNumeroMassimoOccupanti(20);
//		pos2.setTipo(TipoPostazione.PRIVATO);
//		pos2.setUser(usersService.findById(UUID.fromString("1dc21cbc-f28b-400d-bad3-417685ba0df4")));	
//		
//		postazioniService.create(pos2);
//		
//		
//		Postazione pos3 = new Postazione();
//		pos3.setCodice("codice3");
//		pos3.setDescrizione("descrizione3");
//		pos3.setNumeroMassimoOccupanti(30);
//		pos3.setTipo(TipoPostazione.SALA_RIUNIONI);
//		pos3.setUser(usersService.findById(UUID.fromString("2b27de57-6805-4755-97dc-1b95bcc204c7")));	
//		
//		postazioniService.create(pos3);
	}

}
