public class Test {
    private Pokedex dex;
    private Pokemon p;

    public static void main(String[] args) {
        Test t = new Test();
        if (t.reset())
            System.out.println("Tests reussis!");
    }

    private boolean reset() {
        dex = new Pokedex();
        return testAjouter();
    }

    private boolean testAjouter() {
        if (dex.ajouter("Bulbasaur", 1, "Plante", "Poison") == null)
            return false;
        if (dex.ajouter("Squirtle", 7, "Eau") == null)
            return false;
        if (dex.ajouter("Charmander", 4, "Feu") == null)
            return false;
        return true;
    }
}
