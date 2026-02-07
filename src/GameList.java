
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public class GameList {

    private static final ArrayList<Game> gameList = new ArrayList<>();
    private static final ArrayList<Integer[]> valuesArray = new ArrayList<>();
    private static final EnumMap<Value, Double> sums = new EnumMap<>(Value.class);
    private static final HashMap<String, Integer> frequency = new HashMap<>();

    public static void addGame(Game game) {
        gameList.add(game);

        for (Value value : Value.values()) {
            if (value.isNumeric()) {
                sums.put(value, game.getNumericValue(value));
            } else {

            }
        }
    }

}
