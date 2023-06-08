package andrea.GestionePrenotazioni.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andrea.GestionePrenotazioni.entities.Prenotazione;

import andrea.GestionePrenotazioni.services.PrenotazioniService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@Autowired
	PrenotazioniService prenotazioniService;

	@GetMapping("")//aggiungo controllo per user
	public Page<Prenotazione> getPrenotazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortedBy){
		return prenotazioniService.find(page, size, sortedBy);
	}

	// 2. - POST http://localhost:3001/users (+ req.body) <-- CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public Prenotazione savePrenotazioni(@RequestBody Prenotazione body) {
		return prenotazioniService.create(body);
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{prenotazioneId}")
	public Prenotazione findById(@PathVariable UUID prenotazioneId) throws Exception {

		return prenotazioniService.findById(prenotazioneId);
	}

	@GetMapping("/user/{email}")
	public List<Prenotazione> getPrenotazioniByUserEmail(@PathVariable String email) throws Exception {
	    return prenotazioniService.findByUserEmail(email);
	}

	
	// 4. - PUT http://localhost:3001/users/:userId (+ req.body) <-- UPDATE
	@PutMapping("/{prenotazioneId}")
	public Prenotazione findByIdAndUpdate(@PathVariable UUID prenotazioneId, @RequestBody Prenotazione body) throws Exception {

		return prenotazioniService.findByIdAndUpdate(prenotazioneId, body);
	}

	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{prenotazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable UUID prenotazioneId) throws Exception {

		prenotazioniService.findByIdAndDelete(prenotazioneId);
	}

}
