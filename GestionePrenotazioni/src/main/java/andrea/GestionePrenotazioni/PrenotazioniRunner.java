package andrea.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import andrea.GestionePrenotazioni.entities.Prenotazione;
import andrea.GestionePrenotazioni.services.PostazioniService;
import andrea.GestionePrenotazioni.services.PrenotazioniService;
import andrea.GestionePrenotazioni.services.UsersService;

public class PrenotazioniRunner implements CommandLineRunner {
	
	@Autowired
	PrenotazioniService prenotazioniService;
	@Autowired
	PostazioniService postazioniService;
	@Autowired
	UsersService usersService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Prenotazione p1 = new Prenotazione();
		p1.setDataPrenotata(LocalDate.now());
		p1.setDataPrenotazione(LocalDate.now().minusMonths(1));
		p1.setPostazione(postazioniService.findById(UUID.fromString("2ef357b7-e402-4ead-a708-7fb133163ac9")));
		p1.setUser(usersService.findById(UUID.fromString("1dc21cbc-f28b-400d-bad3-417685ba0df4")));
		prenotazioniService.create(p1);
		
		Prenotazione p2 = new Prenotazione();
		p2.setDataPrenotata(LocalDate.now());
		p2.setDataPrenotazione(LocalDate.now().minusMonths(2));
		p2.setPostazione(postazioniService.findById(UUID.fromString("3f74b838-d904-4136-ab42-d2f8d31d224a")));
		p2.setUser(usersService.findById(UUID.fromString("1dc21cbc-f28b-400d-bad3-417685ba0df4")));
		prenotazioniService.create(p2);
		
		Prenotazione p3 = new Prenotazione();
		p3.setDataPrenotata(LocalDate.now());
		p3.setDataPrenotazione(LocalDate.now().minusMonths(3));
		p3.setPostazione(postazioniService.findById(UUID.fromString("740be197-67c7-4dcb-a995-224de1f6a5b8")));
		p3.setUser(usersService.findById(UUID.fromString("051c8cb2-fadb-4609-856d-46a81c0f2289")));
		prenotazioniService.create(p3);
		
		
	}

}
