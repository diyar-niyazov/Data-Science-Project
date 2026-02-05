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
            data.add(new Game(list[1],
                                Integer.parseInt(list[0]),
                                list[2],
                                Integer.parseInt(list[3]),
                                list[4], list[5],
                                Double.parseDouble(list[6]),
                                Double.parseDouble(list[7]),
                                Double.parseDouble(list[8]),
                                Double.parseDouble(list[9]),
                                Double.parseDouble(list[10])));
        }
    }
}
