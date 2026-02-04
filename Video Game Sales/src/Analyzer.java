
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Analyzer {

    private static final Game[] games = new Game[16600];
    private static final File CSV_FILE = Paths.get("..", "assets", "vgsales.csv").toFile();

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

    /*
     * Pearson's Correlation Coefficient Formula
     *
     * The most commonly used formula for calculating the correlation coefficient is
     * Pearson's Correlation Coefficient, given by:
     *
     * r = [n(Σxy) - (Σx)(Σy)] / √{[n(Σx²) - (Σx)²] [n(Σy²) - (Σy)²]}
     * Copy
     * Where:
     *
     * n is the number of data points.
     *
     * Σxy is the sum of the product of corresponding x and y values.
     *
     * Σx and Σy are the sums of x and y values, respectively.
     *
     *Σx² and Σy² are the sums of the squares of x and y values.
     */

    public int correlationCoefficient(Game[] data) {

        return 0;
    }
}
