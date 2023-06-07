package andrea.GestionePrenotazioni.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationPayload {
	@NotNull(message="Il nome è obbligatorio")
	@Size(min = 3, max = 30)
	String name;
	@NotNull
	String surname;
	@NotNull
	@Email(message="Inserisci un indirizzo email valido")
	String email;
}
