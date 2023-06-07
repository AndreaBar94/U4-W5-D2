package andrea.GestionePrenotazioni.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String surname;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private List<Prenotazione> prenotazioni;
	
	@OneToMany(mappedBy = "user")
	private List<Postazione> postazioni;
	
	public User(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	
}

