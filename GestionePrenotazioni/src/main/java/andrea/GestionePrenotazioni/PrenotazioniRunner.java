package andrea.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import andrea.GestionePrenotazioni.entities.Prenotazione;
import andrea.GestionePrenotazioni.services.PostazioniService;
import andrea.GestionePrenotazioni.services.PrenotazioniService;
import andrea.GestionePrenotazioni.services.UsersService;

@Component
public class PrenotazioniRunner implements CommandLineRunner {
	
	@Autowired
	PrenotazioniService prenotazioniService;
	@Autowired
	PostazioniService postazioniService;
	@Autowired
	UsersService usersService;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Prenotazione p1 = new Prenotazione();
//		p1.setDataPrenotata(LocalDate.now());
//		p1.setDataPrenotazione(LocalDate.now().minusMonths(1));
//		p1.setPostazione(postazioniService.findById(UUID.fromString("116e7974-1996-40ab-aabe-2babcf91a0d2")));
//		p1.setUser(usersService.findById(UUID.fromString("7db3237e-f243-4c77-9c3c-3dc470c8dc6b")));
//		p1.setUserEmail(usersService.findById(UUID.fromString("7db3237e-f243-4c77-9c3c-3dc470c8dc6b")).getEmail());
//		prenotazioniService.create(p1);
//		
//		Prenotazione p2 = new Prenotazione();
//		p2.setDataPrenotata(LocalDate.now());
//		p2.setDataPrenotazione(LocalDate.now().minusMonths(2));
//		p2.setPostazione(postazioniService.findById(UUID.fromString("9388c986-ceea-482e-9e8d-bc44bda13991")));
//		p2.setUser(usersService.findById(UUID.fromString("815c7316-0b43-4a0c-8d83-ef2c6de38482")));
//		p2.setUserEmail(usersService.findById(UUID.fromString("815c7316-0b43-4a0c-8d83-ef2c6de38482")).getEmail());
//		prenotazioniService.create(p2);
//		
//		Prenotazione p3 = new Prenotazione();
//		p3.setDataPrenotata(LocalDate.now());
//		p3.setDataPrenotazione(LocalDate.now().minusMonths(3));
//		p3.setPostazione(postazioniService.findById(UUID.fromString("bcf9fa04-3080-429d-97b6-0fd52fd2f1a8")));
//		p3.setUser(usersService.findById(UUID.fromString("81e3f717-66b8-40a7-9520-ddac99054863")));
//		p3.setUserEmail(usersService.findById(UUID.fromString("815c7316-0b43-4a0c-8d83-ef2c6de38482")).getEmail());
//		prenotazioniService.create(p3);
		
		
	}

}
