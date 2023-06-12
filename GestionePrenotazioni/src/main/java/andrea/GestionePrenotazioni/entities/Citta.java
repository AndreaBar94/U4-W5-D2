package andrea.GestionePrenotazioni.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "citta")
@Data
public class Citta {
	@Id
	@GeneratedValue
	private UUID id;
	
	private String nome;
	
	
}
