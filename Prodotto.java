package ticketing;

import java.util.*;

public class Prodotto {

	private String nome;
	private String descrizione;
	private String codice;
	private LinkedList<Ticket> tickets = new LinkedList<Ticket>();
	
	public Prodotto(String nome, String descrizione, String codice) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.codice = codice;
	}
	
    public String getNome(){
        return nome;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public String getCodice(){
        return codice;
    }
    
    public void aggiungiTicket(Ticket ticket) {
    	tickets.add(ticket);
    }
    
    public long numeroTicket(){
        return tickets.size();
    }
    
}
