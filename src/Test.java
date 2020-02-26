public class Test {
    private Pokedex dex;
    private Pokemon p;

    public static void main(String[] args) {
        Test t = new Test();

        if (t.testAjouter() || t.testAjouterEvolution()) {
            System.out.println("Tests d'ajout echoues!");
            return;
        }

        System.out.println("Tous les tests reussis!");
    }

    public Test() {
        dex = new Pokedex();
    }

    public boolean testAjouter() {
        if (dex.ajouter("Bulbasaur", 1, "Plante", "Poison") == null)
            return true;
        if (dex.ajouter("Squirtle", 7, "Eau") == null)
            return true;
        p = dex.ajouter("Charmander", 4, "Feu");
        if (p == null)
            return true;
        return false;
    }

    public boolean testAjouterEvolution() {
        p = dex.ajouterEvolution(p, "Charmeleon", 5, "Feu");
        if (p == null)
            return true;
        p = dex.ajouterEvolution(p, "Charizard", 6, "Feu", "Vol");
        if (p == null)
            return true;
        return false;
    }
    
}
