package andrea.GestionePrenotazioni;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.javafaker.Faker;

import andrea.GestionePrenotazioni.entities.Citta;
import andrea.GestionePrenotazioni.entities.Edificio;
import andrea.GestionePrenotazioni.services.CittaService;
import andrea.GestionePrenotazioni.services.EdificioService;

//public class CittaRunner implements CommandLineRunner{
//	
//	@Autowired
//	CittaService cittaService;
//	@Autowired
//	EdificioService edificioService;
//	@Autowired
//	private PasswordEncoder bcrypt;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Faker faker = new Faker(new Locale("it"));
//		
//			String name = faker.funnyName().name();
//			
//			Citta c1 = new Citta();
//			c1.setNome(name);
//			cittaService.create(c1);
//		
//		
//		String name2  = faker.funnyName().name();
//		String code = "12ab34cd";
//		Edificio ed1 = new Edificio();
//		ed1.setCitta(c1);
//		ed1.setNome(name2);
//		ed1.setCodiceSicurezza(bcrypt.encode(code));
//		ed1.setIndirizzo("Via Vattelappesca, 34");
//	}
//
//}
