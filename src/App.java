
import java.util.List;

import architecture.Controleur;
import architecture.Fenetre;
import donnee.PokemonDAO;
import modele.Pokemon;
import vue.VueListePokemons;
import vue.VuePokemon;

public class App {

	public static void main(String[] parametres) {
		
		PokemonDAO pokemonDAO = new PokemonDAO();
		List<Pokemon> pokemons = pokemonDAO.listerPokemonsAvecDetails();
		for(Pokemon pokemon : pokemons)
		{
			System.out.println(pokemon.getNom());
		}
		
		ChercheurDePokemon chercheurA = new ChercheurDePokemonFeu(pokemons);
		chercheurA.executer();
		ChercheurDePokemon chercheurB = new ChercheurSemantiqueDePokemon(pokemons);
		chercheurB.executer();
		//Controleur.choisirVuePrincipale(VueNouvellesSimple.class);
		//Controleur.choisirVuePrincipale(VuePokemon.class);
		
		//Fenetre.launch(Fenetre.class, parametres);	
	}

}
