package andrea.GestionePrenotazioni.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andrea.GestionePrenotazioni.auth.JWTTools;
import andrea.GestionePrenotazioni.entities.Prenotazione;
import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.exceptions.NotFoundException;
import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.services.PrenotazioniService;
import andrea.GestionePrenotazioni.services.UsersService;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	PrenotazioniService prenotazioniService;
	
	// 1. - GET http://localhost:3001/users (+opzionalmente query params) <-- READ
	@GetMapping("")
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortedBy){
		return usersService.find(page, size, sortedBy);
	}

	// 2. - POST http://localhost:3001/users (+ req.body) <-- CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public User saveUser(@RequestBody @Validated UserRegistrationPayload body) {
		return usersService.create(body);
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{userId}")
	public User findById(@PathVariable UUID userId) throws Exception {

		return usersService.findById(userId);
	}

	
	// 4. - PUT http://localhost:3001/users/:userId (+ req.body) <-- UPDATE
	@PutMapping("/{userId}")
	public User findByIdAndUpdate(@PathVariable UUID userId, @RequestBody User body) throws Exception {

		return usersService.findByIdAndUpdate(userId, body);
	}

	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable UUID userId) throws Exception {

		usersService.findByIdAndDelete(userId);
	}
	
	@GetMapping("/prenotazioniutente")
	public List<Prenotazione> getPrenotazioniUtente(@RequestHeader("Authorization") String token) {
	    try {
	        JWTTools.isTokenValid(token);
	        String userEmail = JWTTools.extractSubject(token);
	        List<Prenotazione> prenotazioni = prenotazioniService.findByUserEmail(userEmail);
	        return prenotazioni;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return new ArrayList<>(); // In caso di errore, ritorna una lista vuota
	}
	
}

