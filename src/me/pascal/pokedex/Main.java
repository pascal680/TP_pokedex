package me.pascal.pokedex;

import java.util.Scanner;

public class Main {
    private static Pokedex dex;

    private static void afficherMenu() {
        System.out.println("================ \n" + "p: afficher le pokedex \n" + "a: ajouter un pokemon \n"
                + "c #: consulter la page d'un pokemon \n" + "e #: voir l'evolution d'un pokemon \n"
                + "r <nom>: rechercher par nom \n" + "t <type>: rechercher par type \n" + "q: quitter");
    }

    public static void main(String[] args) {
        dex = new Pokedex();
        ajouterPokemonsConnus();

        // Variables que l'on va reutiliser souvent.
        Pokemon p;
        String nom;
        int numero;
        String type;

        char requete;
        String entree;
        Scanner scan = new Scanner(System.in);
        do {
            afficherMenu();
            entree = scan.next();
            requete = entree.charAt(0);
            switch (requete) {

                case 'p':
                    dex.afficher(System.out); // System.out c'est un objet, donc on peut le passer en parametre!
                    break;

                case 'a':
                    System.out.print("Entrez son nom: ");
                    nom = scan.next();
                    System.out.print("Entrez son numero: ");
                    numero = scan.nextInt();
                    System.out.print("Entrez son premier type: ");
                    type = scan.next();
                    System.out.print("Entrez son deuxieme type (ou laissez vide): ");
                    scan.nextLine(); // Il faut d'abord se debarasser du \n restant sur l'entree apres next().
                    entree = scan.nextLine();
                    if (entree.isEmpty())
                        p = dex.ajouter(nom, numero, type);
                    else
                        p = dex.ajouter(nom, numero, type, entree);
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
                    Pokemon evolution = p.getEvolution();
                    System.out.print(p.getNom() + " evolue en ");
                    if (evolution == null)
                        System.out.println("rien. " + p.getNom() + " n'a pas d'evolution");
                    else
                        System.out.println(p.getEvolution().getNom());
                    break;

                case 'q':
                    System.out.println("Gotta catch them all!");
                    break;

                default:
                    System.err.println("Option invalide: " + requete);
                    scan.nextLine(); // Reset l'entree.
            }
        } while (requete != 'q');
    }

    private static void ajouterPokemonsConnus() {
        dex.ajouter("Bulbasaur", 1, "Plante", "Poison");
        dex.ajouter("Charmander", 4, "Feu");
        // TODO Ajoutez votre pokemon prefere ici.
        // Au besoin, consultez la liste officielle sur https://pokedex.org/

        Pokemon p1 = dex.ajouter("Squirtle", 7, "Eau");
        Pokemon p2 = dex.ajouterEvolution(p1, "Wartortle", 8, "Eau");
        Pokemon p3 = dex.ajouterEvolution(p2, "Blastoise", 9, "Eau");
    }
}
