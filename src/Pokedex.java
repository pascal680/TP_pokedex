public class Pokedex {
    private String region;
    private Pokemon[] pokemons;

    public Pokedex(String region, int nbPokemons) {
        this.region = region;
        this.pokemons = new Pokemon[nbPokemons + 1]; // '+1' pour reserver l'index 0
    }

    public boolean ajouter(Pokemon pokemon) {
        if (pokemons[pokemon.getNumero()] != null)
            return false; // Erreur: Pokemon deja ajoute.

        pokemons[pokemon.getNumero()] = pokemon;
        return true;
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }
}
