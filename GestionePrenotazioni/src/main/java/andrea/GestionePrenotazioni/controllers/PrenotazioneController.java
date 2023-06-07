package andrea.GestionePrenotazioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	//PostMapping("")//creo prenotazione
//	body{
//		idUtente: "fwqfefq",
//		idPostazione: "siubhfhisw",
//		data: "2023/04/04"
//	}
//	- controllare che la prenotazione stia avvenendo prima di 2gg dalla data
//	- controllare che la postazione risulti libera per quella giornata es SELECT * FROM Prenotazioni WHERE data = :data AND idPostazione = :idPostazione
//  - controllare che l'utente non abbia già una prenotazione per quella giornata  SELECT * FROM Prenotazioni WHERE data = :data AND idUtente = :idUtente

}
