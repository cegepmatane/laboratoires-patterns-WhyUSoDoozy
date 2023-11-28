package modele;

public class MessageSecret {
	
	protected String texte;
	protected String auteur;
	
	public MessageSecret() {
		
	}
	
	public MessageSecret(String texte) {
		this.texte = texte;
		this.auteur = "Inconnu";
	}

	public MessageSecret(String texte, String auteur) {
		this.texte = texte;
		this.auteur = auteur;
	}
	
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
}
