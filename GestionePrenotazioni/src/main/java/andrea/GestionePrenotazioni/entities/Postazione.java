package andrea.GestionePrenotazioni.entities;

import lombok.Data;

@Data
public class Postazione {

	private int id;
	private String codice;
	private String descrizione;
	private int numeroMassimoOccupanti;
	private TipoPostazione tipo;
	
	public Postazione(int id, String codice, String descrizione, int numeroMassimoOccupanti, TipoPostazione tipo) {
		super();
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.numeroMassimoOccupanti = numeroMassimoOccupanti;
		this.tipo = tipo;
	}
	
	
}
