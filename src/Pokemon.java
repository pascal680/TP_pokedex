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

    public String toString() {
        String str = nom + " #" + numero;
        str += "(" + type1 + "+" + type2 + ")";
        return str;
    }
}
