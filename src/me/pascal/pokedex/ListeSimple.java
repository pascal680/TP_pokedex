package me.pascal.pokedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListeSimple {

    private Node premier;

    private int nbElements;

    public boolean add(Pokemon pokemon) {

        if (premier == null) {
            premier = new Node(pokemon);
            nbElements++;
            return true;
        }

        Node current = premier;

        while (current != null) {

            Node prochain = current.prochain;

            if (prochain == null) {
                current.prochain = new Node(pokemon);
                nbElements++;
                return true;
            }
            else if (pokemon.getNumero() < prochain.pokemon.getNumero()) {
                current.prochain = new Node(pokemon, current.prochain);
                nbElements++;
                return true;
            }

            current = current.prochain;
        }

        return false;
    }

    public boolean supprimerNode(int numPokemon) {

        if (premier == null)
            return false;

        Node current = premier;

        if (current.pokemon.getNumero() == numPokemon) {

            premier = premier.prochain;
            nbElements--;
            return true;
        }

        while (current.prochain != null) {

            if (current.prochain.pokemon.getNumero() == numPokemon) {
                current.prochain = current.prochain.prochain;
                return true;
            }

            current = current.prochain;
        }

        return false;
    }

    public boolean supprimerNode(String nomPokemon) {
        if (premier == null)
            return false;

        Node current = premier;

        if (current.pokemon.getNom().equals(nomPokemon)) {

            premier = premier.prochain;
            nbElements--;
            return true;
        }

        while (current.prochain != null) {

            if (current.prochain.pokemon.getNom().equals(nomPokemon)) {
                current.prochain = current.prochain.prochain;
                return true;
            }

            current = current.prochain;
        }

        return false;
    }

    public int getIndexNode(int numPokemon) {

        Node current = premier;

        int index = 1;

        while (current != null) {

            if (current.pokemon.getNumero() == numPokemon)
                return index;

            current = current.prochain;
            index++;
        }

        return -1;
    }

    public int getIndexNode(String nomPokemon) {
        Node current = premier;

        int index = 1;

        while (current != null) {

            if (current.pokemon.getNom().equals(nomPokemon))
                return index;

            current = current.prochain;
            index++;
        }

        return -1;
    }

    public ListeSimple getMemeType(String type){
        int id = TableType.getType(type);

        ListeSimple liste = new ListeSimple();

        Node current = premier;

        while (current != null){
            if(current.pokemon.getType1() == id)
                liste.add(current.pokemon);
            else if(current.pokemon.getType2() == id)
                liste.add(current.pokemon);
            current = current.prochain;
        }
        return liste;
    }

    public Pokemon findByNum(int numPokemon) {
        Node current = premier;
        while (current != null) {
            if (current.pokemon.getNumero() == numPokemon)
                return current.pokemon;
            current = current.prochain;
        }
        return null;
    }

    public Pokemon findByNom(String nomPokemon) {
        Node current = premier;
        while (current != null) {
            if (current.pokemon.getNom().equalsIgnoreCase(nomPokemon))
                return current.pokemon;
            current = current.prochain;
        }
        return null;
    }

    public Pokemon get(int index) {
        Node current = premier;
        if (index > 0 && index <= nbElements) {
            for (int i = 0; i < index; i++) {
                current = current.prochain;
            }
            return current.pokemon;
        }
        return null;
    }

    public void afficherListe() {
        Node current = premier;
        while (current != null) {
            System.out.println(current);
            current = current.prochain;
        }
    }

    private static class Node {

        private Pokemon pokemon;

        private Node prochain;

        private Node(Pokemon pokemon, Node prochain) {
            this.pokemon = pokemon;
            this.prochain = prochain;
        }

        private Node(Pokemon pokemon) {
            this(pokemon, null);
        }

        @Override
        public String toString() {
            return "pokemon: " + pokemon;
        }

    }
}
