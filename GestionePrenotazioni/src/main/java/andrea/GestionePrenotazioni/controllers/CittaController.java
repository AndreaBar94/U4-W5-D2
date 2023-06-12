package andrea.GestionePrenotazioni.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andrea.GestionePrenotazioni.entities.Citta;
import andrea.GestionePrenotazioni.services.CittaService;
import andrea.GestionePrenotazioni.services.EdificioService;

@RestController
@RequestMapping("/citta")
public class CittaController {
	@Autowired
	CittaService cittaService;
	

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public Citta saveCitta(@RequestBody @Validated Citta body) {
		return cittaService.create(body);
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{cittaId}")
	public Citta findByCittaId(@PathVariable Citta cittaId) throws Exception {

		return cittaService.findById(cittaId.getId());
	}


	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{cittaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable UUID cittaId) throws Exception {

		cittaService.findByIdAndDelete(cittaId);
	}
}
