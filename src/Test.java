import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Test {
    private Pokedex dex;
    private Pokemon p;

    public static void main(String[] args) {
        Test t = new Test();

        if (t.testAjouter() || t.testAjouterEvolution()) {
            System.out.println("Tests d'ajout echoues!");
            // Conseil: Utilisez le debogueur pour cibler quel test echoue.
            return;
        }

        if (t.testAfficher()) {
            System.out.println("Test d'affichage echoue!");
            // Conseil: N'oubliez pas que l'affichage doit etre en ordre du numero des pokemons.
            return;
        }

        if (t.testRechercher()) {
            System.out.println("Tests de recherche echoues!");
            // Conseil: Ajoutez des tests pour la recherche par nom et par type ici.
            return;
        }

        System.out.println("Tous les tests reussis!");
    }

    public Test() {
        dex = new Pokedex();
    }

    public boolean testAjouter() {
        p = dex.ajouter("Bulbasaur", 1, "Plante", "Poison");
        if (p == null)
            return true;

        p = dex.ajouter("Squirtle", 7, "Eau");
        if (p == null || p.getNom() != "Squirtle")
            return true;

        p = dex.ajouter("Charmander", 4, "Feu");
        if (p == null || p.getNumero() != 4)
            return true;

        return false;
    }

    public boolean testAjouterEvolution() {
        Pokemon p2 = dex.ajouterEvolution(p, "Charmeleon", 5, "Feu");
        if (p2 == null || p2.getNumero() != 5)
            return true;

        p = dex.ajouterEvolution(p2, "Charizard", 6, "Feu", "Vol");
        if (p == null || p2.getEvolution() != p)
            return true;

        return false;
    }

    public boolean testAfficher() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        dex.afficher(new PrintStream(out));

        int last = -1;
        Scanner scan = new Scanner(out.toString());
        while (scan.hasNext()) {
            String s = scan.next();
            int num = Integer.parseInt(s.substring(1));
            if (num > last)
                last = num;
            else
                return true;
            scan.nextLine();
        }

        return false;
    }

    public boolean testRechercher() {
        p = dex.rechercher(1);
        if (p == null || p.getNom() != "Bulbasaur")
            return true;

        p = dex.rechercher(7);
        if (p == null || p.getNumero() != 7)
            return true;

        p = dex.rechercher(5);
        if (p == null || p.getNumero() != 5)
            return true;

        return false;
    }
}
