
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public class GameList {

    private static final ArrayList<Game> gameList = new ArrayList<>();
    private static final EnumMap<Value, Double> sums = new EnumMap<>(Value.class);
    private static final HashMap<String, Integer> nameFrequencies = new HashMap<>();
    private static final HashMap<String, Integer> platformFrequencies = new HashMap<>();
    private static final HashMap<String, Integer> genreFrequencies = new HashMap<>();
    private static final HashMap<String, Integer> publisherFrequencies = new HashMap<>();

    public static void addGame(Game game) {
        gameList.add(game);

        for (Value value : Value.values()) {
            if (value.isNumeric()) {
                numericIncrement(game, value);
            } else {
                HashMap<String, Integer> map;
                switch (value) {
                    case NAME:
                        map = nameFrequencies;
                        break;
                    case PLATFORM:
                        map = platformFrequencies;
                        break;
                    case GENRE:
                        map = genreFrequencies;
                        break;
                    case PUBLISHER:
                        map = publisherFrequencies;
                        break;
                    default:
                        map = nameFrequencies;
                }
                stringIncrement(game, map, value);
            }
        }
    }

    public static void numericIncrement(Game game, Value value) {
        if (sums.containsKey(value)) {
            sums.put(value, sums.get(value) + game.getNumericValue(value));
        } else {
            sums.put(value, game.getNumericValue(value));
        }
    }

    public static void stringIncrement(Game game, HashMap<String, Integer> map, Value value) {
        if (value == Value.NAME) {
            String name = game.getStringValue(value);
            String[] words = name.split(" ");
            for (String word : words) {
                word = word.replaceAll("\\p{Punct}", "");
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        } else {
            if (map.containsKey(game.getStringValue(value))) {
                map.put(game.getStringValue(value), map.get(game.getStringValue(value)) + 1);
            } else {
                map.put(game.getStringValue(value), 1);
            }
        }
    }

    public static EnumMap<Value, Double> getSums() {
        return sums;
    }

    public static HashMap<String, Integer> getStringSums(Value value) {
        switch(value) {
            case NAME:
                return getNameFrequencies();
            case PLATFORM:
                return getPlatformFrequencies();
            case GENRE:
                return getGenreFrequencies();
            case PUBLISHER:
                return getPublisherFrequencies();
            default:
                return getNameFrequencies();
        }
    }

    public static HashMap<String, Integer> getNameFrequencies() {
        return nameFrequencies;
    }

    public static HashMap<String, Integer> getPlatformFrequencies() {
        return platformFrequencies;
    }

    public static HashMap<String, Integer> getGenreFrequencies() {
        return genreFrequencies;
    }

    public static HashMap<String, Integer> getPublisherFrequencies() {
        return publisherFrequencies;
    }

    public static void printMaps() {
        System.out.println(sums + "\n");
        System.out.println(nameFrequencies + "\n");
        System.out.println(platformFrequencies + "\n");
        System.out.println(genreFrequencies + "\n");
        System.out.println(publisherFrequencies + "\n");
    }

    public static ArrayList<Game> getGameList() {
        return gameList;
    }
}
