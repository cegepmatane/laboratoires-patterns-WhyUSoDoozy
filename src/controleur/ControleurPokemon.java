package controleur;

import com.sun.media.jfxmedia.logging.Logger;
import architecture.Controleur;
import donnee.PokemonDAO;
import vue.VuePokemon;

public class ControleurPokemon extends Controleur {

	public ControleurPokemon()
	{
		Logger.logMsg(Logger.INFO, "new ControleurNouvelles()");
	}
	public void initialiser()
	{
		
		PokemonDAO dao = new PokemonDAO();
		//dao.detaillerPokemon();
		dao.listerPokemons();
		
		VuePokemon vue = VuePokemon.getInstance();
		vue.afficherPokemon();
		
		
	}

}
