
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

// Stores a collection of Game objects
// Stores numeric field sums for numeric categories
// Store frequency counts for categorical categories
public class GameList {

    private final ArrayList<Game> games = new ArrayList<>();
    private final EnumMap<CSV_Category, Double> sums = new EnumMap<>(CSV_Category.class);
    private final EnumMap<CSV_Category, HashMap<String, Integer>> frequencies = new EnumMap<>(CSV_Category.class);

    // Initialize categorical maps
    public GameList() {
        frequencies.put(CSV_Category.NAME, new HashMap<>());
        frequencies.put(CSV_Category.PLATFORM, new HashMap<>());
        frequencies.put(CSV_Category.GENRE, new HashMap<>());
        frequencies.put(CSV_Category.PUBLISHER, new HashMap<>());
    }

    // Adds a Game object to the 'games' list and updates all numeric sums and categorical frequencies
    public void addGame(Game game) {
        games.add(game);

        for (CSV_Category value : CSV_Category.values()) {
            if (value.isNumeric()) {
                incrementNumericValue(game, value);
            } else {
                incrementCategoricalValue(game, value);
            }
        }
    }

    // Increments sum with given numeric value
    public void incrementNumericValue(Game game, CSV_Category value) {
        sums.put(value, sums.getOrDefault(value, 0.0) + game.getNumericField(value));
    }

    // Increments frequency with given categorical value
    public void incrementCategoricalValue(Game game, CSV_Category value) {
        HashMap<String, Integer> map = frequencies.get(value);
        String field = game.getCategoricalField(value);
        map.put(field, map.getOrDefault(field, 0) + 1);
    }

    public EnumMap<CSV_Category, Double> getSum() {
        return sums;
    }

    public HashMap<String, Integer> getFrequency(CSV_Category value) {
        return switch (value) {
            case NAME ->
                frequencies.get(value);
            case PLATFORM ->
                frequencies.get(value);
            case GENRE ->
                frequencies.get(value);
            case PUBLISHER ->
                frequencies.get(value);
            default ->
                frequencies.get(value);
        };
    }

    public void printMaps() {
        System.out.println(sums + "\n");
        // System.out.println(frequencies.get(CSV_Category.NAME) + "\n");
        System.out.println(frequencies.get(CSV_Category.PLATFORM) + "\n");
        System.out.println(frequencies.get(CSV_Category.GENRE) + "\n");
        // System.out.println(frequencies.get(CSV_Category.PUBLISHER) + "\n");
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
