import java.util.Scanner;

public class Main {
    private static Pokedex dex;

    private static void afficherMenu() {
        System.out.println("================ \n" +
                "a: ajout d'un pokemon \n" +
                "c #: consulter la page d'un pokemon \n" +
                "e #: voir l'evolution \n" +
                "r <nom>: rechercher par nom \n" +
                "t <type>: rechercher par type \n" +
                "q: quitter");
    }

    public static void main(String[] args) {
        dex = new Pokedex("Kanto", 151);
        ajouterPokemon();

        // Variables que l'on va reutiliser souvent.
        Pokemon p;
        String nom;
        int numero;
        int type;

        char requete;
        String entree;
        Scanner scan = new Scanner(System.in);
        do {
            afficherMenu();
            entree = scan.next();
            requete = entree.charAt(0);
            switch (requete) {

                case 'a':
                    System.out.print("Entrez son nom: ");
                    nom = scan.next();
                    System.out.print("Entrez son numero: ");
                    numero = scan.nextInt();
                    System.out.print("Entrez son premier type: ");
                    type = scan.nextInt();
                    System.out.print("Entrez son deuxieme type (ou laissez vide): ");
                    scan.nextLine(); // Il faut d'abord se debarasser du \n restant sur l'entree apres nextInt.
                    entree = scan.nextLine();
                    if (entree.isEmpty())
                        p = dex.ajouter(nom, numero, type);
                    else
                        p = dex.ajouter(nom, numero, type, Integer.parseInt(entree));
                    if (p != null)
                        System.out.println(p + " ajoute!");
                    else
                        System.err.println("Impossible d'ajouter #" + numero);
                    break;

                case 'c':
                    numero = scan.nextInt();
                    p = dex.rechercher(numero);
                    if (p == null)
                        System.out.println("<inconnu>");
                    else
                        System.out.println(p);
                    break;

                case 'e':
                    numero = scan.nextInt();
                    p = dex.rechercher(numero);
                    System.out.print(p.getNom() + " evolue en ");
                    System.out.println(p.getFormeSuivante().getNom());
                    break;

                case 'q':
                    System.out.println("Gotta catch them all!");
                    break;

                default:
                    System.err.println("Option invalide: " + requete);
            }
        } while (requete != 'q');
    }

    private static void ajouterPokemon() {
        dex.ajouter("Bulbasaur", 1, 8, 12);
        dex.ajouter("Charmander", 4, 6);
        //TODO Ajouter votre pokemon prefere ici.

        Pokemon p1 = dex.ajouter("Squirtle", 7, 15);
        Pokemon p2 = dex.ajouterEvolution(p1, "Wartortle", 8, 15);
        Pokemon p3 = dex.ajouterEvolution(p2, "Blastoise", 9, 15);
    }
}
