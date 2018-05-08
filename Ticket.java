package ticketing;

import java.util.*;

public class Ticket {

	private long codice;
	private Utente creatore;
	private Prodotto prodotto;
	private String etichetta;
	private long timestamp;
	private int numCommento = 0;
	TreeMap<Integer, Commento> commenti = new TreeMap<Integer, Commento>();
	private Tracker tracker;
	
	public Ticket(long codice, Utente creatore, Prodotto prodotto, String etichetta, long timestamp, Tracker tracker) {
		this.codice = codice;
		this.creatore = creatore;
		this.prodotto = prodotto;
		this.etichetta = etichetta;
		this.timestamp = timestamp;
		this.tracker = tracker;
	}
	
    public long getCodice(){
        return codice;
    }
    public Utente getCreatore() {
        return creatore;
    }
    public Prodotto getProdotto() {
        return prodotto;
    }
    public String getEtichetta() {
        return etichetta;
    }
    public long getTimestamp() {
        return timestamp;
    }
    
    public Commento nuovoCommento(String nick, String testo){
    	Commento commento = new Commento(tracker.getUtente(nick), this, testo, System.currentTimeMillis());
    	numCommento++;
        commenti.put(numCommento, commento);
        return commento;
    }

    public List<Commento> getCommenti(){ // DA VERIFICARE
    	Comparator<Commento> comparatore = new Comparator<Commento>() {
    		public int compare(Commento commento1, Commento commento2) {
    			if (commento1.getTimestamp() > commento2.getTimestamp())
    				return -1;
    			else if (commento1.getTimestamp() == commento2.getTimestamp())
    				return 0;
    			else
    				return 1;
    		}
    	};
    	TreeSet<Commento> commentiValues = new TreeSet<Commento>(comparatore);
    	commentiValues.addAll(commenti.values());    	
    	//System.out.println("Ciao " + commentiValues.size());

    	LinkedList<Commento> lista = new LinkedList<Commento>(commentiValues);
    	return lista;
    }
}
