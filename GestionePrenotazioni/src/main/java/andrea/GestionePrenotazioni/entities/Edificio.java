package andrea.GestionePrenotazioni.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Edificio {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String indirizzo;
	
	@ManyToOne
	private Citta citta;
	
	
	@Column(name = "codice_sicurezza")
	private String codiceSicurezza;


	public Edificio(String nome, String indirizzo, Citta citta, String codiceSicurezza) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.codiceSicurezza = codiceSicurezza;
	}
	
	
}
