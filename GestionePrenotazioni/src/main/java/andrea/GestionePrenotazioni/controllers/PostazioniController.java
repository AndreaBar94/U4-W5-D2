package andrea.GestionePrenotazioni.controllers;

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

import andrea.GestionePrenotazioni.entities.Postazione;
import andrea.GestionePrenotazioni.services.PostazioniService;


@RestController
@RequestMapping("/postazioni")
public class PostazioniController {
	
	@Autowired
	PostazioniService postazioniService;

	@GetMapping("")
	public Page<Postazione> getPostazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortedBy){
		return postazioniService.find(page, size, sortedBy);
	}

	// 2. - POST http://localhost:3001/users (+ req.body) <-- CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public Postazione savePostazione(@RequestBody Postazione body) {
		return postazioniService.create(body);
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{postazioneId}")
	public Postazione findById(@PathVariable UUID postazioneId) throws Exception {

		return postazioniService.findById(postazioneId);
	}

	
	// 4. - PUT http://localhost:3001/users/:userId (+ req.body) <-- UPDATE
	@PutMapping("/{postazioneId}")
	public Postazione findByIdAndUpdate(@PathVariable UUID postazioneId, @RequestBody Postazione body) throws Exception {

		return postazioniService.findByIdAndUpdate(postazioneId, body);
	}

	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{postazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable UUID postazioneId) throws Exception {

		postazioniService.findByIdAndDelete(postazioneId);
	}

}
