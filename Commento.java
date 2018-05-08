package ticketing;

public class Commento {

	private Utente autore;
	private Ticket ticket;
	private String testo;
	private long timestamp;
	
	public Commento(Utente autore, Ticket ticket, String testo, long timestamp) {
		this.autore = autore;
		this.ticket = ticket;
		this.testo = testo;
		this.timestamp = timestamp;
	}
	
    public Utente getAutore() {
        return autore;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public String getTesto() {
        return testo;
    }
    public long getTimestamp() {
        return timestamp;
    }
    
    
}
