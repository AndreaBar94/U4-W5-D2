package andrea.GestionePrenotazioni;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.services.UsersService;



@Component
public class UsersRunner implements CommandLineRunner {
	@Autowired
	UsersService usersService;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 20; i++) {
			String name = faker.name().firstName();
			String surname = faker.name().lastName();
			String email = faker.internet().emailAddress();
			User user = new User(name, surname, email);
			usersService.create(user);
		}

	}

}