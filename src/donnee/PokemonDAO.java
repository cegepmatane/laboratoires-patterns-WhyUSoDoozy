package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Pokemon;

public class PokemonDAO {
	
	public Pokemon detaillerPokemon(String nom)
	{
		System.out.println("PokemonDAO.detaillerPokemon()");
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/" + nom;
		String json = null;
		try {
			URL url = new URL(URL_POKEMON);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			System.out.println(json);
			lecteur.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(json == null) return null;
		
		// (2) Parser les données recues en XML ou JSON

		Pokemon pokemon = new Pokemon();
		
		JsonParser parseur = new JsonParser();
		JsonObject document = parseur.parse(json).getAsJsonObject();
		
		int baseExperience = document.get("base_experience").getAsInt();
		System.out.println(baseExperience);
		pokemon.setExperience(baseExperience);
		
	    JsonArray listeMovesJson = document.get("moves").getAsJsonArray();
	    JsonObject moveJson = listeMovesJson.get(0).getAsJsonObject().get("move").getAsJsonObject();
	    String move = moveJson.get("name").getAsString();
	    System.out.println(move); 
		return pokemon;
	}
	
	public List<Pokemon> listerPokemons()
	{
		System.out.println("PokemonDAO.listerPokemons()");
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=100";
		String json = null;
		try {
			URL url = new URL(URL_POKEMON);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			System.out.println(json);
			lecteur.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(json == null) return null;
		
		// (2) Parser les données recues en XML ou JSON

		JsonParser parseur = new JsonParser();
		JsonObject document = parseur.parse(json).getAsJsonObject();
		JsonArray resultatsJson = document.get("results").getAsJsonArray();
		
		for(JsonElement pokemonElement : resultatsJson)
		{
			JsonObject pokemonJson = pokemonElement.getAsJsonObject();
			
			String nom = pokemonJson.get("name").getAsString();
			System.out.println(nom);
			//String url = pokemonJson.get("url").getAsString();			
			
			Pokemon pokemon = new Pokemon();
			pokemon.setNom(nom);
			pokemons.add(pokemon);
		}
		
		return pokemons;
	}
	
	protected String telechargerJson(String adresse)
	{
		String json = null;
		try {
			URL url = new URL(adresse);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			System.out.println(json);
			lecteur.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(json == null) return null;
		return json;
	}
	
	public List<Pokemon> listerPokemonsAvecDetails()
	{
		System.out.println("PokemonDAO.listerPokemons()");
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		
		// (1) ALLER chercher le flux de données sur internet
		
		String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=10";
		String json = telechargerJson(URL_POKEMON);
		
		// (2) Parser les données recues en XML ou JSON

		JsonParser parseur = new JsonParser();
		
		JsonObject document = parseur.parse(json).getAsJsonObject();
		JsonArray resultatsJson = document.get("results").getAsJsonArray();
		
		for(JsonElement pokemonElement : resultatsJson)
		{
			JsonObject pokemonJson = pokemonElement.getAsJsonObject();
			
			String nom = pokemonJson.get("name").getAsString();
			System.out.println(nom);
			String url = pokemonJson.get("url").getAsString();
			
			//String url = pokemonJson.get("url").getAsString();			
			
			Pokemon pokemon = new Pokemon();
			pokemon.setNom(nom);
			pokemon.setSource(url);
			pokemons.add(pokemon);
		}
		System.out.println("TELECHARGER CHAQUE POKEMON");
		
		for(Pokemon pokemon:pokemons)
		{
			System.out.println(pokemon.getNom());
			String url = pokemon.getSource();
			String jsonPokemon = telechargerJson(url);
			System.out.println(jsonPokemon);
			JsonObject pokemonJsonObject = parseur.parse(jsonPokemon).getAsJsonObject();
			System.out.println(pokemonJsonObject);
			System.out.println(pokemonJsonObject.get("base_experience"));
			String experience = pokemonJsonObject.get("base_experience").getAsString();
			pokemon.setExperience(Integer.parseInt(experience));
			String poids = pokemonJsonObject.get("weight").getAsString();
			pokemon.setExperience(Integer.parseInt(poids));
			String hauteur = pokemonJsonObject.get("height").getAsString();
			pokemon.setExperience(Integer.parseInt(hauteur));
			String ordre = pokemonJsonObject.get("order").getAsString();
			pokemon.setExperience(Integer.parseInt(ordre));
		}
		
		return pokemons;
	}

}
