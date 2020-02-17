import java.util.Scanner;

public class Main {

    private static Pokedex dex;

    public static void afficherMenu() {
        System.out.println("================ \n"+
                "a: ajout d'un pokemon \n"+
                "c: consulter la page d'un pokemon \n"+
                "e: voir l'evolution \n"+
                "r: rechercher par nom \n"+
                "t: rechercher par type \n"+
                "q: quitter");
    }

    public static void main(String[] args) {
        dex = new Pokedex("Kanto", 151);
        ajouterPokemon();
        afficherMenu();

        Pokemon p;
        String nom;
        int numero;
        int type1, type2;

        char requete;
        Scanner scan = new Scanner(System.in);
        requete = scan.next().charAt(0);
        while(requete != 'q'){
            switch(requete)
            {
                case 'a':
                    System.out.println("Entrez son nom");
                    nom = scan.next();
                    System.out.println("Entrez son numero");
                    numero = Integer.parseInt(scan.next());
                    System.out.println("Entrez son premier type");
                    type1 = Integer.parseInt(scan.next());
                    System.out.println("Entrez son deuxieme type (ou 0)");
                    type2 = Integer.parseInt(scan.next());
                    p = new Pokemon(nom, numero, type1, type2);
                    if(!dex.ajouter(p))
                        System.err.println("Impossible d'ajouter " + p);
                    break;
                case 'c':
                    System.out.println("Entrez son numero");
                    numero = Integer.parseInt(scan.next());
                    System.out.println(dex.rechercher(numero));
                    break;
                case 'e':
                    System.out.println("Entrez son numero");
                    numero = Integer.parseInt(scan.next());
                    p = dex.rechercher(numero);
                    System.out.print(p.getNom() + " evolue en ");
                    System.out.println(p.getFormeSuivante().getNom());
                    break;
                default:
                    System.err.println("Option invalide: " + requete);
            }

            afficherMenu();
            requete = scan.next().charAt(0);
        }

        System.out.println("Gotta catch them all!");
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
