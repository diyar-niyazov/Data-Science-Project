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
        while(in.hasNextLine()) {

        }
    }
}
