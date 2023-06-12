package andrea.GestionePrenotazioni;

import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import andrea.GestionePrenotazioni.entities.Citta;
import andrea.GestionePrenotazioni.entities.Edificio;
import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.services.CittaService;
import andrea.GestionePrenotazioni.services.EdificioService;
import andrea.GestionePrenotazioni.services.UsersService;



@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;
	@Autowired
	private PasswordEncoder bcrypt;
	@Autowired
	CittaService cittaService;
	@Autowired
	EdificioService edificioService;

	@Override
	public void run(String... args) throws Exception {
		
		Faker faker = new Faker(new Locale("it"));
		
		for (int i = 0; i < 10; i++) {
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			String email = faker.internet().emailAddress();
			String password = bcrypt.encode(faker.internet().password());
			UserRegistrationPayload user = new UserRegistrationPayload();
			user.setName(name);
			user.setSurname(surname);
			user.setEmail(email);
			user.setPassword(password);
			usersService.create(user);
		}
		String name = faker.funnyName().name();
		
		Citta c1 = new Citta();
		c1.setNome(name);
		cittaService.create(c1);
	
	
	String name2  = faker.funnyName().name();
	String code = "12ab34cd";
	Edificio ed1 = new Edificio();
	ed1.setCitta(cittaService.findById(UUID.fromString("927085f4-d21b-4e0b-9e47-52821685059c")));
	ed1.setNome(name2);
	ed1.setCodiceSicurezza(bcrypt.encode(code));
	ed1.setIndirizzo("Via Vattelappesca, 34");
	edificioService.save(ed1);
	
	}

}