package andrea.GestionePrenotazioni;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.services.UsersService;



@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;
	@Autowired
	private PasswordEncoder bcrypt;
	
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
			//usersService.create(user);
		}

	}

}