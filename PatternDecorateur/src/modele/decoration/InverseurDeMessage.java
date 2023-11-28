package modele.decoration;

import modele.MessageSecret;

public class InverseurDeMessage extends MessageSecret {
	
	protected MessageSecret message;
	protected String inversion;
	
	public InverseurDeMessage(MessageSecret message) {
		this.message = message;
		this.inverser();
	}
	
	private void inverser() {
		StringBuilder inverseur = new StringBuilder(this.message.getTexte());
		this.inversion = inverseur.reverse().toString();
	}
	
	public String getTexte() {		
		return this.inversion;
	}
	
	public void setTexte(String texte) {
		this.message.setTexte(texte);
		this.inverser();
	}
	
	public String getAuteur() {
		return this.message.getAuteur();
	}
	
	public void setAuteur(String auteur) {
		this.message.setAuteur(auteur);
	}
}
