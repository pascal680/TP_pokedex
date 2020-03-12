package me.pascal.pokedex;

import java.io.PrintStream;

public class Pokedex {

    ListeSimple pokemons;

    public Pokedex() {
        pokemons = new ListeSimple();
    }
    public String[] getFaiblesses(int numPokemon) {

        Pokemon pokemon = pokemons.findByNum(numPokemon);

        int[] fId1 = TableType.getFaiblesses(pokemon.getType1());
        int[] fId2 = TableType.getFaiblesses(pokemon.getType2());

        String[] faiblesses = new String[fId1.length + fId2.length];

        int index = 0;

        for(int i = 0; i < fId1.length; i++, index++) {
            faiblesses[index] = TableType.getType(fId1[i]);
        }

        if (fId2[0]!= 0) {
            for (int i = 0; i < fId2.length; i++, index++) {
                faiblesses[index] = TableType.getType(fId2[i]);
            }
        }

        return faiblesses;
    }

    public void afficher(PrintStream out) {
        pokemons.afficherListe();
    }

    public Pokemon rechercher(int numero) {
        return pokemons.findByNum(numero);
    }

    public Pokemon ajouter(String nom, int numero, String type1, String type2) {

        if (pokemons.findByNum(numero) != null)
            return null;

        Pokemon pokemon = new Pokemon(nom, numero, TableType.getType(type1), TableType.getType(type2));
        pokemons.add(pokemon);
        return pokemon;
    }

    public Pokemon ajouter(String nom, int numero, String type1) {
        return ajouter(nom, numero, type1, TableType.SANS_TYPE);
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1, String type2) {
        Pokemon p1 = pokemons.findByNum(pokemon.getNumero());

        if (p1 == null)
            return null;

        Pokemon p2 = ajouter(nom, numero, type1, type2);

        if (p2 == null)
            return null;

        p1.setEvolution(p2);
        return p2;
    }

    public void afficherMemeType (String type){
        ListeSimple liste = pokemons.getMemeType(type);
        liste.afficherListe();
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1) {
        return ajouterEvolution(pokemon, nom, numero, type1, TableType.SANS_TYPE);
    }

    public Pokemon findByName(String nom){
        return pokemons.findByNom(nom);
    }
}
