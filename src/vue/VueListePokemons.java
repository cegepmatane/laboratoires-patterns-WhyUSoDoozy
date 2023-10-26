package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurListePokemon;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import modele.Pokemon;

public class VueListePokemons extends Vue {
	String MESSAGE_TOTAL_NOUVELLES = "Il y a {total} pokemons";

	protected ControleurListePokemon controleur = null;
	protected static VueListePokemons instance = null; 
	public static VueListePokemons getInstance() {if(null==instance)instance = new VueListePokemons();return VueListePokemons.instance;}; 

	private VueListePokemons() {
		super("nouvelles-simple.fxml", VueListePokemons.class);
		Logger.logMsg(Logger.INFO, "new VueListePokemons()");
		super.controleur = this.controleur = new ControleurListePokemon();
	}
	
	public void afficherTotal(int total)
	{
		System.out.println("VueNouvellesSimple.afficherTotal()");
		
		Label vueTotal = (Label)lookup("#total-pokemons");
		System.out.println(vueTotal);
		
		//vueTotal.setText("Coucou");
		
		vueTotal.setText("Il y a " + total + " pokemons");
		
		//vueTotal.setText(MESSAGE_TOTAL_NOUVELLES.replace("{total}", ""+total));
	}
	
	public void afficherPokemons(List<Pokemon> pokemons)
	{
		System.out.println("VueNouvellesSimple.afficherPokemons()");
		
		FlowPane vueNouvelles = (FlowPane)lookup("#liste-pokemons");
				
		for(Pokemon pokemon : pokemons)
		{
			TextArea vuePokemons = new TextArea();
			vuePokemons.setMaxSize(500, 20);
			vuePokemons.setText(pokemon.getNom());
			vueNouvelles.getChildren().add(vuePokemons);
		}
		
		
	}
	
	
}
