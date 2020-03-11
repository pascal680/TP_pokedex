import java.io.PrintStream;

public class Pokedex {
    ListeSimple pokemons;

    public Pokedex() {
        pokemons = new ListeSimple(); // Il n'y a que 151 pokemons, non?
        //ajouter("MissingNo", 0, TableType.SANS_TYPE);
    }

    public void afficher(PrintStream out) {
        pokemons.afficherListe();
    }

    public Pokemon rechercher(int numero) {
        return pokemons.rechercherNoeud(numero).getPokemon();
    }

    public Pokemon ajouter(String nom, int numero, String type1, String type2) {
        Pokemon p = pokemons.rechercherNoeud(numero).getPokemon();
        if (p != null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p = new Pokemon(nom, numero, TableType.getType(type1), TableType.getType(type2));
        pokemons.addNode(p);
        return p;
    }

    public Pokemon ajouter(String nom, int numero, String type1) {
        return ajouter(nom, numero, type1, TableType.SANS_TYPE);
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1, String type2) {
        Pokemon p1 = pokemons.rechercherNoeud(pokemon.getNumero()).getPokemon();
        if (p1 == null)
            return null; // Erreur: On verifie que le pokemon de base existe deja.

        Pokemon p2 = ajouter(nom, numero, type1, type2);
        if (p2 == null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p1.setEvolution(p2);
        return p2;
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1) {
        return ajouterEvolution(pokemon, nom, numero, type1, TableType.SANS_TYPE);
    }
}
