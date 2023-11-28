package modele.decoration;

import modele.MessageSecret;

public class MessageElite extends MessageSecret{
	protected MessageSecret message;
	protected String elite;
	
	public MessageElite() {
		
	}
	
	public MessageElite(String texte) {
		this.texte = texte;
		this.elite = "Inconnu";
	}
	
	public MessageElite(MessageSecret message) {
		this.message = message;
		this.convertirElite();
	}
	
	public void convertirElite() {
		byte[] lettres = this.message.getTexte().getBytes();
		byte[] nouveau = new byte[lettres.length];
		
		for (int position = 0; position < lettres.length; position++) {
			byte octet = lettres[position];
			char lettre = (char)lettres[position];
			System.out.println("" + (int)octet);
			if (lettre == 'e' || lettre == 'E') {
				lettre = '3';
			}
			nouveau[position] = (byte)lettre;
		}
		this.elite = new String(nouveau);
	}
	
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getAuteur() {
		return elite;
	}
	public void setAuteur(String auteur) {
		this.elite = auteur;
	}
}
