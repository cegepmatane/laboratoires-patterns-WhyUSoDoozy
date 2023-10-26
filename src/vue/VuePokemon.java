package vue;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurPokemon;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VuePokemon extends Vue {
	String MESSAGE_TOTAL_NOUVELLES = "Il y a {total} pokemons";

	protected ControleurPokemon controleur = null;
	protected static VuePokemon instance = null; 
	public static VuePokemon getInstance() {if(null==instance)instance = new VuePokemon();return VuePokemon.instance;}; 

	private VuePokemon() {
		super("pokemon.fxml", VuePokemon.class);
		Logger.logMsg(Logger.INFO, "new VuePokemon()");
		super.controleur = this.controleur = new ControleurPokemon();
	}
	
	// credit https://www.vecteezy.com/vector-art/141969-set-icon-characters-of-pokemon
	public void afficherPokemon()
	{
		System.out.println("VuePokemon.afficherPokemon()");

		// TESTS avec des images
		
		// <Image url="@decoration/pokemon/pokemon-1.png" />
		ImageView vuePhoto = (ImageView)lookup("#pokemon-photo");
		vuePhoto.setImage(new Image("/vue/decoration/pokemon/pokemon-2.png"));
		vuePhoto.setImage(new Image("/pokemon/pokemon-5.png"));
		vuePhoto.setImage(new Image("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png"));
		
	}
	
	
}
