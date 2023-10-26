package controleur;

import java.util.List;
import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import donnee.PokemonDAO;
import modele.Pokemon;
import vue.VueListePokemons;

public class ControleurListePokemon extends Controleur {

	public ControleurListePokemon()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	public void initialiser()
	{
		// VueNouvellesSimple.getInstance().afficherTotal();
		VueListePokemons vue = VueListePokemons.getInstance();
		vue.afficherTotal(3);
		
		PokemonDAO dao = new PokemonDAO();
		
		List<Pokemon> pokemons = dao.listerPokemons();
		vue.afficherPokemons(pokemons);
		
	}

}
