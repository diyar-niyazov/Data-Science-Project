
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Analyzer {

    private static final Game[] games = new Game[16598];
    private static final File CSV_FILE = Paths.get( "assets", "vgsales.csv").toFile();

    public void parseCSV() throws IOException {
        System.out.println(CSV_FILE.toString());
        try (Scanner in = new Scanner(CSV_FILE)) {
            String line;
            int count = 0;
            while (in.hasNextLine()) {
                line = in.nextLine();
                games[count] = new Game(line.split(","));
                count++;
            }
            for (Game game : games) {
                System.out.println(game.toString());
            }
        } catch (IOException e) {
            System.err.println("File doesn't exist.");
        }
    }

}
