public class Pokedex {
    private String region;
    private Pokemon[] pokemons;

    public void ajouter(Pokemon pokemon) {
        pokemons[pokemon.getNumero()] = pokemon;
    }

    public Pokemon rechercher(int numero) {
        return pokemons[numero];
    }
}
