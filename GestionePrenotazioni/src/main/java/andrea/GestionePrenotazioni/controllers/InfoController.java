package andrea.GestionePrenotazioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@GetMapping("")
	public String home() {
		return "Inserisci /it per le info in italiano || Insert /en for english language info";
	}
	
    @GetMapping("/it")
    public String homeIt() {
        return "Benvenuto, a seguire le regole per la prenotazione: ...";
    };

    @GetMapping("/en")
    public String homeEn() {
        return "Welcome, here you are our reservation rules: ...";
    };
}