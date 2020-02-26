public class Pokedex {
    private String region;
    private Pokemon[] pokemons;

    public Pokedex(String region, int nbPokemons) {
        this.pokemons = new Pokemon[nbPokemons + 1]; // '+1' pour reserver l'index 0
        ajouter("MissingNo", 0, Pokemon.SANS_TYPE);
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }

    public Pokemon ajouter(String nom, int numero, int type1, int type2) {
        Pokemon p = rechercher(numero);
        if (p != null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p = new Pokemon(nom, numero, type1, type2);
        pokemons[numero] = p;
        return p;
    }

    public Pokemon ajouter(String nom, int numero, int type1) {
        return ajouter(nom, numero, type1, Pokemon.SANS_TYPE);
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, int type1, int type2) {
        Pokemon p1 = rechercher(pokemon.getNumero());
        if (p1 == null)
            return null; // Erreur: On verifie que le pokemon de base existe deja.

        Pokemon p2 = ajouter(nom, numero, type1, type2);
        if (p2 == null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p1.setEvolution(p2);
        return p2;
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, int type1) {
        return ajouterEvolution(pokemon, nom, numero, type1, Pokemon.SANS_TYPE);
    }
}
