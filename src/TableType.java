public class TableType {
    private final static String[] types = {"<Missing>", "Bug", "Dragon", "Electric",
             "Ice", "Fighting", "Fire", "Flying", "Grass", "Ghost", "Ground",
            "Normal", "Poison", "Psychic", "Rock", "Water"};

    public static String getType(int idType) {
        return types[idType];
    }

    public int[] getFaiblesses(int idType) {
        // TODO Version temporaire, a completer si vous voulez...
        int[] faiblesses = new int[3];
        faiblesses[0] = (idType + 1) % types.length;
        faiblesses[0] = (idType + 3) % types.length;
        faiblesses[0] = (idType + 5) % types.length;
        return faiblesses;
    }
}
