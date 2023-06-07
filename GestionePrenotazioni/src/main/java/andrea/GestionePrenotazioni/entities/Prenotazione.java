package andrea.GestionePrenotazioni.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
public class Prenotazione {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
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
