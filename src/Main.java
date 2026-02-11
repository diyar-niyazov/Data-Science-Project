
import java.util.ArrayList;

// Made by Diyar Niyazov and Isaac Novak
// For Mr. Wuest's 3AC Data Structures and Algorithms

public class Main {

    public static void main(String[] args) {

        ArrayList<String[]> valuesArray = new CSV_Parser("vgsales.csv").getValueArray();
        for (String[] values : valuesArray) {
            Game newGame = new Game(values);
            GameList.addGame(newGame);
        }

        String[] valueNames = {"Rank", "Year", "NA Sales", "EU Sales", "JP Sales", "Other Sales", "Global Sales"};

        Display.draw(new CorrelationCalculator(GameList.getGameList()).getCorrelationCoefficients(), valueNames);
        GameList.printMaps();

    }
}
