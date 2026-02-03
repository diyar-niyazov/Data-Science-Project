import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Analyzer {
    private static Game[] data;
    private static final File csvFile = new File("Video Game Sales\\assets\\vgsales.csv\\vgsales.csv");

    public void parseCSV() throws IOException {
        Scanner in = new Scanner(csvFile);
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
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
