import java.util.ArrayList;
import java.util.List;

import modele.Pokemon;

public class ChercheurDePokemon {
	protected List<Pokemon> tousLesPokemons;
	protected List<Pokemon> selection;
	
	public ChercheurDePokemon(List<Pokemon> pokemon) {
		this.tousLesPokemons = pokemon;
	}
	public void executer() {
		this.selection = filtrerSelonMotsCles(this.tousLesPokemons);
		this.selection = filtrerSelonType(selection);
		this.selection = filtrerSelonCouleur(selection);
	}
	private List<Pokemon> filtrerSelonCouleur(List<Pokemon> pokemons) {
		List<Pokemon> selection = new ArrayList<Pokemon>();
		
		for (Pokemon pokemon: pokemons) {
			selection.add(pokemon);
		}
		return selection;
	}
	private List<Pokemon> filtrerSelonType(List<Pokemon> pokemons) {
		List<Pokemon> selection = new ArrayList<Pokemon>();
		
		for (Pokemon pokemon: pokemons) {
			selection.add(pokemon);
		}
		return selection;
	}
	private List<Pokemon> filtrerSelonMotsCles(List<Pokemon> pokemons) {
		List<Pokemon> selection = new ArrayList<Pokemon>();
		
		for (Pokemon pokemon: pokemons) {
			selection.add(pokemon);
		}
		return selection;
	}
}
