import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Analyzer {
    private static ArrayList<Game> data = new ArrayList<>();
    private static final File csvFile = new File("Video Game Sales\\assets\\vgsales.csv\\vgsales.csv");

    public void parseCSV() throws IOException {
        Scanner in = new Scanner(csvFile);
        String line;
        String[] list;
        while(in.hasNextLine()) {
            line = in.nextLine();
            list = line.split(",");
        }
    }
}
