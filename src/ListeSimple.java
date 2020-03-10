public class ListeSimple {
    private Node premier;
    private int nbElements;
    private Node current;


    public ListeSimple() {
        this.premier = null;
        nbElements = 0;
    }

    public boolean addNode(Pokemon pokemon){
        if (premier == null) {
            premier = new Node(pokemon);
            current = premier;
            nbElements++;
            return true;
        }
        current = premier;
        Node nouveauNode = new Node(pokemon);
        while(current!= null){
            Pokemon prochain = current.getProchain().getPokemon();
            if ((current.getPokemon().getNumero() <= pokemon.getNumero()) && (current.getPokemon().getNumero() <= prochain.getNumero())){
                nouveauNode.setProchain(current.getProchain());
                current.setProchain(nouveauNode);
                nbElements++;
                return true;
            }
            current = current.getProchain();
        }
        return false;
    }

    public Node rechercherNoeud(int numPokemon){
        current = premier;
        while(current!= null){
            if (current.getPokemon().getNumero() == numPokemon){
                return current;
            }
            current = current.getProchain();
        }
        return null;
    }

    public Node rechercherNoeud(String nomPokemon){
        current = premier;
        while(current!= null){
            if (current.getPokemon().getNom().equalsIgnoreCase(nomPokemon)){
                return current;
            }
            current = current.getProchain();
        }
        return null;
    }
}
