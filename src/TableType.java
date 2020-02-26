import java.util.Arrays;

public class TableType {
    public final static String SANS_TYPE = "<Inconnu>";
    private final static String[] NOMS_TYPES = { SANS_TYPE,     // Type 0
            "Combat", "Dragon", "Eau", "Electrique", "Feu",     // Types 1 a 5
            "Glace", "Insecte", "Normal",  "Plante", "Poison",  // Types 6 a 10
            "Psychique", "Roche", "Sol", "Spectre", "Vol" };    // Types 11 a 15

    public static String getType(int idType) {
        return NOMS_TYPES[idType];
    }

    public static int getType(String nomType) {
        // NOMS_TYPES doit etre en ordre alphabetique pour que la recherche fonctionne.
        int index = Arrays.binarySearch(NOMS_TYPES, nomType);
        return index > 0 ? index : 0;
    }

    public static int[] getFaiblesses(int idType) {
        int[][] faiblesses = { {0}, // <Inconnu>
                {11, 15},           // Combat
                {2, 6},             // Dragon
                {4, 9},             // Eau
                {13},               // Electrique
                {3, 12, 13},        // Feu
                {1, 5, 12},         // Glace
                {5, 12, 15},        // Insecte
                {1},                // Normal
                {5, 6, 7, 10, 15},  // Plante
                {11, 13},           // Poison
                {7, 14},            // Psychique
                {1, 3, 9, 13},      // Roche
                {3, 6, 9},          // Sol
                {14},               // Spectre
                {4, 6, 12}          // Plante
        };
        return faiblesses[idType];
    }
}
