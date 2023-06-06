package andrea.GestionePrenotazioni.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(int id) {
		super("Item with id " + id + " not found!");
	}

}
