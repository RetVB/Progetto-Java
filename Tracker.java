package ticketing;

import java.util.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;


public class Tracker {

	private String url;
	private TreeMap<String, Utente> utenti = new TreeMap<String, Utente>();
	private TreeMap<String, Prodotto> prodotti = new TreeMap<String, Prodotto>();
	private TreeMap<Long, Ticket> tickets = new TreeMap<Long, Ticket>();
	private int numProdotto = 0;
	private long numTicket = 0;
	
    public Tracker(String url){
        this.url =url; 
    }
    
    public String getURL(){
        return url;
    }
    
    public void nuovoUtente(String nick, String nome, String email, String pwd) throws InvalidInformationException {
    	if (nick == null || email == null || pwd == null)
    		throw new InvalidInformationException();
    	utenti.put(nick, new Utente(nick, nome, email, pwd));
    }
    
    public Utente getUtente(String nick){
        return utenti.get(nick);
    }
    
    public Collection<Utente> getUtenti(){
        return utenti.values();
    }
    
    public String nuovoProdotto(String nome, String descrizione) throws InvalidInformationException {
        if (nome == null || descrizione == null)
        	throw new InvalidInformationException();
        numProdotto++;
        String codice = "P" + String.valueOf(numProdotto);
        prodotti.put(codice, new Prodotto(nome, descrizione, codice));
        return codice;
    }
    
    public Prodotto getProdotto(String code){
        return prodotti.get(code);
    }

    public Collection<Prodotto> getProdotti(){
        return prodotti.values();
    }
    
    public Ticket nuovoTicket(String codiceProdotto, String nick, String etichetta){
        numTicket++;
        Prodotto prodotto = getProdotto(codiceProdotto);
        Utente utente = getUtente(nick);
        utente.incrementaNumeroTicket();
        Ticket ticket = new Ticket(numTicket, utente, prodotto, etichetta, System.currentTimeMillis(), this);
        tickets.put(numTicket, ticket);
        prodotto.aggiungiTicket(ticket);
        return ticket;
        
    }
    
    public Ticket getTicket(long code){
        return tickets.get(code);
    }
    
    public List<Ticket> getTickets(){ 

    	return tickets.values().stream().sorted(comparing(Ticket::getTimestamp, reverseOrder())).collect(toList());
    }
    
    public List<Prodotto> prodottiPerTicket(){ 

    	return prodotti.values().stream().sorted(comparing(Prodotto::numeroTicket, reverseOrder())).collect(toList());
    }
    
    public List<Utente> utentiPerTicket(){ 

    	return utenti.values().stream().sorted(comparing(Utente::numeroTicket, reverseOrder())).collect(toList());
    }
    
    
}
