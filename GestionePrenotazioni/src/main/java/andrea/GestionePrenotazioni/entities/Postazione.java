package andrea.GestionePrenotazioni.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@Data
@NoArgsConstructor
public class Postazione {
	@Id
	@GeneratedValue
	private UUID id;
	private String codice;
	private String descrizione;
	private int numeroMassimoOccupanti;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	public Postazione(String codice, String descrizione, int numeroMassimoOccupanti, TipoPostazione tipo, User user) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.numeroMassimoOccupanti = numeroMassimoOccupanti;
		this.tipo = tipo;
		this.user = user;
	}
	
	
}
