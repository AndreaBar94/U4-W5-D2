package andrea.GestionePrenotazioni.entities;

import java.time.LocalDate;

public class Prenotazione {
	
	private int id;
	private User user;
	private Postazione postazione;
	private LocalDate dataPrenotata;
	private LocalDate dataPrenotazione;
	
	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata, LocalDate dataPrenotazione) {
		super();
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
}
