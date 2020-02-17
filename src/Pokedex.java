public class Pokedex {
    private String region;
    private Pokemon[] pokemons;

    public Pokedex(String region, int nbPokemons) {
        this.region = region;
        this.pokemons = new Pokemon[nbPokemons + 1]; // '+1' pour reserver l'index 0
    }

    public void ajouter(Pokemon pokemon) {
        pokemons[pokemon.getNumero()] = pokemon;
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }
}
