public class Pokedex {
    private String region;
    private Pokemon[] pokemons;

    public Pokedex(String region, int nbPokemons) {
        this.region = region;
        this.pokemons = new Pokemon[nbPokemons + 1]; // '+1' pour reserver l'index 0
    }

    public boolean ajouter(Pokemon pokemon) {
        if (rechercher(pokemon.getNumero()) != null)
            return false; // Erreur: Pokemon deja ajoute.

        pokemons[pokemon.getNumero()] = pokemon;
        return true;
    }

    public boolean ajouterEvolution(Pokemon pokemon, Pokemon formeSuivante) {
        Pokemon p1 = rechercher(pokemon.getNumero());
        if (p1 == null)
            return false; // Erreur: Pokemon inconnu.

        Pokemon p2 = rechercher(formeSuivante.getNumero());
        if (p2 == null) {
            ajouter(formeSuivante);
            p2 = formeSuivante;
        }

        p1.setFormeSuivante(p2);
        p2.setFormePrecedente(p1);
        return true;
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }
}
