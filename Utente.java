package ticketing;

public class Utente {

	private String nick;
	private String nome;
	private String email;
	private String pwd;
	private int numeroTicketCreati = 0;
	
	public Utente(String nick, String nome, String email, String pwd) {
		this.nick = nick;
		this.email = email;
		this.nome = nome;
		this.pwd = pwd;
	}
	
    public String getNickname(){
        return nick;
    }

    public String getName(){
        if (nome == null)
        	return new String();
        return nome;
    }
    
    public String getEmail(){
        return email;
    }
    
    public boolean authenticate(String pwd){
        return pwd.equals(this.pwd);
    }
    
    public void incrementaNumeroTicket() {
    	numeroTicketCreati++;
    }

    public long numeroTicket(){
        return numeroTicketCreati;
    }
    
}
