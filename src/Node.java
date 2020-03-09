public class Node {
    Pokemon pokemon;
    Node prochain;

    public Node(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.prochain = null;
    }

    public void setProchain(Node prochain) {
        this.prochain = prochain;
    }

    public Node getProchain() {
        return prochain;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    @Override
    public String toString() {
        return "pokemon: " + pokemon;
    }
}
