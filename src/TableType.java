public class TableType {
    private final static String[] TYPES = {"<Inconnu>",
            "Combat", "Dragon", "Eau", "Electrique", "Feu",
            "Glace", "Insecte", "Normal",  "Plante", "Poison",
            "Psychique", "Roche", "Sol", "Spectre", "Vol"};

    public static String getType(int idType) {
        return TYPES[idType];
    }

    public int[] getFaiblesses(int idType) {
        //TODO Version temporaire, a completer si vous voulez...
        int[] faiblesses = new int[3];
        faiblesses[0] = (idType + 1) % TYPES.length;
        faiblesses[1] = (idType + 3) % TYPES.length;
        faiblesses[2] = (idType + 6) % TYPES.length;
        return faiblesses;
    }
}
