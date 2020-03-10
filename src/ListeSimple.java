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

    public Node getElementAt(int index){
        current = premier;
        if (index > 0 && index <= nbElements) {
            for (int i = 0; i <= index; i++) {
                current = current.getProchain();
            }
            return current;
        }
        return null;
    }

    public int getIndexNode(int numPokemon){
        current = premier;
        for (int i = 0; i<= nbElements; i++){
            current = premier;
            if(rechercherNoeud(numPokemon).equals(current)){
                return i;
            }
        }
        return -1;
    }

    public int getIndexNode(String nomPokemon){
        current = premier;
        for (int i = 0; i<= nbElements; i++){
            current = premier;
            if(rechercherNoeud(nomPokemon).equals(current)){
                return i;
            }
        }
        return -1;
    }

    public void supprimerNode(int numPokemon){
        if(getIndexNode(numPokemon)!= -1) {
            Node precedent = getElementAt(getIndexNode(numPokemon) - 1);
            current = getElementAt(getIndexNode(numPokemon));
            Node prochain = current.getProchain();

            precedent.setProchain(prochain);
            nbElements--;
        }
        else {
            System.out.println("Il n'y a rien a supprimer a ce numero de Pokemon");
        }
    }


    public void supprimerNode(String nomPokemon){
        if(getIndexNode(nomPokemon)!= -1) {
            Node precedent = getElementAt(getIndexNode(nomPokemon) - 1);
            current = getElementAt(getIndexNode(nomPokemon));
            Node prochain = current.getProchain();

            precedent.setProchain(prochain);
            nbElements--;
        }
        else {
            System.out.println("Il n'y a rien a supprimer a ce nom de Pokemon");
        }
    }
}
