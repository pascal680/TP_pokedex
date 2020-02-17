import java.net.PortUnreachableException;

public class Pokemon {
    private String nom;
    private int numero;
    private int type1, type2;
    private Pokemon formePrecedente, formeSuivante;

    public Pokemon(String nom, int numero, int type1, int type2) {
        this.nom = nom;
        this.numero  = numero;
        this.type1 = type1;
        this.type2 = type2;
    }

    public Pokemon(String nom, int numero, int type1) {
        this(nom, numero, type1, 0);
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public Pokemon getFormePrecedente() {
        return formePrecedente;
    }

    public void setFormePrecedente(Pokemon preEvolution) {
        this.formePrecedente = preEvolution;
    }

    public Pokemon getFormeSuivante() {
        return formeSuivante;
    }

    public void setFormeSuivante(Pokemon evolution) {
        this.formeSuivante = evolution;
    }

    public String toString() {
        String str = nom + " #" + numero;
        str += "(" + (type2 > 0 ? "/" + type2 : "") + ")";
        return str;
    }
}
