import java.util.Scanner;

public class Main {
    private static Pokedex dex;

    public static void afficherMenu() {
        System.out.println("================ \n"+
                "a: ajout d'un pokemon \n"+
                "c #: consulter la page d'un pokemon \n"+
                "e #: voir l'evolution \n"+
                "r: rechercher par nom \n"+
                "t: rechercher par type \n"+
                "q: quitter");
    }

    public static void main(String[] args) {
        dex = new Pokedex("Kanto", 151);
        ajouterPokemon();

        // Variables que l'on va reutiliser souvent.
        Pokemon p;
        String nom;
        int numero;
        int type1, type2;

        char requete;
        String entree;
        Scanner scan = new Scanner(System.in);
        do {
            afficherMenu();
            entree = scan.nextLine();
            requete = entree.charAt(0);
            switch(requete) {

                case 'a':
                    System.out.print("Entrez son nom: ");
                    nom = scan.next();
                    System.out.print("Entrez son numero: ");
                    numero = scan.nextInt();
                    System.out.print("Entrez son premier type: ");
                    type1 = scan.nextInt();
                    System.out.print("Entrez son deuxieme type (ou laissez vide): ");
                    scan.nextLine(); // Il faut d'abord se debarasser du \n restant sur l'entree apres nextInt.
                    String next = scan.nextLine();
                    if (next.isEmpty())
                        type2 = 0;
                    else
                        type2 = Integer.parseInt(next);
                    p = new Pokemon(nom, numero, type1, type2);
                    if(dex.ajouter(p))
                        System.out.println(p + " ajoute!");
                    else
                        System.err.println("Impossible d'ajouter " + p);
                    break;

                case 'c':
                    numero = Integer.parseInt(entree.substring(2));
                    p = dex.rechercher(numero);
                    if (p == null)
                        System.out.println("<inconnu>");
                    else
                        System.out.println(p);
                    break;

                case 'e':
                    numero = Integer.parseInt(entree.substring(2));
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
        dex.ajouter(new Pokemon("Bulbasaur", 1, 8, 12));
        dex.ajouter(new Pokemon("Charmander", 4, 6));
        // TODO Ajoutez votre pokemon prefere ici.

        Pokemon p1 = new Pokemon("Squirtle", 7, 15);
        Pokemon p2 = new Pokemon("Wartortle", 8, 15);
        Pokemon p3 = new Pokemon("Blastoise", 9, 15);

        dex.ajouter(p1);
        dex.ajouterEvolution(p1, p2);
        dex.ajouterEvolution(p2, p3);
    }
}
