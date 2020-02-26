public class Pokedex {
    private Pokemon[] pokemons;

    public Pokedex() {
        this.pokemons = new Pokemon[151 + 1]; // Il n'y a que 151 pokemons, non?
        ajouter("MissingNo", 0, TableType.SANS_TYPE); // On se reserve l'index 0
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }

    public Pokemon ajouter(String nom, int numero, String type1, String type2) {
        Pokemon p = rechercher(numero);
        if (p != null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p = new Pokemon(nom, numero, TableType.getType(type1), TableType.getType(type2));
        pokemons[numero] = p;
        return p;
    }

    public Pokemon ajouter(String nom, int numero, String type1) {
        return ajouter(nom, numero, type1, TableType.SANS_TYPE);
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1, String type2) {
        Pokemon p1 = rechercher(pokemon.getNumero());
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
