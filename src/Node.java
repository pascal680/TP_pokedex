public class Node {
    Pokemon pokemon;
    Node precedent;
    Node prochain;

    public void setPrecedant(Node precedent) {
        this.precedent = precedent;
    }

    public void setProchain(Node prochain) {
        this.prochain = prochain;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
