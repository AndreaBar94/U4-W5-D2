package andrea.GestionePrenotazioni.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private long id;
	private String name;
	private String surname;
	
}

